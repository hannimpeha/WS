package consoles;

public interface CommandListener {

    public void commandOutput(String text);

    public void commandCompleted(String cmd, int result);

    public void commandFailed(Exception exp);
}
