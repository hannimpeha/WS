package displaySetUp;

import consoles.ConsolePane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PlayerNamePanel extends ConsolePane {

    private ActionListener listener;

    public PlayerNamePanel(ActionListener packageListener,
                            ActionListener listener) {
        super(packageListener);
        this.listener = listener;
        setName("PlayerName Panel");
        displayPlayer();
    }

    private void displayPlayer() {
        System.out.println("Great");
    }

    public List<String> getPlayerNames(){
        List<String> names = new ArrayList<>();
        for (int count=0; count<names.size(); count++){
            ConsolePane cp = new ConsolePane(listener);
            names.add(cp.getUserInput());
        }
        return names;
    }
}
