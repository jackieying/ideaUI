package learnJVMMemoryError;

import java.util.ArrayList;
import java.util.List;

public class a5 {
    public static int c = 0;
    public static int d = 0;
    public static List<String> list = new ArrayList<String>();

//    如果线程请求的栈深度大于虚拟机所允许的最大深度，将抛出StackOverflowError异常。--无限递归
//    如果虚拟机在扩展栈时无法申请到足够的内存空间，则抛出OutOfMemoryError异常。 --占用的空间太大

    public static void main(String[] args) {
        a5 main = new a5();
//        main.testStackOverflowError(c);
        main.addString(d);
    }

    public void testStackOverflowError(int c) {//StackOverflowError
        System.out.println(c++);//10444
        testStackOverflowError(c);
    }


    public void addString(int d) {//OutOfMemoryError
        while (true) {
            System.out.println(d++);//2702970
            String s = "11111111111111111111111111111111111111111111111111111111";
            list.add(s + s + s + s + s);
        }
    }

}
