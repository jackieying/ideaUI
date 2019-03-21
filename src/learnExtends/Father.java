package learnExtends;

public class Father {
    protected void doSomething(){
        System.out.println("Father's doSomething");
        this.doSomething();
    }

    public static void main(String[] args) {
        Father father = new Son();
        father.doSomething();
    }
}

class Son extends Father{
    @Override
    public void doSomething(){
        System.out.println("Son's doSomething");
        super.doSomething();
    }
}
