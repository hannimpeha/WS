package playerInfo;

public class Doctor extends Townie {

    public Doctor(String name, int position) {
        super(name, position);
    }

    public Doctor(String name, int position, int status, boolean target) {
        super(name, position, status, target);
    }
}
