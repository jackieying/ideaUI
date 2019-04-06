package LearnThreadExecutor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class singleThreadExecutorTest {

    private static volatile AtomicInteger integer = new AtomicInteger(0);

    public static volatile ThreadPoolExecutor Pool = null;

    public static BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();

    public static void main(String[] args) {


        Pool = new ThreadPoolExecutor(
                1, 100, 0L, TimeUnit.SECONDS, queue, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r);
            }
        }, new ThreadPoolExecutor.AbortPolicy());

        ThreadA aTask = new ThreadA(integer, Pool);
        ThreadB bTask = new ThreadB(integer, Pool);
        ThreadC cTask = new ThreadC(integer, Pool);

        Thread a = new Thread(aTask);
        Thread b = new Thread(bTask);
        Thread c = new Thread(cTask);

        Pool.execute(a);

        while (integer.get() < 100) {
            if (integer.get() % 3 == 1) {
                queue.offer(b);
                queue.offer(c);
                queue.offer(a);
            }
        }
    }
}
