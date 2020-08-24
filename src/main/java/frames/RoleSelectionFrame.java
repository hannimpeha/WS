package frames;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoleSelectionFrame extends JFrame {

    private ActionListener globalListener;

    public RoleSelectionFrame(ActionListener globalListener){
        this.globalListener = globalListener;
        System.out.println("Press RoleSelection to start");
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

}
