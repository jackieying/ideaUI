package LearnThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintSequenceThread implements Runnable {

    private static final Lock LOCK = new ReentrantLock();

    private static Condition condition = PrintSequenceThread.LOCK.newCondition();

    /**
     * 当前即将打印的数字
     */
    private static int current = 0;

    /**
     * 当前线程编号，从0开始
     */
    private int threadNo;

    /**
     * 线程数量
     */
    private int threadCount;

    /**
     * 打印的最大数值
     */
    private int max;

    public PrintSequenceThread(int threadNo, int threadCount, int max) {
        this.threadNo = threadNo;
        this.threadCount = threadCount;
        this.max = max;
    }

    @Override
    public void run() {
        while (true) {
            LOCK.lock();
            // 判断是否轮到当前线程执行
            while (current % threadCount != threadNo) {
                if (current > max) {
                    break;
                }
                try {
                    // 如果不是，则当前线程进入wait
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 最大值跳出循环
            if (current > max) {
                break;
            }
            System.out.println("thread-" + threadNo + " : " + current);
            current++;
            // 唤醒其他wait线程

            condition.signalAll();
            LOCK.unlock();
        }
    }

    public static void main(String[] args) {
        int threadCount = 3;
        int max = 100;
        for (int i = 0; i < threadCount; i++) {
            new Thread(new PrintSequenceThread(i, threadCount, max)).start();
        }
    }
}
