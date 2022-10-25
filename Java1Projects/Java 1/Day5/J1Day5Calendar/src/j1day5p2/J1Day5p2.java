package j1day5p2;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class J1Day5p2 {
    public static void main(String[] args) {
        
        Calendar sys = Calendar.getInstance();
        
        System.out.printf("%1$tY %1$td %1$tB\n", sys);
        
        
        //DateFormate класс, который позволяет при помощи своих объектов менять формат
        DateFormat f = DateFormat.getDateInstance( DateFormat.LONG, new Locale("en", "US")); 
        Date date = sys.getTime();// Date класс устаревший. Вместо него используют Calendar
        System.out.println(f.format(date));
    }
    
}
