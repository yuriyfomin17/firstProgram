package learningThreads;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

class Clock implements Runnable
{
    public void run()
    {
        Thread current = Thread.currentThread();

        while (!current.isInterrupted())
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(current.isInterrupted());
            }
            System.out.println("Tik");
        }
    }
    public static void main(String[] args)
    {
        Clock clock = new Clock();
        Thread thread = new Thread(clock);
        thread.start();
        try {
            Thread.sleep(10_000);
            thread.interrupt();
        } catch (InterruptedException interruptedException){
            Thread.currentThread().interrupt();
        }
    }

    public static void testThreadPoolExecutor(){
        ThreadPoolExecutor executor =
                (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        Date before = new Date();
        executor.submit(() -> {
            Thread.sleep(1000);
            return null;
        });
        executor.submit(() -> {
            Thread.sleep(1000);
            return null;
        });
        executor.submit(() -> {
            Thread.sleep(1000);
            return null;
        });
        while (executor.getQueue().size() != 0){
            System.out.println(executor.getPoolSize());
            System.out.println(executor.getQueue().size());
        }
        Date after = new Date();
        System.out.println(after.getTime() - before.getTime());

    }


}
