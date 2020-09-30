package panels;

import jason.NCT;
import jason.infra.centralised.RunCentralisedMAS;
import playerInfo.Player;
import util.LoadFileUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PlayerRoles implements State{

    protected LoadFileUtil fu = new LoadFileUtil();
    protected List<Player> playerInfo = fu.loadPlayer();
    protected Student student;
    private static JPanel north = new JPanel();
    private static JPanel south = new JPanel();

    public PlayerRoles(Student student) {
        this.student = student;
    }

    public JPanel createPanel(Student student) {
            final JTextArea textAreaOrder =
                    new JTextArea(20, 40);
            textAreaOrder.setText("\n   Assigned Roles are as follows.\n\n");
            textAreaOrder.append("    ----------------------------\n\n");
            for (int i = 0; i < playerInfo.size(); i++) {
                textAreaOrder.append(
                        "    Player " + playerInfo.get(i).getName() + " is " +
                                playerInfo.get(i).getRole() + ".\n\n");
            }
            textAreaOrder.setEditable(false);
            north.add(new JScrollPane(textAreaOrder));
        return north;
    }

    public JPanel createButton(Student student) {
            final Box box = Box.createHorizontalBox();
            box.setBorder(BorderFactory.createEmptyBorder(
                    5, 5, 5, 5));
            box.add(Box.createHorizontalStrut(5));
            box.add(Box.createHorizontalGlue());
            final JButton button = new JButton("Role");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new RunCentralisedMAS();
                    new NCT(playerInfo);
                }

            });
            box.add(button);
            south.add(box);
        return south;
    }

    @Override
    public String getName() {
        return "Role";
    }
}
