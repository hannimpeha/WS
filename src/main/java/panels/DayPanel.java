package panels;

import consoles.ConsolePane;
import java.awt.event.ActionListener;

public class DayPanel extends ConsolePane {

    private ActionListener listener;

    public DayPanel(ActionListener listener) {
        super(listener);
        start();
    }

    private void start() {
        System.out.println("Day");
    }


}
