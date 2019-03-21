package learnClone;

/**
 * 测试类
 * @author zhaoheng
 * @date 2018年8月23日
 */
public class TestClone {

    public static void main(String[] args) {
        Student stu = new Student();
        stu.setName("张三");
        stu.setAge(10);

        Classes classes = new Classes();
        classes.setClassId(101);
        classes.setClassName("一班");
        stu.setClasses(classes);

        try {
            System.out.println("深克隆测试------");
            //克隆
            Student stu2 = (Student)stu.clone();
            System.out.println("两个对象是否相同：" + (stu == stu2));
            System.out.println("两个对象的name属性是否相同：" + (stu.getName() == stu2.getName()));
            System.out.println("两个对象的name属性's哈希码是否相同：" + (stu.getName().hashCode() == stu2.getName().hashCode()));
            System.out.println("两个对象的classes属性是否相同：" + (stu.getClasses() == stu2.getClasses()));
            System.out.println("深克隆，Stu " + stu);
            System.out.println("深克隆，Stu2 " + stu);

            System.out.println("修改克隆对象属性");

            stu2.setName("李四");//修改姓名
            stu2.setAge(20);//修改年龄
            stu2.getClasses().setClassId(102);//修改班级编号
            stu2.getClasses().setClassName("二班");//修改班级名称
            System.out.println("修改克隆对象属性后，Stu " + stu);
            System.out.println("修改克隆对象属性后，Stu2 " + stu2);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}