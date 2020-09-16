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
        createPanel();
        doButton();
    }

    public void createPanel() {
        getTextAreaOrder().setText("Type Players's Names");
        getTextAreaOrder().setEditable(false);
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
