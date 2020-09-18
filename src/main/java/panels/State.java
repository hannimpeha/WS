package panels;

import javax.swing.*;

public interface State {

    JTextArea onPlayAbove(Student student);
    JTextArea onExitAbove(Student student);
    JButton onPlayBottom(Student student);
    JButton onExitBottom(Student student);
    String getName();
}
