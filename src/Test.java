import java.util.Arrays;

public class Test {

    private static final long stateOffset = 0;

    private int size;

    public int getSize() {
        return size+1;
    }

    static void voidTest(){
    }

    public static void main(String[] args) throws NegativeArraySizeException{

        /*try{
            String[] negativeArraySize = new String[-1];
        }catch (NegativeArraySizeException e){
            throw new NegativeArraySizeException(e.getMessage());
        }finally {

        }*/
        Test test = new Test();
        System.out.println(test.getSize());


        String[] strArray = {"a", "b", "c"};

        Arrays.asList(strArray).forEach(x -> System.out.println(x));
        Arrays.asList(strArray).forEach(System.out::println);

//        Test.stateOffset++;


        int a = 50;
        int b = 18;

        int c = 53;
        int d = 21;

        int n = 4;
        System.out.println(a % (2 ^ n) == (a & ((2 ^ n) - 1)));

        System.out.println((int)(Math.pow(2, n)));
        System.out.println(a & (int)(Math.pow(2, n) - 1));

        System.out.println(c % (int)(Math.pow(2, n)) );
        System.out.println(c & ((int)(Math.pow(2, n) - 1)));

        System.out.println(d % (int)(Math.pow(2, n)));
        System.out.println(d & ((int)(Math.pow(2, n) - 1)));
    }
}
