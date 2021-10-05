package util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    public static DateTimeFormatter dtf;


    public static String getCurrentDateTimeToString()
    {
       dtf = DateTimeFormatter.ofPattern("uuuu-MM-ddHH:mm:ss");
        LocalDateTime lDate = LocalDateTime.now();
        return dtf.format(lDate);

    }
}
