package jason;

import jason.asSemantics.DefaultInternalAction;
import jason.asSemantics.Message;
import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Term;

public class MyInternalAction extends DefaultInternalAction {

    private Message message = new MyMessage();
    private String hello = "Hello Mafia";

    @Override
    public Object execute(TransitionSystem ts,
                          Unifier un,
                          Term[] args){
        sending("hannah");
        receiving("mafia");
    return true;
    }

    void sending(String agName) {
        if(message.getMsgId()=="hello"){
            System.out.println("great");
        }
    }

    void receiving(String agName){

    }
}
