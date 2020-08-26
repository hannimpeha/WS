package consoleExample;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextAreaLoad {

    private JFrame frame = new JFrame();
    private JButton textArea = new JButton("please");

    public TextAreaLoad() {
        textArea.setSize(7,30);
        textArea.addActionListener(e -> {
            FileReader reader = null;
            try {
                reader = new FileReader("saveGame.txt");
            } catch (FileNotFoundException exception) {
                exception.printStackTrace();
            }
            BufferedReader br = new BufferedReader(reader);
            textArea.requestFocus();
            });
        frame.getContentPane().add(textArea);
        frame.setVisible(true);
    }

}
