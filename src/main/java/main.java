import controllers.Controller;
import jason.infra.centralised.RunCentralisedMAS;

public class main{

    public static void main(String[] args)  {

        Controller c = new Controller();
        c.run();
        new RunCentralisedMAS();

    }

}
