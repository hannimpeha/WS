package logic;

import panels.Student;

import java.util.List;
import java.util.Random;

public class NightAction {

    private Random randomGenerator;
    private Student student;
    private List<String> playerName;

    public NightAction(Student student){
        this.student = student;
        playerName = student.getPlayerName();
    }

    public String nightAction() {
        randomGenerator = new Random();
        int ind = randomGenerator.nextInt(playerName.size()-1);
        return playerName.get(ind);
    }
}
