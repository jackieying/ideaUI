package LearnCondition;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadC implements Runnable {

    private static Condition A = null;
    private static Condition B = null;
    private static Condition C = null;
    private volatile static Lock Lock = null;
    private static volatile AtomicInteger Integer = null;

    public ThreadC(Condition a, Condition b, Condition c, AtomicInteger integer, Lock lock) {
        A = a;
        B = b;
        C = c;
        Integer = integer;
        this.Lock = lock;
    }

    @Override
    public void run() {
        Lock.lock();
        try {
            while (Integer.get() < 100) {
                //System.out.print("thread a begin \n");
                //System.out.print("thread a lock \n");
                if (Integer.get() % 3 == 2) {
                    System.out.print("thread No3 run" + Integer.incrementAndGet() + "\n");
                    A.signal();
                } else {
                    C.await();
                }
                //lock.unlock();
                //System.out.print("thread a end \n");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            Lock.unlock();
        }
    }

}
