package panels;

import javax.swing.*;

public interface State {

    JPanel createPanel();
    JPanel createButton();
    String getName();
}
