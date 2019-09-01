package learnJVMMemoryError;

/**
 * 栈溢出
 * @author feizi
 * @time 2015-1-23上午9:13:11
 */
public class SOFTest {

    public void stackOverFlowMethod(){
        stackOverFlowMethod();
    }

    /**
     * 通过递归调用方法,不停的产生栈帧,一直把栈空间堆满,直到抛出异常 ：
     * @param args
     */
    public static void main(String[] args) {
        SOFTest sof = new SOFTest();
        sof.stackOverFlowMethod();
    }

}
