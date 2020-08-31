package displayGame;

import consoles.ConsolePane;

import java.awt.event.ActionListener;

public class VictoryPanel extends ConsolePane {

    private ActionListener listener;

    public VictoryPanel(ActionListener listener) {
        this.listener = listener;
        start();
    }

    private void start() {
        System.out.println("Victory!");
    }

}
