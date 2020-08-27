package panels;

import consoles.CommandListener;
import consoles.ConsolePane;

public class NightPanel extends ConsolePane {

    private CommandListener commandListener;

    public NightPanel(CommandListener commandListener) {
        this.commandListener = commandListener;
    }

    public void start() {
        System.out.println("Press Night to Continue.");
    }
}


