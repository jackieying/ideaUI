package LearnCondition;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SyncThreadTestReentrantLockCondition {

    private final static Lock lock = new ReentrantLock();
    private static int state = 0;
    private static Condition A = lock.newCondition();
    private static Condition B = lock.newCondition();
    private static Condition C = lock.newCondition();
    private static volatile AtomicInteger integer = new AtomicInteger(0);


    public static void main(String[] args) {

        ThreadA aTask = new ThreadA(
                SyncThreadTestReentrantLockCondition.A,
                SyncThreadTestReentrantLockCondition.B,
                SyncThreadTestReentrantLockCondition.C,
                integer, lock);
        ThreadB bTask = new ThreadB(
                SyncThreadTestReentrantLockCondition.A, SyncThreadTestReentrantLockCondition.B, SyncThreadTestReentrantLockCondition.C, integer, lock);
        ThreadC cTask = new ThreadC(
                SyncThreadTestReentrantLockCondition.A, SyncThreadTestReentrantLockCondition.B, SyncThreadTestReentrantLockCondition.C, integer, lock);

        Thread a = new Thread(aTask);
        Thread b = new Thread(bTask);
        Thread c = new Thread(cTask);

        a.start();
        b.start();
        c.start();
    }
}