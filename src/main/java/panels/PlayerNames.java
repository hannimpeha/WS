package panels;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class PlayerNames {

    private List<String> playerName;
    private static String path = "/Users/hannimpeha/HANNIMPEHA/" +
            "Thesis/FascinatingProject" +
            "/src/main/java/resource/players.txt";

    public PlayerNames() {
    }

    public JTextArea createPanel() {
        final JTextArea textAreaOrder =
                new JTextArea(20, 30);
        textAreaOrder.setText("Type Players's Names");
        textAreaOrder.setEditable(false);
        return textAreaOrder;
    }


    public Box createButton() {
        final Box box = Box.createHorizontalBox();
        box.setBorder(BorderFactory.createEmptyBorder(5, 1, 5, 1));
        box.add(Box.createHorizontalStrut(5));
        box.add(Box.createHorizontalGlue());
        final JTextField textField = new JTextField(24);
        box.add(textField);
        final JButton button = new JButton("Name");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerName = Arrays.asList(textField.getText().split(", "));
                try {
                    Files.write(Paths.get(path),playerName);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        box.add(button);
        return box;
    }

}