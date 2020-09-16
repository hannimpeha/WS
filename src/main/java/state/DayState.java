package state;

public class DayState extends State{

    public DayState(Hannah hannah) {
        super(hannah);
    }

    @Override
    public String onDay() {
        String action = hannah.getState().onNight();
        hannah.changeState(new NightState(hannah));
        return action;
    }

    @Override
    public String onNight() {
        hannah.changeState(new NightState(hannah));
        return "Day";
    }
}
