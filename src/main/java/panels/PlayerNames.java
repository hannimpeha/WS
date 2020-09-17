package panels;

import controllers.Hannah;
import controllers.State;

import javax.swing.*;

public class PlayerNames implements State {

    public PlayerNames() {
    }

    public JTextArea createPanel() {
        final JTextArea textAreaOrder =
                new JTextArea(20, 30);
        textAreaOrder.setText("Type Players's Names");
        textAreaOrder.setEditable(false);
        return textAreaOrder;
    }

    @Override
    public JTextArea doContinue(Hannah hannah) {
        hannah.changeState(new PlayerRoles());
        return createPanel();
    }

    @Override
    public String getThis() {
        return "Name";
    }
}