package zjl.com.test;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;

public class TestTimeToStr {
    public static void main(String[] args) {
        System.out.println("LocalTime->: "+ LocalTime.now());
        LocalDate now1 = LocalDate.now();
        System.out.println("LocalDate->: "+now1);
        LocalDateTime now = LocalDateTime.now();
        String s1 = now.toString();
        System.out.println("LocalDateTime->："+s1);
        LocalDateTime parse = LocalDateTime.parse(s1);
        System.out.println(parse);
        String s = new String("yyyy-MM-dd hh:mm:ss");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(s);
        System.out.println(LocalDateTime.now());


        String format = dateTimeFormatter.format( LocalDateTime.now());
        System.out.println(format);

//        LocalDateTime parse = LocalDateTime.parse(format, dateTimeFormatter);
//        System.out.println(parse);
    }
}

class TimeTest{
    public static void main(String[] args) {
        LocalTime localTime = LocalTime.now();
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();


    }
}
