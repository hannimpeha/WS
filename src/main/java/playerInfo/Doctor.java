package playerInfo;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label="doctor")
public class Doctor extends Townie {

    public Doctor(String name, String role, int position) {
        super(name, role, position);
    }

    public Doctor(String name, String role, int position, int status, boolean target) {
        super(name, role, position, status, target);
    }
}
