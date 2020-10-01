package jason;

import playerInfo.Player;

import java.util.*;
import java.util.stream.Collectors;

public class Conjectures {

    private List<Double> defaultConjecture = new ArrayList<>();
    private Map<String, Map> sub = new HashMap<>();
    private Map<List<String>, List<Double>> realSub = new HashMap<>();
    private List<Player> playerInfo;
    private List<String> names;

    public Conjectures(List<Player> playerInfo) {
        this.playerInfo = playerInfo;
    }

    public Map<String, Map> makingDefault() {
        names = playerInfo.stream().map(a->a.getName()).collect(Collectors.toList());
        for(Player player: playerInfo) {
            double rand = Math.random();
            if (player.getRole() != "Mafia") {
                defaultConjecture = new ArrayList<>(
                        Arrays.asList(round(rand/1,2),
                                round(rand/2,2),
                                round(rand/3,2),
                                round(rand/4,2),
                                round(rand/5,2),
                                round(rand/6,2),
                                round(rand/7,2)));
            } else {
                defaultConjecture = new ArrayList<>(
                        Arrays.asList(round(rand/2,2),
                                round(rand/2,2),
                                round(rand/2,2),
                                round(rand/4,2),
                                round(rand/5,2),
                                round(rand/6,2),
                                round(rand/7,2)));
            }
            realSub.put(names, defaultConjecture);
            sub.put(player.getName(), realSub);
        }
        return sub;
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

}
