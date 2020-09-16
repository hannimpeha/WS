package stateMachine;

import controllers.Hannah;
import panels.NightPanel;
import javax.swing.*;

public class NightState extends State{

    public NightState(Hannah hannah) {
        super(hannah);
    }

    @Override
    public JPanel onContinue() {
        JPanel action = hannah.getState().onPrevious();
        hannah.changeState(new DayState(hannah));
        return action;
    }

    @Override
    public JPanel onPrevious() {
        hannah.changeState(new DayState(hannah));
        return new NightPanel();
    }


    @Override
    public String getCurrent() {
        return "Night";
    }
}
