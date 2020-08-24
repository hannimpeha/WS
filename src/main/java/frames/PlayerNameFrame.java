package frames;

import org.gephi.graph.api.types.IntervalSet;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PlayerNameFrame extends JFrame {

    private ArrayList<JTextField> textFields = new ArrayList<>();
    private ActionListener globalListener;
    private ActionListener packageListener;
    private JButton btnContinue;
    private JButton btnHome;

    public PlayerNameFrame(ActionListener packageListener, ActionListener globalListener){
        this.packageListener = packageListener;
        this.globalListener = globalListener;
        System.out.println("Press PlayerCount to start");
        displayCenter(3);
    }

    public void display() {
        btnHome.addActionListener(globalListener);
        btnContinue.addActionListener(packageListener);
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

    public void displayCenter(int playerTotal) {
        for (int count = 0; count < playerTotal; count++) {
            JTextField playerNameInput = new JTextField("", 30);
            playerNameInput.setName(Integer.toString(count+1));
            textFields.add(playerNameInput);
        }
    }
}
