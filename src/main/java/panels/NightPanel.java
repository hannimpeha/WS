package panels;

import consoles.CommandListener;

public class NightPanel {

    private CommandListener commandListener;

    public NightPanel(CommandListener commandListener) {
        this.commandListener = commandListener;
    }

    public void start() {
        System.out.println("Press Night to Continue.");
    }
}


