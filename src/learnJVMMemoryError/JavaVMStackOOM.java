package learnJVMMemoryError;

public class JavaVMStackOOM {

    private int stackLength = 1;

    private void dontStop(){
        String s1 = "My name";

        String s2 = "is";

        String s3 = "xuwei";

        String str = s1 + s2 + s3;
        dontStop();
    }

    public void stackLeakByThread() {
        while(true){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }

}
