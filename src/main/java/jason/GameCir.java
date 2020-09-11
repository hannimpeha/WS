package jason;

import jason.asSemantics.Circumstance;
import jason.asSemantics.Event;
import jason.asSemantics.GoalListener;
import jason.asSemantics.Intention;
import jason.asSyntax.Trigger;

public class GameCir extends Circumstance implements GoalListener {

    private Intention in;

    public GameCir(){

    }

    @Override
    public void goalStarted(Event event) {
       event.setIntention(in);
    }

    @Override
    public void goalFinished(Trigger trigger, FinishStates finishStates) {
    }

    @Override
    public void goalFailed(Trigger trigger) {
    }

    @Override
    public void goalSuspended(Trigger trigger, String s) {
    }

    @Override
    public void goalResumed(Trigger trigger) {
    }
}
