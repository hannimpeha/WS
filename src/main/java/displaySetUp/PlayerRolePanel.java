package displaySetUp;

import consoles.ConsolePane;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PlayerRolePanel extends ConsolePane {

    private ActionListener listener;
    private ArrayList<String> rolesSelected;

    public PlayerRolePanel(ActionListener packageListener,
                           ActionListener listener) {
        super(packageListener);
        this.listener = listener;
        setName("PlayerRole Panel");
        displayPlayer();
    }

    private void displayPlayer() {
        System.out.println("Great");
    }

    public ArrayList<String> getRolesSelected() {
        return new ArrayList<>(rolesSelected);
    }
}
