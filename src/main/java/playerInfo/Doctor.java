package playerInfo;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label="doctor")
public class Doctor extends Townie {

    public Doctor(String name, int position) {
        super(name, position);
    }

    public Doctor(String name, int position, int status, boolean target) {
        super(name, position, status, target);
    }
}
