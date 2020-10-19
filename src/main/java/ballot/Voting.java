package ballot;

import panels.Student;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class Voting {

    private Student student;
    private String lynched;
    private Contest contest;
    private List<String> playerName;
    private ArrayList<List<String>> rawBallots;
    private String ballotPath = "/Users/hannahlee/" +
            "HANNIMPEHA/Thesis/FascinatingProject/" +
            "src/main/java/resource/ballots.txt";

    public Voting(List<String> playerName) {
        this.playerName = playerName;
    }

    public String run() {
        rawBallots = preliminary();
        contest = new Contest(playerName, rawBallots);
        return lynched;
    }

    public ArrayList<List<String>> preliminary() {
        ArrayList<List<String>> content = new ArrayList<List<String>>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(ballotPath));
            String[] values = new String[0];
            values = br.readLine().split(",  ");
            content.add(Arrays.asList(values));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}