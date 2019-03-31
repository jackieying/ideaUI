package LearnThread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

public class PrintThread implements Runnable {
    static AtomicInteger printInt = new AtomicInteger(0);

    String threadName;

    public PrintThread() {
    }

    public PrintThread(AtomicInteger a, String threadName) {
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
            System.out.println(
                    System.currentTimeMillis() + "---" + printInt.incrementAndGet() + "---" + this.threadName);
            LockSupport.park(this);
        }
    }
}