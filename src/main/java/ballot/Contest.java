package ballot;

import java.util.*;

public class Contest {
    private final ArrayList<Round> rounds = new ArrayList<>();
    private final HashMap<String, Pile> piles;
    private HashSet<String> activeCandidates;
    private HashSet<String> allCandidates;
    private boolean contestRun = false;

    public Contest(List<String> candidates, Collection<List<String>> rawBallots) {
        allCandidates = new HashSet<>(candidates);
        activeCandidates = new HashSet<>(candidates);
        piles = new HashMap<>(candidates.size());
        Pile pile;
        for (String candidate : candidates) {
            pile = new Pile(candidate);
            piles.put(candidate, pile);
        }
        Pile initialPile = new Pile("__initialPile");
        Ballot ballot;
        for (List<String> rawBallot : rawBallots) {
            ballot = new Ballot(rawBallot);
            initialPile.addBallot(ballot);
        }
        piles.put("__initialPile", initialPile);
        allCandidates.add("__initialPile");
    }

    public void runContest() {
        contestRun = true;
        eliminateCandidates();
        Round round;
        do {
            round = createNewRound();
            rounds.add(round);
            activeCandidates = round.getNonEliminatedCandidates();
            eliminateCandidates();
        } while (!activeCandidates.isEmpty());
    }

    private Round createNewRound() {
        HashSet<Pile> activeCandidatesPiles = new HashSet<>(activeCandidates.size());
        Pile activeCandidatePile;
        for(String activeCandidate: activeCandidates) {
            activeCandidatePile = piles.get(activeCandidate);
            activeCandidatesPiles.add(activeCandidatePile);
        }
        return new Round(activeCandidatesPiles);
    }

    private void eliminateCandidates() {
        Pile pile;
        for(String candidate: allCandidates) {
            if(!activeCandidates.contains(candidate)) {
                pile = piles.get(candidate);
                redistributeBallots(pile);
            }
        }
    }

    private void redistributeBallots(Pile pile) {
        String vote;
        Pile votePile;
        for(Ballot ballot: pile) {
            vote = ballot.getVote(activeCandidates);
            if(!vote.isEmpty()) {
                votePile = piles.get(vote);
                votePile.addBallot(ballot);
            }
        }
    }

    public ArrayList<HashMap<String, Integer>> getVoteDistributions() {
        if(!contestRun) {
            runContest();
        }
        ArrayList<HashMap<String, Integer>> voteDistributions = new ArrayList<>(rounds.size());
        HashMap<String, Integer> voteDist;
        for(Round round: rounds) {
            voteDist = round.getVoteDistribution();
            voteDistributions.add(voteDist);
        }
        return voteDistributions;
    }

    public HashSet<String> getWinner() {
        if(!contestRun) {
            runContest();
        }
        HashSet<String> topCandidates = (HashSet<String>) allCandidates.clone();
        int roundNum = rounds.size()-1;
        Round currentRound;
        while((topCandidates.size()!=1)&&(roundNum>=0)) {
            currentRound = rounds.get(roundNum);
            topCandidates = currentRound.findTopCandidates(topCandidates);
            roundNum--;
        }
        return topCandidates;
    }
}