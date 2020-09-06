package controllers;

import consoles.StreamWriter;
import controllers.ConsolePane;
import util.LoadFileUtil;

import javax.swing.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class PlayerRoles extends ConsolePane {

    private LoadFileUtil fu;
    private static List<String> playerNames;
    private static String path = "/Users/hannimpeha/HANNIMPEHA/" +
            "Thesis/FascinatingProject" +
            "/src/main/java/resource/players.txt";

    public PlayerRoles(JTextArea textAreaOrder){
        displayNorth(textAreaOrder);
    }

    private void displayNorth(JTextArea textAreaOrder){
        try {
            playerNames = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        fu.newFile(playerNames);

        try {
            OutputStream os = new StreamWriter(textAreaOrder);
            System.setOut(new PrintStream(os, true, "UTF-8"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
