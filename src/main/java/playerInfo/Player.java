package playerInfo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jason.asSemantics.Agent;
import org.neo4j.graphdb.Node;

public abstract class Player extends Agent implements Node {


    private String name="";
    private String role="";
    private int position;
    private int status;
    private boolean target;

    protected final int DEAD = 0;
    protected final int ALIVE = 1;
    protected final int TARGETED = 2;
    protected final int HEALED = 3;


    public Player(String name, String role, int position) {
        this.name = name;
        this.role = role;
        this.position = position;
        this.status = 1;
        this.target = false;
    }

    public Player(String name, String role, int status, boolean target) {
        this.name = name;
        this.role = role;
        this.status = status;
        this.target = target;
    }

    public Player(String name, String role, int position, int status, boolean target) {
        this.name = name;
        this.role = role;
        this.position = position;
        this.status = status;
        this.target = target;
    }

    public Player(Player p) {
        this.name = p.name;
        this.role = p.role;
        this.position = p.position;
        this.status = p.status;
        this.target = p.target;
    }

    public abstract Player copy();

    protected List<String> scan(String roleName) throws IOException {
        String location = "/Users/hannimpeha/HANNIMPEHA/" +
                "Thesis/FascinatingProject" +
                "/src/main/java/resource/roles.txt";;;
        List<String> role = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(location));
        String line = br.readLine();
        while(line!=null){
            if(line.contains(roleName)) {
                String[] split = line.split("\\|");
                role.add(split[0]);
                role.add(split[1]);
                role.add(split[2]);
                break;
            }
        }
        return role;
    }


    protected void setRole(List<String> roleInfo) {
        role = roleInfo.get(0);
    }

    public abstract int doAction(Player p);

    protected void setPosition() {
        if(getRole().contains("Mafia")) {
            position = 0;
        } else if(getRole().contains("Townie")) {
            position = 1;
        } else if(getRole().contains("Doctor")){
            position = 2;
        } else {
            position = 1;
        }
    }

    protected void setPosition(int position) {
        this.position = position;
        setRole(position);
    }

    protected void setRole(int position)  {
        if (position==0) {
            role = "Kill a Townie each night. Make the majority of the Mafia by any means";
        } else if (position == 1) {
            role = "You have nothing to do at night. Lynch all members of Mafia.";
        } else if (position == 2){
            role = "Heal another player each night. Lynch all members of Mafia.";
        } else {
            role = "";
        }
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setTarget(boolean target) {
        this.target = target;
    }

    public String getName() {
        return this.name = name;
    }

    public String getRole() {
        return this.role = role;
    }

    public int getPosition() {
        return this.position;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean getTarget() {
        return this.target;
    }

}