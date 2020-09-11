package jason;

import jason.agents.Mafia;
import jason.infra.centralised.RunCentralisedMAS;
import playerInfo.Player;

import java.util.List;

public class main {

    private static List<Player> playerInfo;

    public static void main(String[] args) {

        new RunCentralisedMAS();
        Mafia ma = new Mafia("Hyo", "Mafia");
        ma.run();

    }
}
