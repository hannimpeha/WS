package jason;

import jason.asSemantics.Message;
import org.neo4j.graphdb.RelationshipType;

import java.util.List;

public class Messaging extends Message {

    private RelationshipType KNOWS;

    public Messaging(List<Agents> agents){
        for(Agents agent: agents) {
            if(agent.hasRelationship(KNOWS)){
                misinformation(agent);
            } else {
                information(agent);
            }
        }
    }

    void information(Agents agent){
        setSender(agent.getName());
        for(Agents ag: agent.getIAmSending()) {
            setReceiver(ag.getName());
        }
        setMsgId("Mafia is "+ agent.getBB());
    }

    void misinformation(Agents agent){
        setSender(agent.getName());
        for(Agents ag: agent.getIAmSending()) {
            setReceiver(ag.getName());
        }
        setMsgId("Mafia is "+ agent.getBB());
    }

}
