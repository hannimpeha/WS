package displaySetUp;

import consoles.ConsolePane;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PlayerRolePanel extends ConsolePane {

    private ActionListener listener;
    private ArrayList<String> rolesSelected;
    private JTextArea textArea;
    private JTextArea textAreaOrder;

    public PlayerRolePanel(ActionListener packageListener,
                           ActionListener listener) {
        super(packageListener);
        this.listener = listener;
        setName("PlayerRole Panel");
        displayRoles();
    }

    private void displayRoles() {
        outputToJTextArea("Roles are as follows");
    }

    public ArrayList<String> getRolesSelected() {
        return new ArrayList<>(rolesSelected);
    }
}
