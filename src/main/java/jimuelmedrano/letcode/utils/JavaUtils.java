package jimuelmedrano.letcode.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaUtils {

    public static int randomNumber(int min, int max){
        return (int) (Math.random() * (max - min + 1) + min);
    }

    public static long randomLongNumber(long min, long max){
        return (long) (Math.random() * (max - min + 1) + min);
    }

    public static String formattedDate(String dateString) throws ParseException {
        String pattern = "yyyy-MM-dd";
        System.out.println("Default Date:"+dateString);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = simpleDateFormat.parse(dateString);
        String sPattern = "MMddyyyy";
        SimpleDateFormat newSimpleDateFormat = new SimpleDateFormat(sPattern);
        String sDate = newSimpleDateFormat.format(date);
        System.out.println("Formatted Date: "+ sDate);
        return sDate;
    }
}
