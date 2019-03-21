package learnJVMMemoryError;

import java.util.ArrayList;
import java.util.List;

public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        List<Integer> stringList = new ArrayList<Integer>();
        Integer i = 0;
        while(true){
            i++;
        }
    }
}
