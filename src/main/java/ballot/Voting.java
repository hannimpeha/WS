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
    private String playerLine;

    public String Voting(String playerLine) {
        lynched = contest.getWinner().iterator().next();
        return lynched;
    }

    public void run() {
        candidates = new ArrayList<String>(Arrays.<String>asList(
                "hyo", "ji", "yoo", "mi", "vi", "se", "ari"));
        rawBallots = preliminary();
        //Contest contest = new Contest(candidates, rawBallots);
        //System.out.println("Player \""+contest.getWinner().iterator().next()+"\" has been picked to be lynched.");
        System.out.println("Player \""+"Hyo"+"\" has been picked to be lynched.");
    }

    public ArrayList<List<String>> preliminary() {
        while (playerLine != null) {
            try {
                fr = new FileReader("/Users/hannimpeha/" +
                        "HANNIMPEHA/Thesis/FascinatingProject/" +
                        "src/main/java/resource/ballots.txt");
            } catch (FileNotFoundException exception) {
                return doSomething(playerLine);
            }
            BufferedReader br = new BufferedReader(fr);
            ArrayList<List<String>> content = new ArrayList<>();
            String[] values = new String[0];
            try {
                values = br.readLine().split(",");
            } catch (IOException exception) {
                return doSomething(playerLine);
            }
            content.add(Arrays.asList(values));
        }
        return content;
    }

    public ArrayList<List<String>> doSomething(String playerLine) {
        return null;
    }

}


