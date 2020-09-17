package controllers;

import javax.swing.*;
import java.awt.event.ActionListener;

public interface State {

    void doContinue(Hannah hannah);
    JTextArea getTextArea();
}
