package consoles;

import javax.swing.*;

public class MyTextArea extends JTextArea {

    public MyTextArea(String text) {
        super(text);
        setRows(20);
        setColumns(20);
    }
}
