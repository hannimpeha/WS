package displaySetUp;

import consoles.StreamWriter;
import controllers.ConsolePane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class PlayerNamePanel extends ConsolePane {

    private ActionListener listener;
    private ArrayList<JTextField> textFields = new ArrayList<JTextField>();
    private JButton btnNames;

    public PlayerNamePanel(ActionListener listener) {
        this.listener = listener;
        displayNorth();
        displaySouth();
    }

    private void displayNorth() {
        textAreaOrder = new JTextArea(20, 30);
        textAreaOrder.setText("Type Players's names");
        textAreaOrder.setEditable(false);
        try {
            OutputStream os = new StreamWriter(textAreaOrder);
            System.setOut(new PrintStream(os, true, "UTF-8"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        north.add(new JScrollPane(textAreaOrder));
    }

    private void displaySouth() {
        box = Box.createHorizontalBox();
        box.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        box.add(Box.createHorizontalStrut(5));
        box.add(Box.createHorizontalGlue());
        textField = new JTextField(24);
        box.add(textField);
        btnNames = new JButton("Enter");
        btnNames.addActionListener(listener);
        box.add(btnNames);
        south.add(box);
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