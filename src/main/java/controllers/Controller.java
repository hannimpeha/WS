package controllers;

import util.LoadFileUtil;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {

    private SetUpController suc;
    private GameController gc;
    private InputStreamReader ir;
    private BufferedReader br;
    private LoadFileUtil fu;
    private String input;
    private ConsolePane cp;

    public void Controller() {
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            }

            JFrame frame = new JFrame("Mafia Game");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            frame.add(new ConsolePane());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    public void run() {
        System.out.println("\"game\" or \"exit\".");
        ir = new InputStreamReader(System.in);
        br = new BufferedReader(ir);
        fu = new LoadFileUtil();
        int round = 0;
        try {
            do{
                input = br.readLine();
                switch(input) {
                    case "game":
                        fu.newFile();
                        input = br.readLine();
                        new SetUpController(input).start(0);
                    default:
                        break;
                    }
            } while (!input.equalsIgnoreCase("exit"));
        }catch(IOException exception) {
            exception.printStackTrace();
        }
    }

}
