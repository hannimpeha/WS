package ballot;

import java.util.*;

public class Round {

    private final HashMap<String, Integer> voteDistribution;

    public Round(Collection<Pile> piles) {
        voteDistribution = new HashMap<>(piles.size());
        String name;
        int votes;
        for (Pile pile : piles) {
            name = pile.getName();
            votes = pile.getTotalBallots();
            voteDistribution.put(name, votes);
        }
    }

    public HashMap<String, Integer> getVoteDistribution() {
        return (HashMap<String, Integer>) voteDistribution.clone();
    }

    public int getVotes(String candidate) {
        int votes = 0;
        if (voteDistribution.containsKey(candidate)) {
            votes = voteDistribution.get(candidate);
        }
        return votes;
    }

    public HashSet<String> getNonEliminatedCandidates() {
        Collection<Integer> voteTotals = voteDistribution.values();
        int minVotes = voteTotals.stream().min(Comparator.naturalOrder()).get();
        Set<String> candidates = voteDistribution.keySet();
        HashSet<String> nonEliminatedCandidates = new HashSet<>();
        int votes;
        for (String candidate : candidates) {
            votes = voteDistribution.get(candidate);
            if (votes != minVotes) {
                nonEliminatedCandidates.add(candidate);
            }
        }
        return nonEliminatedCandidates;
    }

    public HashSet<String> findTopCandidates(Collection<String> restriction) {
        if (restriction.isEmpty()) {
            return new HashSet<>();
        }
        HashMap<String, Integer> voteDistRestricted = (HashMap<String, Integer>) voteDistribution.clone();
        for (String candidate : voteDistribution.keySet()) {
            if (!restriction.contains(candidate)) {
                voteDistRestricted.remove(candidate);
            }
        }
        Collection<Integer> voteTotals = voteDistRestricted.values();
        int maxVotes = voteTotals.stream().max(Comparator.naturalOrder()).get();
        Set<String> candidates = voteDistRestricted.keySet();
        HashSet<String> topCandidates = new HashSet<>();
        int votes;
        for (String candidate : candidates) {
            votes = voteDistRestricted.get(candidate);
            if (votes == maxVotes) {
                topCandidates.add(candidate);
            }
        }
        return topCandidates;
    }

}
