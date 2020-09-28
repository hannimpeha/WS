package panels;

import javax.swing.*;

public interface State {

    JPanel createPanel(Student student);
    JPanel createButton(Student student);
    String getName();
}
