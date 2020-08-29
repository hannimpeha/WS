package consoles;

public interface Terminal extends CommandListener {
    public void appendText(String text);
    public int getUserInputStart();
}
