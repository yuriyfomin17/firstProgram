package learningThreads;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Bank {

    private final double[] accounts;
    private final Lock bankLock = new ReentrantLock();
    /**
     * Constructs the bank.
     * @param n the number of accounts
     * @param initialBalance the initial balance for each account */
    public Bank(int n, double initialBalance)
    {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    /**
     * Transfers money from one account to another. * @param from the account to transfer from
     * @param to the account to transfer to
     * @param amount the amount to transfer
     */
    public  void transfer(int from, int to, double amount)
    {
        bankLock.lock(); // a ReentrantLock object
        try {
            if (accounts[from] < amount) return; System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to); accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
        } finally {
            bankLock.unlock(); // make sure the lock is unlocked even if an exception is thrown
        }

    }

    /**
     * Transfers money from one account to another. * @param from the account to transfer from
     * @param to the account to transfer to
     * @param amount the amount to transfer
     *
     *  Implemented using synchronized word
     */
    public synchronized void transfer2(int from, int to, double amount)
    {
        try {
            // For now answer for q question "Why do we need wait and notifyAll in synchronized block -> Thread can be preempted  and wait and notify all avoid this thing"
            //
            // So for me the main question is why do we need wait and notifyAll inside synchronized block if anyway only one thread will be in this block.
            // Hence, other thread can't enter in this block. So instead just use if (accounts[from] < amount) return;
            while (accounts[from] < amount) {
//                System.out.println(Thread.currentThread().getName());
//                System.out.println("Account from" +  (from + 1));
                wait(); // wait on intrinsic object lock's single condition
            }
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to); accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
            getAccountsBalance();
            notifyAll(); // notify all threads waiting on the condition
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }



    /**
     * Gets the sum of all account balances. * @return the total balance
     */
    public double getTotalBalance() {
        double sum = 0;
        for (double a : accounts) sum += a;
        return sum;
    }

    /**
     * Gets the sum of all account balances. * @return the total balance
     */
    public void getAccountsBalance() {
        int counter = 1;
        for(double accountBalance: accounts){
            System.out.printf("Account %d has %10.2f\n", counter, accountBalance);
            counter+=1;
        }
    }




    /**
     * Gets the number of accounts in the bank. * @return the number of accounts
     */
    public int size() { return accounts.length; }

}


// Is using synchronized word worth it? Actually, it worth it since with the modern technologies there is plenty of room for error
//
// * Today, most computers have processors  with its own cache memory. Hence, threads running on different processors can have its own noation of object which are stored in cache memory
//
// * Compilers  can reorder instructions for maximum throughput. Compilers won't reorder instructions that change the result of program execution
// However, they do assume that memory values are only changed when there are explicit instructions for it. At the same time memory value can be changed
// by another thread.
