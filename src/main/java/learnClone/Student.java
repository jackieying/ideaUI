package learnClone;


/**
 1. 学生类
 2. @author zhaoheng
 3. @date 2018年8月23日
 */
public class Student implements Cloneable{

    private String name;//引用类型

    private int age;//基本类型

    private Classes classes;//引用类型

    //这里省略gettters and setters


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", classes=" + classes + "]";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Student stu = (Student)super.clone();
        //克隆classes属性时调用Classes类的clone()
        //Classes cla = (Classes)classes.clone();
        //stu.setClasses(cla);
        return stu;
    }
}