package displaySetUp;

import controllers.ConsolePane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PlayerRolePanel extends ConsolePane {

    private ActionListener listener;
    private ArrayList<String> rolesSelected;
    private ArrayList<JButton> roleButtons;
    private JButton continueButton;
    private JButton assignTownies;

    public PlayerRolePanel(ActionListener listener) {
        this.listener = listener;
        box.add(textField);
        box.add(button);
        button.addActionListener(listener);
        contentPane.add(new JScrollPane(textAreaOrder));
        contentPane.add(box, BorderLayout.SOUTH);
    }

    private void createRoleButtons() {
        ArrayList<String> availableRoles = scanForAvailableRoles();
        for (int count = 0; count < availableRoles.size(); count++) {
            if (!availableRoles.get(count).equals("Townie")) {
                JButton roleBtn = new JButton(availableRoles.get(count));
                roleBtn.setName("RoleButton " + (count+1));
                roleBtn.addActionListener(listener);
                if (availableRoles.get(count).contains("Mafia")) {
                    roleButtons.add(roleBtn);
                } else {
                    roleButtons.add(0, roleBtn);
                }
            }
        }
    }

    private ArrayList<String> scanForAvailableRoles() {
        ArrayList<String> availableRoles = new ArrayList<String>();
        Scanner fileScanner;
        try {
            fileScanner = new Scanner( new File(
                    "src/resources/roles.txt"));
            while(fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] split = line.split("\\|");
                availableRoles.add(split[0]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file: data/roles.txt");
            System.out.println("Please contacta a system admin about downloading the file again");
            availableRoles.add("No data/roles.txt");
        }
        System.out.println(availableRoles);
        return availableRoles;
    }

    public void clearRolesSelected() {
        rolesSelected.clear();
    }

    public ArrayList<JButton> getRoleButtons() {
        return roleButtons;
    }

    public JButton getAssignTownies() {
        return assignTownies;
    }


    public ArrayList<String> getRolesSelected() {
        return new ArrayList<>(rolesSelected);
    }

    public void addRole(String role) {
        rolesSelected.add(role);
    }

    public JButton getContinueButton() {
        return continueButton;
    }
}