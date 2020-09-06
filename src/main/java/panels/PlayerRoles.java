package panels;


import javax.swing.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PlayerRoles  {

    private List<String> playerName;
    private List<String> playerRole;

    public PlayerRoles() {
        createPanel();
    }

    public JTextArea createPanel() {
        final JTextArea textAreaOrder =
                new JTextArea(20, 30);
        playerName = Arrays.asList("hyo", "ji", "yoo",
                "mi", "vi", "se", "ari");
        createRoles(playerName);
        textAreaOrder.setText("Assigned Roles are as follows\n");
        for(int i=0; i<playerName.size(); i++) {
            textAreaOrder.append(playerName.get(i)+" is "+playerRole.get(i)+".\n");
        }
        textAreaOrder.setEditable(false);
        return textAreaOrder;
    }

    public void createRoles(List<String> playerName) {
        playerRole = Arrays.asList("Mafia", "Mafia", "Doctor",
                "Townie", "Townie", "Townie", "Townie");
        int num = playerName.size();
        switch(num) {
            case 3:
                playerRole = Arrays.asList("Mafia", "Doctor", "Townie");
            case 4:
                playerRole = Arrays.asList("Mafia", "Doctor", "Townie", "Townie");
            case 5:
                playerRole = Arrays.asList("Mafia", "Doctor", "Townie", "Townie", "Townie");
            case 6:
                playerRole = Arrays.asList("Mafia", "Mafia", "Doctor", "Townie", "Townie", "Townie");
            case 7:
                playerRole = Arrays.asList("Mafia", "Mafia", "Doctor", "Townie", "Townie", "Townie", "Townie");
        }
        Collections.shuffle(playerRole);
    }

}

