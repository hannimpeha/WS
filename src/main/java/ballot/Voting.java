package ballot;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Voting {

    private String lynched;
    private Contest contest;
    private List<String> candidates;
    private ArrayList<List<String>> content;
    private ArrayList<List<String>> rawBallots;
    private FileReader fr;

    public Voting() {
    }

    public String run() {
        candidates = new ArrayList<String>(Arrays.<String>asList(
                "hyo", "ji", "yoo", "mi", "vi", "se", "ari"));
        rawBallots = preliminary();
        Contest contest = new Contest(candidates, rawBallots);
        lynched = contest.getWinner().iterator().next();
        return lynched;
    }

    public ArrayList<List<String>> preliminary() {
        try {
            fr = new FileReader("/Users/hannimpeha/" +
                    "HANNIMPEHA/Thesis/FascinatingProject/" +
                    "src/main/java/resource/ballots.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(fr);
        ArrayList<List<String>> content = new ArrayList<List<String>>();
        String[] values = new String[0];
        try {
            values = br.readLine().split(",");
        } catch (IOException e) {
            e.printStackTrace();
        }
        content.add(Arrays.asList(values));
        return content;
    }
}


