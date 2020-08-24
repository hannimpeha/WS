package playerInfo;

public class Townie extends Player {

    public Townie(String name, int position) {
        super(name, position);
    }

    public Townie(String name, int position, int status, boolean target) {
        super(name, position, status, target);
    }

    public Townie(Townie townie) {
        super(townie);
    }

    @Override
    public Player copy() {
        return new Townie(this);
    }

    @Override
    public int doAction(Player p) {
        return p.getStatus();
    }
}
