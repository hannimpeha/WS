package jason;

import jason.asSemantics.Message;
import org.neo4j.graphdb.RelationshipType;

import java.util.List;

public class Messaging extends Message {

    private RelationshipType KNOWS;

    public Messaging(List<Agents> agents){
        for(Agents agent: agents) {
            if(agent.getRole().contains("Mafia")){
                misinformation(agent);
            } else {
                information(agent);
            }
        }
    }

    void information(Agents agent){
        setSender(agent.getName());
        for(String ag: agent.getIAmSending()) {
            setReceiver(ag);
        }
        setMsgId("Mafia is "+ agent.getBB());
    }

    void misinformation(Agents agent){
        setSender(agent.getName());
        for(String ag: agent.getIAmSending()) {
            setReceiver(ag);
        }
        setMsgId("Mafia is "+ agent.getBB());
    }

}
