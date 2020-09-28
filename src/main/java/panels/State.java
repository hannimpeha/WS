package panels;

import javax.swing.*;
import java.awt.*;

public interface State {

    JPanel createPanel(Student student);
    JPanel createButton(Student student);
    String getName();
}
