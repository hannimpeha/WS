package panels;

import logic.NightAction;
import logic.Victory;
import playerInfo.Player;
import util.LoadFileUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

public class NightPanel implements State {

    protected LoadFileUtil fu = new LoadFileUtil();;
    protected NightAction na = new NightAction();
    protected String victim = na.nightAction();
    protected List<Player> playerInfo = fu.loadPlayer()
            .stream().filter(a->a.getStatus()==1).collect(Collectors.toList());
    protected Victory victory = new Victory(playerInfo);
    protected Student student;
    private static JPanel north = new JPanel();
    private static JPanel south = new JPanel();

    public NightPanel(Student student) {
        this.student = student;
    }

    public JPanel createPanel(Student student) {
            final JTextArea textAreaOrder =
                    new JTextArea(20, 40);
            textAreaOrder.setText("Night Start\n");
            textAreaOrder.append(victim+" has been chosen by Mafias");
            textAreaOrder.append(victory.victoryMessage());
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
            final JButton button = new JButton("Night");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    playerInfo.stream()
                            .filter(a->a.getName().contains(victim))
                            .forEach(a->a.setStatus(0));
                    fu.saveGame(playerInfo);
                }
            });
            box.add(button);
            south.add(box);
        return south;
    }

    @Override
    public String getName() {
        return "Night";
    }
}