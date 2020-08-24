package ballot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BallotMain {

    public BallotMain() throws IOException {
        ArrayList<List<String>> rawBallots = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("src/resources/rawBallots.csv"));
        String line = br.readLine();
        String[] candidateArr = line.split(",");
        List<String> candidates = Arrays.asList(candidateArr);
        br.readLine();
        line = br.readLine();
        while(line != null) {
            String[] input = line.split(",");
            List<String> rawBallot = Arrays.asList(input);
            line = br.readLine();
        }
        Contest contest = new Contest(candidates,  rawBallots);
        System.out.println(contest.getWinner());
    }
}
