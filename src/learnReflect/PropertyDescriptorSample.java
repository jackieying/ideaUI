package learnReflect;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;

public class PropertyDescriptorSample {
    public static void main(String[] args) {
        Field[] fields = Node.class.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("===============>" + field.getName()
                                        + "\t" + field.getType() + "---" + String.class);
            try{
                PropertyDescriptor propertyDescriptor
                        = new PropertyDescriptor(field.getName(), Node.class);
                printDesc(propertyDescriptor);
            }catch (IntrospectionException e){
                System.out.println(e.getStackTrace()+e.getMessage());
            }

        }
    }

    private static void printDesc(PropertyDescriptor propertyDescriptor) {
        //显示名称
        System.out.println(propertyDescriptor.getDisplayName());
        //简要说明
        System.out.println(propertyDescriptor.getShortDescription());
        System.out.println(propertyDescriptor.getPropertyEditorClass());
        System.out.println(propertyDescriptor.getPropertyType());
        System.out.println(propertyDescriptor.getReadMethod());
        System.out.println(propertyDescriptor.getWriteMethod());
    }


    static class Node {

        private String name;

        private String email;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
