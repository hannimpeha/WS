import controllers.Controller;
import controllers.Hannah;

public class main {

    public static void main(String[] args) {

        Hannah hannah = new Hannah();
        Controller c = new Controller(hannah);
        c.run();

    }

}