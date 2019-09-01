package learnExecutor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class UserThreadPool {
    public static void main(String[] args) {
        //缓存队列设置固定长度为2，为了快速触发 rejectHandler
        BlockingQueue queue = new LinkedBlockingDeque(2);

        //假设外部任务线程的来源由机房1和机房2的混合调用
        UserThreadFactory f1 = new UserThreadFactory("第1机房");
        UserThreadFactory f2 = new UserThreadFactory("第2机房");

        UserRejectedExecutionHandler handler = new UserRejectedExecutionHandler();

        //核心线程为1，最大线程数为2，为了保证触发rejectHandler
        ThreadPoolExecutor threadPoolFirst =
                new ThreadPoolExecutor(1, 2, 60,TimeUnit.SECONDS,queue,f1,handler);

        ThreadPoolExecutor threadPoolSecond =
                new ThreadPoolExecutor(1, 2, 60,TimeUnit.SECONDS,queue,f2,handler);

        //创建400个任务线程
        Runnable task = new Task();
        for (int i = 0; i < 200; i++) {
            threadPoolFirst.execute(task);
            threadPoolSecond.execute(task);
        }
    }
}
