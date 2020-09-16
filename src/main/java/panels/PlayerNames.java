package panels;

import controllers.ConsolePane;
import controllers.Hannah;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class PlayerNames extends JPanel{

    private static Hannah hannah;
    private static JPanel contentPane = new JPanel();
    private static JPanel north = new JPanel();
    private static JPanel south = new JPanel();
    private static Box box = Box.createHorizontalBox();
    private static JTextField textField = new JTextField(24);
    private static JButton button = new JButton("Enter");
    private static JTextArea textAreaOrder = new JTextArea(20, 30);
    private static String path = "/Users/hannimpeha/HANNIMPEHA/" +
            "Thesis/FascinatingProject" +
            "/src/main/java/resource/players.txt";
    private List<String> playerName;

    public PlayerNames() {
        north.add(createPanel());
        south.add(doButton());
    }

    public JTextArea createPanel() {
        textAreaOrder.setText("Type Players's Names");
        textAreaOrder.setEditable(false);
        return textAreaOrder;
    }


    public Box doButton(){
        box.setBorder(
                BorderFactory.createEmptyBorder(5, 5, 5, 5));
        box.add(Box.createHorizontalStrut(5));
        box.add(Box.createHorizontalGlue());
        box.add(textField);
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
        box.add(button);
        return box;
    }

}
