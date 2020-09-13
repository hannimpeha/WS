package panels;

import ballot.Voting;
import org.neo4j.graphdb.Node;
import playerInfo.Player;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class DayPanel {

    private Voting vote = new Voting();
    private List<Player> playerInfo = new ArrayList<>();
    private List<Node> playerNode = new ArrayList<>();
    private static final String saveFile =
            "/Users/hannimpeha/HANNIMPEHA/" +
                    "Thesis/FascinatingProject" +
                    "/src/main/java/resource/saveGame.txt";

    public DayPanel() {
        createPanel();
        deletePlayers(playerInfo, vote.run());
    }

    public JTextArea createPanel() {
        final JTextArea textAreaOrder =
                new JTextArea(20, 30);
        Voting vote = new Voting();
        textAreaOrder.setText("Player "+vote.run()+" has been lynched");
        textAreaOrder.setEditable(false);
        return textAreaOrder;
    }

    public void deletePlayers(List<Player> playerInfo, String lynched) {
        for(Player p:playerInfo) {
            if(p.getName()==lynched) {
                p.setStatus(0);
            }
        }
    }

    public static void saveGame(List<Player> playerInfo) {
        try(PrintWriter pw = new PrintWriter(
                new FileOutputStream(saveFile, false))) {
            for (Player p : playerInfo) {
                pw.print(p.getStatus()+",");
                pw.print(p.getRole()+",");
                pw.print(p.getName()+",");
                pw.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
