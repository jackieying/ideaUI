package learnCollection;

import java.util.HashMap;

public class HashMapEndlessLoop {
    private static HashMap<Long, EasyCoding> map = new HashMap<Long, EasyCoding>();

    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            (new Thread(){
                @Override
                public void run() {
                    map.put(System.nanoTime(), new EasyCoding());
                }
            }).start();
        }
    }
}
class EasyCoding{}