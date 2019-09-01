package ThreadLocal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConcurrentDateUtil {

    /*private static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>(){
    @Override
    protected DateFormat initialValue(){
      return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
    }*/
    private static final String DATE_FORMAT_STR = "yyyy-MM-dd hh:mm:ss";
    private static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>();

    public static DateFormat getDateFormat(){
        DateFormat df = threadLocal.get();
        if(null == df) {
            df = new SimpleDateFormat(DATE_FORMAT_STR);
            threadLocal.set(df);
        }
        return df;
    }


    public static Date parse(String dateStr) throws ParseException {
      return threadLocal.get().parse(dateStr);
    }

    public static String format(Date date){
      return threadLocal.get().format(date);
    }
}
