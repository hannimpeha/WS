package displayGame;

import consoles.MyPanel;

import java.awt.event.ActionListener;

public class VictoryPanel extends MyPanel {

    private ActionListener listener;

    public VictoryPanel(ActionListener listener) {
        this.listener = listener;
        contentPane.setName("Victory Panel");
        start();
    }

    private void start() {
        System.out.println("Victory!");
    }

}
