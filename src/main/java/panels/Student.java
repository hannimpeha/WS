package panels;

public class Student {

    private State state;

    public Student() {
        this.state = new DayPanel();
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public String getName() { return state.getName(); }

}
