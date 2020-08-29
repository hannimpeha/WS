package displaySetUp;

import consoles.ConsolePane;
import java.awt.event.ActionListener;

public class PlayerCountPanel extends ConsolePane {

    private ActionListener listener;

    public PlayerCountPanel(ActionListener packageListener,
                            ActionListener listener) {
        super(packageListener);
        this.listener = listener;
        setName("PlayerCount Panel");
        displayPlayer();
    }

    private void displayPlayer() {
        System.out.println("Great");
    }
}
