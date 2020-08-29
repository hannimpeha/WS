package panels;

import consoles.CommandListener;

public class VictoryPanel {

    private CommandListener commandListener;

    public VictoryPanel(CommandListener commandListener) {
        this.commandListener = commandListener;
    }

    public void start() {
        System.out.println("Victory!");
    }
}
