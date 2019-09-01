package learnClone;
/**
 4. 班级类
 5. @author zhaoheng
 6. @date 2018年8月23日
 */
public class Classes implements Cloneable {

    private int classId;//基本类型

    private String className;//引用类型

    //这里省略gettters and setters

    public int getClassId() {
        return classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Classes [classId=" + classId + ", className=" + className + "]";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}