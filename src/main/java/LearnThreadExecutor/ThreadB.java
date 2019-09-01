package LearnThreadExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadB implements Runnable {

    private static volatile AtomicInteger Integer = null;

    public static volatile ExecutorService Pool = null;

    public ThreadB(AtomicInteger integer,ExecutorService pool) {
        Integer = integer;
        Pool = pool;
    }

    @Override
    public void run() {
        while(Integer.get() < 100){
            System.out.print("thread No2 run" + Integer.getAndIncrement() + "\n");
        }
    }
}
