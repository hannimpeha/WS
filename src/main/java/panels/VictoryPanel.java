package panels;

import consoles.CommandListener;
import consoles.ConsolePane;

public class VictoryPanel extends ConsolePane {

    private CommandListener commandListener;

    public VictoryPanel(CommandListener commandListener) {
        this.commandListener = commandListener;
    }

    public void start() {
        System.out.println("Victory!");
    }
}
