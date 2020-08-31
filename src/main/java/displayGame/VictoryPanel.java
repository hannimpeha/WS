package displayGame;

import consoles.ConsolePane;

import java.awt.event.ActionListener;

public class VictoryPanel  {

    private ActionListener listener;

    public VictoryPanel(ActionListener listener) {
        //super(listener);
        //setName("Victory Panel");
        start();
    }

    private void start() {
        System.out.println("Victory!");
    }

}
