package LearnSemaphere;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadA implements Runnable {

    private static Semaphore A = new Semaphore(1);
    private static Semaphore B = new Semaphore(1);
    private static Semaphore C = new Semaphore(1);

    private static volatile AtomicInteger Integer = new AtomicInteger(1);


    public ThreadA(Semaphore a, Semaphore b, Semaphore c, AtomicInteger integer) {
        A = a;
        B = b;
        C = c;
        Integer = integer;
    }

    @Override
    public void run() {
        try {
            while (Integer.get() < 100) {
                A.acquire();
                System.out.print("thread No1 run" + Integer.getAndIncrement() + "\n");
                B.release();
            }
        } catch (
                InterruptedException e)

        {
            e.printStackTrace();
        }
    }
}
