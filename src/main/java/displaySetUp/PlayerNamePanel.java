package displaySetUp;

import controllers.ConsolePane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PlayerNamePanel extends ConsolePane {

    private ActionListener listener;
    private ArrayList<JTextField> textFields = new ArrayList<JTextField>();

    public PlayerNamePanel(ActionListener buttonListener,
                           ActionListener listener) {
        this.buttonAction = buttonAction;;
        this.listener = listener;
        box.add(textField);
        box.add(button);
        button.addActionListener(buttonAction);
        contentPane.add(new JScrollPane(textAreaOrder));
        contentPane.add(box, BorderLayout.SOUTH);
    }

    public void displayCenter(int playerTotal){
        for (int count = 0; count < playerTotal; count++) {
            JTextField playerNameInput = new JTextField("", 30);
            contentPane.add(playerNameInput, "cell 0 " + count + " ,growx");
            playerNameInput.setName(Integer.toString(count+1));
            textFields.add(playerNameInput);
        }
    }

    public List<String> getPlayerNames(){
        List<String> names = new ArrayList<>();
        for(JTextField f: textFields){
            if(f.getText().equals("")||f.getText()==null){
                names.add("Player "+f.getName());
            }else{
                names.add(f.getText());
            }
        }
        return names;
    }
}