package algoAssignments;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public  class TradeSimulator {
    static int counter = 1;
    static final Lock lock = new ReentrantLock();
    public static void main(String[] args) {
        TradeCounter tradeSimulator = new TradeSimulator.TradeCounter();
        Runnable trade1 =  new Runnable() {
            @Override
            public void run() {
                try {
                    while (true){
                        tradeSimulator.incrementCounter("Trade1");
                    }

                } catch (Exception e) {
                }
            }
        };
        Runnable trade2 =  new Runnable() {
            @Override
            public void run() {
                try {
                    while (true){
                        tradeSimulator.incrementCounter("Trade2");

                    }

                } catch (Exception e) {
                }
            }
        };

        Runnable trade3 =  new Runnable() {
            @Override
            public void run() {
                try {
                    while (true){
                        tradeSimulator.incrementCounter("Trade3");

                    }

                } catch (Exception e) {
                }
            }
        };

        Runnable trade4 =  new Runnable() {
            @Override
            public void run() {
                try {
                    while (true){
                        tradeSimulator.incrementCounter("Trade4");
                    }


                } catch (Exception e) {
                }
            }
        };
        Thread thread1 = new Thread(trade1);
        Thread thread2 = new Thread(trade2);
        Thread thread3 = new Thread(trade3);
        Thread thread4 = new Thread(trade4);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();


    }
    public static class TradeCounter{
        public synchronized void incrementCounter (String tradeId){
            try {
                while (!lock.tryLock()){
                    Thread.currentThread().wait();
                }
                counter +=1;
                if (counter > 5) counter = 1;
                System.out.printf("%s= %d\n",  tradeId, counter);

            } catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
                notifyAll();
            }

        }
    }

}
