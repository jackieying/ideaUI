package LearnSemaphere;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class SyncThreadTest {

    private static Semaphore A = new Semaphore(1);
    private static Semaphore B = new Semaphore(1);
    private static Semaphore C = new Semaphore(1);

    private static volatile AtomicInteger integer = new AtomicInteger(1);

    public static void main(String[] args) {

        ThreadA aTask = new ThreadA(
                SyncThreadTest.A, SyncThreadTest.B, SyncThreadTest.C, integer);
        ThreadB bTask = new ThreadB(
                SyncThreadTest.A, SyncThreadTest.B, SyncThreadTest.C, integer);
        ThreadC cTask = new ThreadC(
                SyncThreadTest.A, SyncThreadTest.B, SyncThreadTest.C, integer);

        Thread a = new Thread(aTask);
        Thread b = new Thread(bTask);
        Thread c = new Thread(cTask);
        try {
            B.acquire();
            C.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a.start();
        b.start();
        c.start();
    }
}
