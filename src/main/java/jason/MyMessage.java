package jason;

import jason.asSemantics.Message;

public class MyMessage extends Message {

    public MyMessage(){
        setSender("hannah");
        setReceiver("mafia");
        setMsgId("hello");
    }
}
