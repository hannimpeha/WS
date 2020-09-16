package state;

public class NightState extends State {

    public NightState(Hannah hannah) {
        super(hannah);
    }

    @Override
    public String onDay() {
        hannah.changeState(new DayState(hannah));
        return "Night";
    }

    @Override
    public String onNight() {
        String action = hannah.getState().onDay();
        hannah.changeState(new DayState(hannah));
        return action;
    }
}
