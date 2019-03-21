package learnJVMMemoryError;

public class StackOverflowError{

    public static void main(String[] args) {
        Father father = new Son();
        father.doSomething();
    }
}

class Father {
    protected void doSomething(){
        System.out.println("Father's doSomething");
        this.doSomething();
    }
}

class Son extends Father {
    @Override
    public void doSomething(){
        System.out.println("Son's doSomething");
        super.doSomething();
    }
}
