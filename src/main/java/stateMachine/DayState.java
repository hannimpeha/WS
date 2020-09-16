package stateMachine;

import controllers.Hannah;
import panels.DayPanel;
import javax.swing.*;

public class DayState extends State {

    public DayState(Hannah hannah) {
        super(hannah);
    }

    @Override
    public JPanel onContinue() {
        JPanel action = hannah.getState().onPrevious();
        hannah.changeState(new NightState(hannah));
        return action;
    }

    @Override
    public JPanel onPrevious() {
        hannah.changeState(new NightState(hannah));
        return new DayPanel();
    }


    @Override
    public String getCurrent() {
        return "Day";
    }

}
