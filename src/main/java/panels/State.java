package panels;

import jason.Agents;
import playerInfo.Player;

import javax.swing.*;
import java.util.List;

public interface State {

    JPanel createPanel(Student student);
    JPanel createButton(Student student);
    List<Player> getPlayerInfo(Student student);
    List<String> getPlayerName(Student student);
    List<Agents> getPlayerAgent(Student stduent);
    String getName();
}
