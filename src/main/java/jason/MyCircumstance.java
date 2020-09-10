package jason;

import jason.asSemantics.Circumstance;
import jason.asSemantics.Event;
import jason.asSemantics.Intention;
import jason.asSyntax.Literal;
import jason.asSyntax.Trigger;

public class MyCircumstance extends Circumstance {

    private Trigger trigger = new Trigger(
            Trigger.TEOperator.add,
            Trigger.TEType.belief,
            Literal.parseLiteral("I also love myself"));
    private Event event;
    private Intention intention = new Intention();

    public MyCircumstance(){
        event = new Event(trigger, intention);
    }


}
