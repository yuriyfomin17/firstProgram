package learningThreads;

public class learningThreads {

    static class MoneyTransfer{
        public static void main(String[] args) {

            Bank bank = new Bank(4, 100000);
            final int  STEPS = 100;
            // With MAX_AMOUNT set to 1000 there is a small chance that we will enter the deadlock because
            // at least one account will have 1000  to transfer to next account
//            final double MAX_AMOUNT = 1000;
            final double MAX_AMOUNT = 50000;
            final int DELAY = 10;

//           You can create the instance of class that implements Runnable interaface via anonymous class
            Runnable task1 = new Runnable() {
                @Override
                public void run() {
                    try{
                        for (int i = 0; i < STEPS; i++) {
                            System.out.println(i);
                            double amount = MAX_AMOUNT * Math.random();
                            bank.transfer2(0, 1, amount);
                            Thread.sleep((int) (DELAY * Math.random()));
                        }
                    } catch (Exception e){
                        e.printStackTrace();
                    }

                }
            };
//          You can create instance of class that implements Runnable interface via lambda expression
            Runnable task2 = ()-> {
                try {
                    for (int i = 0; i < STEPS; i++) {
                        System.out.println(i);
                        double amount = MAX_AMOUNT * Math.random();
                        bank.transfer2(2, 3, amount);
                        Thread.sleep((int) (DELAY * Math.random()));
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }

            };
            Thread thread1 = new Thread(task1);
            Thread thread2 = new Thread(task2);
            thread1.setName("BankThread1");
            thread2.setName("BankThread2");
//            System.out.println(thread1.getState());
            thread1.start();
//            System.out.println(thread1.getState());
            thread2.start();
        }
    }
}
