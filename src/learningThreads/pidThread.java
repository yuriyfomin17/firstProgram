package learningThreads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class pidThread {
    static Lock lock1 = new ReentrantLock();
    public static void main(String[] args) {
//        code underneath shows that threads have their own hierarchy
        Thread currentThread = Thread.currentThread();
        ThreadGroup threadGroup = currentThread.getThreadGroup();
        System.out.println("Thread: " + currentThread.getName());
        System.out.println("Thread Group: " + threadGroup.getName());
        System.out.println("Parent Group: " + threadGroup.getParent().getName());
//        each thread has its own exception handler

        Thread th = Thread.currentThread();
        th.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Возникла ошибка: " + e.getMessage());
            }
        });
//        System.out.println(2/0);
        Runnable task = () -> {
            while(!Thread.currentThread().isInterrupted()) {
                //Do some work
            }
            System.out.println("Finished");
        };
        Thread thread = new Thread(task);
        thread.start();
        thread.interrupt();

//        Object lock = new Object();
//
//        Runnable task2 = () -> {
//            synchronized (lock) {
//                System.out.println("thread");
//            }
//        };
//
//        Thread th1 = new Thread(task2);
//        th1.start();
//        synchronized (lock) {
//            for (int i = 0; i < 8; i++) {
//                try{
//                    Thread.sleep(1000);
//                } catch (Exception e){
//                    e.printStackTrace();
//                }
//
//                System.out.print("  " + i);
//            }
//            System.out.println(" ...");
//        }

        Object lock2 = new Object();
        // task будет ждать, пока его не оповестят через lock
        Runnable task3 = () -> {
            synchronized(lock2) {
                try {
                    lock2.wait();
                } catch(InterruptedException e) {
                    System.out.println("interrupted");
                }
            }
            // После оповещения нас мы будем ждать, пока сможем взять лок
            System.out.println("thread");
        };
        Thread taskThread = new Thread(task3);
        taskThread.start();
        // Ждём и после этого забираем себе лок, оповещаем и отдаём лок
        try{
            Thread.sleep(3000);
        } catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("main");
        synchronized(lock2) {
            lock2.notify();
        }

        Lock lock4 = new ReentrantLock();
        Runnable task4 = () -> {
            lock4.lock();
            System.out.println("task4");
//            lock4.unlock();
        };

        Runnable task5 = () -> {
            lock4.lock();
            System.out.println("task5");
            lock4.unlock();
        };

        Thread th4 = new Thread(task4);
        th4.start();

        Thread th5 = new Thread(task5);
        th5.start();
//        lock4.lock();
//
//        Thread th4 = new Thread(task4);
//        th4.start();
//        System.out.println("MAIN");
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        lock4.unlock();
    }
}
