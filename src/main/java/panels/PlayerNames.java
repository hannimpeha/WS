package panels;

import controllers.Hannah;
import controllers.State;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class PlayerNames implements State {

    private static String path = "/Users/hannimpeha/HANNIMPEHA/" +
            "Thesis/FascinatingProject" +
            "/src/main/java/resource/players.txt";
    private List<String> playerName;
    private final JTextArea textAreaOrder = new JTextArea(20, 30);
    private final JTextField textField = new JTextField(24);
    private Hannah hannah;

    public PlayerNames() {
    }

    public void doButton(Hannah hannah){
        playerName = Arrays.asList(
                textField.getText().split(", "));
        try {
            Files.write(Paths.get(path), playerName);
        } catch (IOException exp) {
            exp.printStackTrace(); }
    }


    @Override
    public void doContinue(Hannah hannah) {
        doButton(hannah);
        hannah.changeState(new PlayerRoles());
    }

    @Override
    public JTextArea getTextArea() {
        textAreaOrder.setText("Type Players's Names");
        textAreaOrder.setEditable(false);
        return textAreaOrder;
    }

}
