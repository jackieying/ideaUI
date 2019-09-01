package learnExtends;

public class Father {
    static {
        System.out.println("father static");
    }

    public Father(){
        System.out.println("father initMethod");
    }

    protected void doSomething(){
        System.out.println("Father's doSomething");
//        this.doSomething();
    }

    public static void main(String[] args) {
        Father father = new Son();
        father.doSomething();
    }
}

class Son extends Father{
    static {
        System.out.println("son static");
    }

    public Son(){
        System.out.println("son initMethod");
    }

    @Override
    public void doSomething(){
        System.out.println("Son's doSomething");
//        super.doSomething();
    }
}
