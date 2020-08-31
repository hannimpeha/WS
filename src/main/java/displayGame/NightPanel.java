package displayGame;

import consoles.ConsolePane;

import java.awt.event.ActionListener;

public class NightPanel extends ConsolePane {

    private ActionListener listener;

    public NightPanel(ActionListener packageListener,
                      ActionListener listener) {
        super(packageListener);
        setName("Night Panel");
        start();
    }

    private void start() {
        System.out.println("Press Night to Continue.");
    }

}