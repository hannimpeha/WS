package ballot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Ballot {

    private final ArrayList<String> ballotArr;

    public Ballot(List<String> rankedChoices) {
        ballotArr = new ArrayList<>(rankedChoices);
    }

    public int getNumberRanked() {
        return ballotArr.size();
    }

    public String getVote(Collection<String> activeCandidates) {
        String vote = "";
        ArrayList<String> activeCandidatesOnThisBallot = (ArrayList<String>) ballotArr.clone();
        if(!activeCandidatesOnThisBallot.isEmpty()) {
            vote = activeCandidatesOnThisBallot.get(0);
        }
        return vote;
    }
}
