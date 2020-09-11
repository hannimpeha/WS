package jason;

import jason.asSyntax.Literal;
import jason.environment.Environment;

public class MyEnvironment extends Environment {

    public void init(String[] args){
        addPercept("hannah", Literal.parseLiteral("wow"));
        addPercept("mafia", Literal.parseLiteral("me too"));
    }
}
