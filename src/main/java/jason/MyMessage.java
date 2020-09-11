package jason;

import jason.asSemantics.Message;

public class MyMessage extends Message {

    public MyMessage(){
        information();
        misinformation();
    }

    void information(){
        setSender("hannah");
        setReceiver("mafia");
        setMsgId("Hello");
        Message r = new Message("tell", "hannah",
                "mafia", "msg(\"You are robot\")");
    }

    void misinformation(){
        setSender("mafia");
        setReceiver("hannah");
        setMsgId("Hyo is Mafia");
    }


}
