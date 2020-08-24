package playerInfo;

public class Mafia extends Player {

    public Mafia(String name, int position) {
        super(name, position);
    }

    public Mafia(String name, int position, int status, boolean target) {
        super(name, position, status, target);
    }

    public Mafia(Mafia mafia) {
        super(mafia);
    }

    @Override
    public Player copy() {
        return new Mafia(this);
    }

    @Override
    public int doAction(Player p) {
        return p.getStatus();
    }
}
