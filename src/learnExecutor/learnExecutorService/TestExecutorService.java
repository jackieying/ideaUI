package learnExecutor.learnExecutorService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class TestExecutorService {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        //execute(Runnable)
        //方法 execute(Runnable) 接收壹個 java.lang.Runnable 对象作为参数，并且以异步的方式执行它。
        //使用这种方式没有办法获取执行 Runnable 之后的结果，如果你希望获取运行之后的返回值，就必须使用接收Callable参数的execute()方法
        /*executorService.execute(new Runnable() {
            public void run() {
                System.out.println("Asynchronous task.");
            }
        });


        //submit(Runnable)
        //方法 submit(Runnable) 同样接收壹個 Runnable 的实现作为参数，但是会返回壹個 Future 对象。这個 Future 对象可以用于判断 Runnable 是否结束执行。
        Future future = executorService.submit(new Runnable() {
            public void run() {
                System.out.println("Asynchronous task..");
            }
        });
        //如果任务结束执行则返回 null
        try{
            System.out.println("future.get()=" + future.get());
        }catch (ExecutionException ee){
            throw new ExecutionException(ee.getMessage(),ee);
        }catch (InterruptedException ie){
            throw new InterruptedException(ie.getMessage());
        }*/


        //submit(Callable)
        //方法 submit(Callable) 和方法 submit(Runnable) 比较类似，但是区别则在于它们接收不同的参数类型。Callable 的实例与 Runnable 的实例很类似，
        //但是 Callable 的 call() 方法可以返回壹個结果。方法 Runnable.run() 则不能返回结果。
        //Callable 的返回值可以从方法 submit(Callable) 返回的 Future 对象中获取。如下是壹個 ExecutorService Callable 的样例：
        /*Future future2 = executorService.submit(new Callable(){
            public Object call() throws Exception {
                System.out.println("Asynchronous Callable");
                return "Callable Result";
            }
        });

        System.out.println("future2.get() = " + future2.get());*/


        //invokeAny()
        //方法 invokeAny() 接收壹個包含 Callable 对象的集合作为参数。调用该方法不会返回 Future 对象，而是返回集合中某壹個 Callable 对象的结果，
        //而且无法保证调用之后返回的结果是哪壹個 Callable，只知道它是这些 Callable 中壹個执行结束的 Callable 对象。
        //如果壹個任务运行完毕或者抛出异常，方法会取消其它的 Callable 的执行。
        /*Set<Callable<String>> callables = new HashSet<Callable<String>>();

        callables.add(new Callable<String>() {
            public String call() throws Exception {
                return "Task 1";
            }
        });
        callables.add(new Callable<String>() {
            public String call() throws Exception {
                return "Task 2";
            }
        });
        callables.add(new Callable<String>() {
            public String call() throws Exception {
                return "Task 3";
            }
        });

        String result = executorService.invokeAny(callables);

        System.out.println("result = " + result);
        //以上样例代码会打印出在给定的集合中的某壹個 Callable 的返回结果。我尝试运行了几次，结果都在改变。有时候返回结果是"Task 1"，有时候是"Task 2"，等等*/


        Set<Callable<String>> callables = new HashSet<Callable<String>>();

        callables.add(new Callable<String>() {
            public String call() throws Exception {
                return "Task 1";
            }
        });
        callables.add(new Callable<String>() {
            public String call() throws Exception {
                return "Task 2";
            }
        });
        callables.add(new Callable<String>() {
            public String call() throws Exception {
                return "Task 3";
            }
        });

        List<Future<String>> resultList = executorService.invokeAll(callables);
        for (Future future: resultList) {
            System.out.println("future get() = " + future.get());
        }

        executorService.shutdown();
    }
}
