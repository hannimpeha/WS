package consoles;

public interface Terminal extends UserInput, UserOutput {
    public void appendOrder(String order);
    public void appendText(String text);
}
