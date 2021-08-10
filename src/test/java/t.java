import org.testng.annotations.Test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class t {
    @Test
    public static void main(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HHmmss");
        LocalTime localTime = LocalTime.now();
        String a = dtf.format(localTime);
    }
}
