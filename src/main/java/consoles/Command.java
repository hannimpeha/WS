package consoles;

public interface Command extends CommandListener {
    public void appendOrder(String order);
    public String getUserOutputStart();
}
