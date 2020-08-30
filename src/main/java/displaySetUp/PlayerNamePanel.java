package displaySetUp;

import consoles.ConsolePane;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PlayerNamePanel extends ConsolePane {

    private ActionListener listener;
    private ArrayList<JTextArea> textAreas = new ArrayList<>();
    private ArrayList<String> playerNameInput;

    public PlayerNamePanel(ActionListener packageListener,
                            ActionListener listener) {
        super(packageListener);
        this.listener = listener;
        setName("PlayerName Panel");
    }

    private void displayNames() {
        outputToJTextArea("Names are as follows");
    }

    public List<String> getPlayerNames(){
        List<String> names = new ArrayList<>();
        for (int count=0; count<names.size(); count++){
            ConsolePane cp = new ConsolePane(listener);
            names.add(cp.getInputFromJTextArea());
        }
        return names;
    }
}
