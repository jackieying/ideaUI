package LearnThreadExecutor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadA implements Runnable {

    private static volatile AtomicInteger Integer = null;

    public static volatile ExecutorService Pool = null;

    public static BlockingQueue<Runnable> Queue = new LinkedBlockingQueue<Runnable>();


    public ThreadA(AtomicInteger integer, ExecutorService pool) {
        Integer = integer;
        Pool = pool;
    }

    @Override
    public void run() {
        while (Integer.get() < 100) {
            if (Integer.get() % 3 == 0) {
                System.out.print("thread No1 run" + Integer.getAndIncrement() + "\n");
            }
        }
    }
}
