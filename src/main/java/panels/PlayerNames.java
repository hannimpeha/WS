package panels;

import controllers.Hannah;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class PlayerNames {

    private static Hannah hannah;
    private static JButton button = new JButton("Enter");
    private static JTextArea textAreaOrder = new JTextArea(20, 30);
    private List<String> playerName;
    private static JTextField textField = new JTextField(24);
    private static String path = "/Users/hannimpeha/HANNIMPEHA/" +
            "Thesis/FascinatingProject" +
            "/src/main/java/resource/players.txt";

    public PlayerNames(Hannah hannah) {
        this.hannah = hannah;
    }

    public JTextArea createPanel() {
        textAreaOrder.setText("Type Players's Names");
        textAreaOrder.setEditable(false);
        return textAreaOrder;
    }


    public JButton doButton(){
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerName = Arrays.asList(
                        textField.getText().split(", "));
                try {
                    Files.write(Paths.get(path), playerName);
                } catch (IOException exp) {
                    exp.printStackTrace(); }
            }
        });
        return button;
    }

}
