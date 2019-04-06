package LearnThreadExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadC implements Runnable {

    private static volatile AtomicInteger Integer = null;

    public static volatile ExecutorService Pool = null;

    public ThreadC(AtomicInteger integer,ExecutorService pool) {
        Integer = integer;
        Pool = pool;
    }

    @Override
    public void run() {
        while(Integer.get() < 100){
            System.out.print("thread No3 run" + Integer.getAndIncrement() + "\n");
        }
    }

}
