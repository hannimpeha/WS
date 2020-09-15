package panels;

import playerInfo.Player;

import java.awt.event.ActionListener;
import java.util.List;

public interface NightPanelActionListener extends ActionListener {
    void saveGameContinue(List<Player> playerInfo);
}
