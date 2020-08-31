package consoleExample;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.print.PrinterException;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JWindow;


public class Test2 {
    private static String password = "abc";
    public static void main(String[] args) throws PrinterException {
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().getWidth());
        int ySize = ((int) tk.getScreenSize().getHeight());

        JFrame screen = new JFrame("INSERT TITLE HERE");

        screen.setSize(xSize, ySize);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setResizable(false);

        screen.setVisible(true);

        JWindow window = new JWindow(screen);
        window.setSize(xSize, ySize);
        window.setName("INSERT TITLE HERE");

        final JTextArea text = new JTextArea();
        text.setText("Type the password > ");
        text.setBackground(Color.BLACK);
        text.setForeground(Color.green);


        window.add(text);
        window.setVisible(true);

        text.addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyReleased(java.awt.event.KeyEvent evt) {
                System.out.println(evt.getKeyCode());
                if(evt.getKeyCode() == 10){
                    if(text.getText().equalsIgnoreCase(password))
                        text.setText("Login Successfull");
                }
            }
        });
    }
}