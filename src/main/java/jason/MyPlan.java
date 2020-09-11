package jason;

import jason.asSyntax.*;

public class MyPlan extends Plan {

    protected Trigger.TEOperator op;
    protected Trigger.TEType ty;
    private Trigger trigger = new Trigger(
            op.goalState, ty.achieve, Literal.parseLiteral("Hyo is Mafia"));

    public MyPlan(){
        reputationGood();
        reputationBad();
    }

    Plan reputationGood(){
        Plan reputationGood = new Plan(new Pred("reliable"),
                trigger, getContext(), getBody());
        return reputationGood;
    }

    Plan reputationBad(){
        Plan reputationBad = new Plan(new Pred("unreliable"),
                trigger, getContext(), getBody());
        return reputationBad;
    }

}
