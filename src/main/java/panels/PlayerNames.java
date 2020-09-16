package panels;

import controllers.ConsolePane;
import stateMachine.Hannah;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class PlayerNames extends ConsolePane {

    private List<String> playerName;
    private static String path = "/Users/hannimpeha/HANNIMPEHA/" +
            "Thesis/FascinatingProject" +
            "/src/main/java/resource/players.txt";

    public PlayerNames(Hannah hannah) {
        super(hannah);
        doButton();
    }

    public JTextArea createPanel() {
        final JTextArea textAreaOrder =
                new JTextArea(20, 30);
        textAreaOrder.setText("Type Players's Names");
        textAreaOrder.setEditable(false);
        return textAreaOrder;
    }


    public void doButton(){
        getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerName = Arrays.asList(
                        getTextField().getText().split(", "));
                try {
                    Files.write(Paths.get(path), playerName);
                } catch (IOException exp) {
                    exp.printStackTrace(); }
            }
        });
    }

}
