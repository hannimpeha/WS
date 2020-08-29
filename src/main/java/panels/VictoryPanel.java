package panels;

import consoles.ConsolePane;
import java.awt.event.ActionListener;

public class VictoryPanel extends ConsolePane {

    private ActionListener listener;

    public VictoryPanel(ActionListener listener) {
        super(listener);
        start();
    }

    private void start() {
        System.out.println("Victory!");
    }

}
