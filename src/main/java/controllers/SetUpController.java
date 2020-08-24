package controllers;

import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.keyboard.NativeKeyEvent;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SetUpController extends JFrame implements NativeKeyListener {

    private NativeKeyListener globalListener;
    private ArrayList<JTextField> textFields = new ArrayList<>();
    private int playerTotal;

    public SetUpController(NativeKeyListener globalListener) {
        this.globalListener = globalListener;
    }

    public void start() {
        playerTotal = 3;
    }

    public void displayPlayerCenter(int playerTotal) {
        for(int i=0; i<playerTotal; i++) {
            textFields.add(new JTextField());
        }
    }

    public List<String> getPlayerNames() {
        List<String> names = new ArrayList<>();
        for(JTextField f: textFields) {
            if(f.getText().equals("")||f.getText()==null){
                names.add(f.getName());
            }else{
                names.add(f.getText());
            }
        }
        return names;
    }

    public List<String> getRoles() {
        List<String> availableRoles = new ArrayList<>();
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(new File("src/resources/roles.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String[] split = line.split("\\|");
            availableRoles.add(split[0]);
        }
        return availableRoles;
    }


    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {
    }

}
