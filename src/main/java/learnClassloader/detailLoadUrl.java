package learnClassloader;

import java.net.URL;

public class detailLoadUrl {

    public static void main(String[] args) {
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urls.length; i++) {
            System.out.println(urls[i].toExternalForm());
        }

        //System.out.println(System.getProperty("sun.boot.class.path"));

        //System.out.printf(new detailLoadUrl().getClass().getClassLoader().toString());

        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
            }
        };
        thread.start();
        System.out.printf(Thread.class.getClass().getClassLoader().toString());
    }
}
