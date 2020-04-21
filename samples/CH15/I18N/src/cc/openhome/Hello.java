package cc.openhome;

import static java.lang.System.out;
import java.util.ResourceBundle;

public class Hello {
    public static void main(String[] args) {
        var res = ResourceBundle.getBundle("messages");
        out.print(res.getString("cc.openhome.welcome") + "!");
        out.println(res.getString("cc.openhome.name") + "!");
    }
}
