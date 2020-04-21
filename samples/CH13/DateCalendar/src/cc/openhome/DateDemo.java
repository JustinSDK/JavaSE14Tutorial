package cc.openhome;

import java.util.*;
import static java.lang.System.*;

public class DateDemo {
    public static void main(String[] args) {
        var date1 = new Date(currentTimeMillis());
        var date2 = new Date();

        out.println(date1.getTime());
        out.println(date2.getTime());
    }
}
