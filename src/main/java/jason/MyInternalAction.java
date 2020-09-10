package jason;

import jason.asSemantics.*;
import jason.asSyntax.Literal;
import jason.asSyntax.Term;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyInternalAction extends DefaultInternalAction {

    private Message message = new MyMessage();
    private Literal perceptsT = Literal.parseLiteral("I am Townie");
    private Literal perceptsM = Literal.parseLiteral("I am Mafia");
    private List<String> names = new ArrayList<String>(
            Arrays.asList("hannah", "mafia"));
    private MyBeliefBase bb = new MyBeliefBase();
    private MyMessage mm = new MyMessage();
    private MyPlan plan = new MyPlan();

    @Override
    public Object execute(TransitionSystem ts,
                          Unifier un,
                          Term[] args){
        designation(names);
        System.out.println(plan.reputationBad());
        communication(names);
    return true;
    }

    void designation(List<String> names) {
        for (String name: names) {
            switch(name){
                case "hannah":
                    bb.runTown();
                case "mafia":
                    bb.runMafia();
            }
        }
    }


    void communication(List<String> names){
        for (String name: names) {
            switch(name){
                case "hannah":
                    mm.information();
                case "mafia":
                    mm.misinformation();
            }
        }
    }


}
