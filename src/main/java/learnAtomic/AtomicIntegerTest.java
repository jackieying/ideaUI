package learnAtomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

    public final static AtomicInteger TEST_ATOMIC_INTEGER = new AtomicInteger(1);

    private volatile static int idxInt = 1;

    public static void main(String[] args) {
        final CountDownLatch startCountDown = new CountDownLatch(10);
        final Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread() {
                @Override
                public void run() {
                    for (int j = 0; j < 100; j++) {
                        idxInt++;
                        TEST_ATOMIC_INTEGER.incrementAndGet();
                    }
                }
            };
            threads[i].start();
            startCountDown.countDown();
        }
        try {
//            Thread.sleep(10000);
            startCountDown.await();
            System.out.printf(Thread.currentThread().getName()+"");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        System.out.println("Atomic最终运行结果：" + TEST_ATOMIC_INTEGER.get());
        System.out.println("valatile 最终运行结果：" + idxInt);
    }
}
