package graphViz;

import controllers.ActionListener;
import jason.infra.centralised.RunCentralisedMAS;

public class MyRunnable implements Runnable {

    private ActionListener listener;

    public MyRunnable(ActionListener listener) {
        this.listener = listener;
        new RunCentralisedMAS();
    }

    @Override
    public void run() {
        new NCT(listener);
    }
}
