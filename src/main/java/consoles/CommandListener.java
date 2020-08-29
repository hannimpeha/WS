package consoles;

import java.awt.event.ActionListener;

public interface CommandListener extends ActionListener {

    public void commandOutput(String text);

    public void commandCompleted(String cmd, int result);

    public void commandFailed(Exception exp);

    public String wantStart(String text);
}
