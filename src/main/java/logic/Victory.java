package logic;

import panels.Student;
import playerInfo.Player;

import java.util.List;
import java.util.stream.Collectors;

public class Victory {

    private Student student;
    private List<Player> playerInfo;

    public Victory(Student student) {
        this.student = student;
        playerInfo = student.getPlayerInfo();
    }

    public String victoryMessage() {
        if(countingMafia(playerInfo)>=countingTownie(playerInfo)) {
            return "Mafia has won.\n";
        } else {
            return "Townies still have some time.\n";
        }
    }

    public int countingMafia(List<Player> playerInfo) {
        return playerInfo.stream()
                .map(a->a.getRole())
                .filter(a->a.contains("Mafia"))
                .collect(Collectors.toList()).size();
    }

    public int countingTownie(List<Player> playerInfo) {
        return playerInfo.stream()
                .map(a->a.getRole())
                .filter(a->!a.contains("Mafia"))
                .collect(Collectors.toList()).size();
    }
}
