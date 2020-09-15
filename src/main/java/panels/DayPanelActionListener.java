package panels;

import playerInfo.Player;

import java.awt.event.ActionListener;
import java.util.List;

public interface DayPanelActionListener extends ActionListener {

    void deletePlayers(List<Player> playerInfo, String lynched);
    void saveGameContinue(List<Player> playerInfo);
}
