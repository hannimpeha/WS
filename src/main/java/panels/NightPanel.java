package panels;

import logic.NightAction;
import logic.Victory;
import playerInfo.Player;
import util.LoadFileUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

public class NightPanel implements State {

    protected LoadFileUtil fu = new LoadFileUtil();;
    protected NightAction na = new NightAction();
    protected Victory victory;
    protected String victim = na.nightAction();
    protected List<Player> playerInfo = fu.loadPlayer();
    protected Student student;
    private static JPanel contentPane = new JPanel();
    private static JPanel north = new JPanel();
    private static JPanel south = new JPanel();

    public NightPanel(Student student) {
        this.student = student;
    }

    public JPanel createPanel(Student student) {
            final JTextArea textAreaOrder =
                    new JTextArea(20, 40);
            textAreaOrder.setText("Night Start\n");
            victory = new Victory(fu.loadPlayer());
            textAreaOrder.append(victory.victoryMessage());
            textAreaOrder.setEditable(false);
            north.add(new JScrollPane(textAreaOrder));
            contentPane.add(north);
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
                    fu.saveGame(playerInfo.stream()
                            .filter(a -> a.getName().contains(victim))
                            .collect(Collectors.toList()));
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