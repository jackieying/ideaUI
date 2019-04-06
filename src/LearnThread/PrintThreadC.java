package LearnThread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;

public class PrintThreadC implements Runnable {
    static AtomicInteger printInt = new AtomicInteger(0);

    static volatile AtomicInteger countInteger = new AtomicInteger(0);

    static volatile Boolean aBoolean = Boolean.FALSE;

    static volatile Condition conditionA = null;

    static volatile Condition conditionC = null;

    String threadName;

    public PrintThreadC() {
    }

    public PrintThreadC(AtomicInteger a, String threadName) {
        this.printInt = a;
        this.threadName = threadName;
    }

    public void setPrintInt(AtomicInteger printInt) {
        this.printInt = printInt;
    }

    public AtomicInteger getPrintInt() {
        return printInt;
    }

    @Override
    public void run() {
        while (printInt.get() < 100) {
            try {
                if(0 != printInt.get()){
                    conditionC.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(
                    System.currentTimeMillis() + "---" + printInt.incrementAndGet() + "---" + this.threadName);
            conditionA.signal();
        }
    }
}