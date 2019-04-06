package LearnCondition;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestConditionSequence {
    //线程执行顺序标记,1:表示loopA执行，2：表示loopB执行，3：表示loopC执行
    private volatile int number = 1;
    //获得lock锁
    private Lock lock = new ReentrantLock();
    //创建三个condition对象用来await(阻塞)和signal(唤醒)指定的线程
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    private static volatile AtomicInteger integer = new AtomicInteger(0);

    public static void main(String[] args) {

        TestConditionSequence object = new TestConditionSequence();

        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                while (integer.get() < 100) {
                    object.loopA();
                }
            }
        });
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                while (integer.get() < 100) {
                    object.loopB();
                }
            }
        });
        Thread c = new Thread(new Runnable() {
            @Override
            public void run() {
                while (integer.get() < 100) {
                    object.loopC();
                }
            }
        });
        a.start();
        b.start();
        c.start();

    }

    protected void loopA() {
        if (integer.get() > 100) {
            return;
        }
        lock.lock();//上锁
        try {
            /*如果不是第一个标志位，就阻塞，为了解决虚假唤醒问题，使用while关键字
             */
            while (number != 1) {
                try {
                    c1.await();//阻塞类似wait()
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (integer.get() < 100) {
                System.out.println("ThreadA No1---" + integer.incrementAndGet() + "-A");
                number = 2;//使能第二个方法
                c2.signal();//唤醒第二个线程,类似notify()方法
            } else {
                return;
            }
        } finally {
            lock.unlock();//解锁
        }

    }

    protected void loopB() {
        lock.lock();//上锁
        try {
            //如果不是第一个标志位，就阻塞
            while (number != 2 && integer.get() < 100) {
                try {
                    c2.await();//阻塞类似wait()
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (integer.get() < 100) {
                System.out.println("ThreadB No2---" + integer.incrementAndGet() + "-B");
                number = 3;//使能第3个方法
                c3.signal();//唤醒第三个线程,类似notify()方法
            } else {
                return;
            }

        } finally {
            lock.unlock();//解锁
        }
    }

    protected void loopC() {
        lock.lock();//上锁
        try {
            //如果不是第一个标志位，就阻塞
            while (number != 3 && integer.get() < 100) {
                try {
                    c3.await();//阻塞类似wait()
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (integer.get() < 100) {
                System.out.println("ThreadC No3---" + integer.incrementAndGet() + "-C");
                number = 1;//使能第1个方法
                c1.signal();//唤醒第一个线程,类似notify()方法
            } else {
                return;
            }
        } finally {
            lock.unlock();//解锁
        }
    }
}