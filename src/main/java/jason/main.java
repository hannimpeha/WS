package jason;

import jason.infra.centralised.RunCentralisedMAS;

public class main {

    public static void main(String[] args) throws Exception {
        new RunCentralisedMAS().setupLogger();
        try {
            MyAgent ag = new MyAgent();
            ag.run();
        } catch (JasonException e) {
            e.printStackTrace();
        }
    }
}
