package ballot;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Pile implements Iterable<Ballot> {

    private final String name;
    private final HashSet<Ballot> ballots = new HashSet<>();

    Pile(String candidateName) {
        name = candidateName;
    }

    public String getName() {
        return name;
    }

    public void addBallot(Ballot newBallot) {
        ballots.add(newBallot);
    }

    public int getTotalBallots() {
        return ballots.size();
    }

    @Override
    public Iterator<Ballot> iterator() {
        return ballots.iterator();
    }

    @Override
    public void forEach(Consumer<? super Ballot> action) {
        ballots.forEach(action);
    }

    @Override
    public Spliterator<Ballot> spliterator() {
        return ballots.spliterator();
    }
}
