package panels;

import consoles.ConsolePane;
import java.awt.event.ActionListener;

public class NightPanel extends ConsolePane {

    private ActionListener listener;

    public NightPanel(ActionListener listener) {
        super(listener);
        start();
    }

    private void start() {
        System.out.println("Press Night to Continue.");
    }

}


