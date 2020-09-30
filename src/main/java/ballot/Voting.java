package ballot;

import util.LoadFileUtil;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.List;


public class Voting {

    private String lynched;
    private Contest contest;
    private ArrayList<List<String>> rawBallots;
    private LoadFileUtil fu = new LoadFileUtil();
    private List<String> candidates = fu.loadFile();
    private String ballotPath = "/Users/hannimpeha/" +
            "HANNIMPEHA/Thesis/FascinatingProject/" +
            "src/main/java/resource/ballots.txt";

    public Voting() {
    }

    public String run() {
        rawBallots = preliminary();
        contest = new Contest(candidates, rawBallots);
        lynched = contest.getWinner().iterator().next();
        return lynched;
    }

    public ArrayList<List<String>> preliminary() {
        ArrayList<List<String>> content = new ArrayList<List<String>>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(ballotPath));
            String[] values = new String[0];
            values = br.readLine().split(", ");
            content.add(Arrays.asList(values));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}