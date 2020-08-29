package displayGame;

import consoles.ConsolePane;
import java.awt.event.ActionListener;

public class DayPanel extends ConsolePane {

    private ActionListener listener;

    public DayPanel(ActionListener packageListener, ActionListener listener) {
        super(packageListener);
        this.listener = listener;
        setName("Day Panel");
        start();
    }

    private void start() {
        System.out.println("Day");

    }


}
