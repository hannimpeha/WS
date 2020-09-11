package jason;

import jason.asSemantics.Circumstance;
import jason.asSemantics.Event;
import jason.asSemantics.GoalListener;
import jason.asSyntax.Trigger;

public class MyCircumstance extends Circumstance implements GoalListener {

    private MyIntention intention = new MyIntention();

    public MyCircumstance(){

    }


    @Override
    public void goalStarted(Event event) {
       event.setIntention(intention);
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
