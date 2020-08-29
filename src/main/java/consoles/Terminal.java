package consoles;

import java.awt.event.ActionListener;

public interface Terminal extends UserInput, UserOutput, ActionListener {
    public void appendOrder(String order);
    public void appendText(String text);
}
