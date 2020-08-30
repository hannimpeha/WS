package displaySetUp;

import consoles.ConsolePane;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import java.util.ArrayList;

public class PlayerRolePanel extends ConsolePane {

    private DocumentListener listener;
    private ArrayList<String> rolesSelected;
    private JTextArea textArea;
    private JTextArea textAreaOrder;

    public PlayerRolePanel(DocumentListener packageListener,
                           DocumentListener listener) {
        super();
        //this.listener = listener;
        setName("PlayerRole Panel");
        displayRoles();
    }

    private void displayRoles() {
        //outputToJTextArea("Roles are as follows");
    }

    public ArrayList<String> getRolesSelected() {
        return new ArrayList<>(rolesSelected);
    }
}
