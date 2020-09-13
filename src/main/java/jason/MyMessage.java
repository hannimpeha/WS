package jason;

import jason.asSemantics.Message;
import org.neo4j.graphdb.RelationshipType;

import java.util.List;
import java.util.Set;

public class MyMessage extends Message {

    private RelationshipType KNOWS;

    public MyMessage(List<Agent> agents){
        for(Agent agent: agents) {
            if(agent.hasRelationship(KNOWS)){
                misinformation(agent);
            } else {
                information(agent);
            }
        }
    }

    void information(Agent agent){
        setSender(agent.getName());
        for(Agent ag: agent.getiAmSending()) {
            setReceiver(ag.getName());
        }
        setMsgId("Mafia is "+ agent.getBB());
    }

    void misinformation(Agent agent){
        setSender(agent.getName());
        for(Agent ag: agent.getiAmSending()) {
            setReceiver(ag.getName());
        }
        setMsgId("Mafia is "+ agent.getBB());
    }


}
