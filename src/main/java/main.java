import ballot.Run;
import controllers.Controller;
import org.jnativehook.NativeHookException;

import java.io.IOException;


public class main{

    public static void main(String[] args) throws NativeHookException, IOException {

        Controller c = new Controller();
        c.run();
    }

}
