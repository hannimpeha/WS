package displayGame;

import consoles.MyPanel;
import java.awt.event.ActionListener;

public class NightPanel extends MyPanel {

    private ActionListener listener;

    public NightPanel(ActionListener packageListener,
                      ActionListener listener) {
        contentPane.setName("Night Panel");
        start();
    }

    private void start() {
        System.out.println("Press Night to Continue.");
    }

}


