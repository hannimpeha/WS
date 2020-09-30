package panels;

import thatGraph.GraphVizExe;
import ballot.Voting;
import playerInfo.Player;
import util.LoadFileUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

public class DayPanel implements State {

    protected LoadFileUtil fu = new LoadFileUtil();
    protected Voting vote = new Voting();
    protected String victim = vote.run();
    protected List<Player> playerInfo = fu.loadPlayer()
            .stream().filter(a->a.getStatus()==1).collect(Collectors.toList());
    protected String path = "/Users/hannimpeha/HANNIMPEHA/Thesis/" +
            "FascinatingProject/src/main/java/resource/awesome.dot";
    protected GraphVizExe gv = new GraphVizExe();
    protected Student student;
    private static JPanel north = new JPanel();
    private static JPanel south = new JPanel();

    public DayPanel(Student student) {
        this.student = student;
    }

    public JPanel createPanel(Student student) {
        final JTextArea textAreaOrder =
                new JTextArea(20, 40);
        textAreaOrder.setText("There are " + playerInfo.size() + " number of Players\n");
        textAreaOrder.append("Player " + victim + " has been lynched\n");
        gv.readSource(path);
        textAreaOrder.append("Their relationship was\n" + gv.getDotSource());
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
            final JButton button = new JButton("Day");
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
        return "Day";
    }
}