package learnCalculation;

public class testShiftOperation {
    public static void main(String[] args) {
        System.out.println(true&false);
        System.out.println(8&8);
        System.out.println(7&8);
        System.out.println(true&&false);
        int j = -35;
        int k = 1;
        for (int i = 1; i < 33; i++) {
            System.out.print((j = j >>> 1) + ",");
            if(k%15==0){
                System.out.println();
            }
            k =++k;
        }
        System.out.println();
        k = 1;
        j = -35;
        for (int i = 1; i < 33; i++) {
            System.out.print((j = j >> 1) + ",");
            if(k%15==0){
                System.out.println();
            }
            k =++k;
        }

    }
}
