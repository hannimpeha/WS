package displayGame;

import consoles.ConsolePane;

import java.awt.event.ActionListener;

public class VictoryPanel extends ConsolePane {

    private ActionListener listener;

    public VictoryPanel(ActionListener listener) {
        super();
        setName("Victory Panel");
        start();
    }

    private void start() {
        System.out.println("Victory!");
    }

}
