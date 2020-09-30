package panels;

import playerInfo.Player;

import javax.swing.*;
import java.util.List;

public interface State {

    JPanel createPanel(Student student);
    JPanel createButton(Student student);
    List<Player> getPlayerInfo(Student student);
    List<String> getPlayerName(Student student);
    String getName();
}
