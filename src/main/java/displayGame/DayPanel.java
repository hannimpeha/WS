package displayGame;

import consoles.MyPanel;
import java.awt.event.ActionListener;

public class DayPanel extends MyPanel {

    private ActionListener listener;

    public DayPanel(ActionListener packageListener, ActionListener listener) {
        this.listener = listener;
        contentPane.setName("Day Panel");
        start();
    }

    private void start() {
        System.out.println("Day");
    }


}
