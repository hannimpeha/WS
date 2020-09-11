package jason;

import jason.asSemantics.Agent;
import jason.asSyntax.Literal;
import jason.asSyntax.Term;
import jason.bb.DefaultBeliefBase;


public class MyBeliefBase extends DefaultBeliefBase {

    static Term APercept;
    static Term ASelf;

    private Agent ag;

    public MyBeliefBase(){
        init(ag, new String[]{"I have to survive"});
        reliablePerson(ASelf);
    }

    public void reliablePerson(Term term){
        System.out.println("This is reliable");
    }
}
