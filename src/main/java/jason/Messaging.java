package jason;

import jason.asSemantics.Message;

import java.util.List;

public class Messaging extends Message {

    public Messaging(List<Agents> playerAgent){
        for(Agents ag: playerAgent) {
            information(ag);
        }
    }

    public void information(Agents ag){
        setSender(ag.getName());
        for(String ags: ag.getIAmSending()) {
            setReceiver(ags);
        }
        //setMsgId(ag.getBB().toString());
    }

}
