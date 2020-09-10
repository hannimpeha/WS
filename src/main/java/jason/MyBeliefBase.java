package jason;

import jason.asSyntax.Literal;
import jason.bb.DefaultBeliefBase;

public class MyBeliefBase extends DefaultBeliefBase {

    private Literal perTown;
    private Literal perMafia;

    public MyBeliefBase(){
    }

    void runTown(){
        perTown = Literal.parseLiteral("I am Townies");
        perTown.addTerms(Literal.parseLiteral("There are 2 Mafia other than me"));
    }

    void runMafia(){
        perMafia = Literal.parseLiteral("We are Mafia");
        perMafia.addTerms(Literal.parseLiteral("Remainders are Townies"));
    }

}
