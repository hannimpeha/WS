package logic;

import playerInfo.*;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Player> playerInfo = new ArrayList<>();
    private List<String> playerNames = new ArrayList<>();
    private List<String> mafiaMembers = new ArrayList<>();
    private List<Integer> events = new ArrayList<>();
    //private List<Player> players = new ArrayList<Player>(Arrays.<Player>asList(mafia, townie, doctor));

    public Game(List<Player> playerInfo) {
        this.playerInfo = playerInfo;
        //this.setPlayer(players);
        playerNames();
    }

    private void playerNames() {
        for(Player p: playerInfo) {
            if(p.getStatus()!=0) {
                playerNames.add(p.getName());
            }
            if(p.getRole().contains("Mafia")) {
                mafiaMembers.add(p.getName());
            }
        }
    }

    public void lynchPlayer() {
        for(Player p: playerInfo) {
            if(p.getTarget()==true) {
                setPlayerStatus(p.getPosition(), 0);
            }
        }
    }

    public void nightAction() {
        for(Player p: playerInfo) {
            if(p.getRole().contains("Mafia")) {
                if(p.getTarget()) {
                    int status = p.doAction(getPlayer(p.getPosition()));
                    setPlayerStatus(p.getPosition(),status);
                }
            }
        }
    }

    public String checkWinner() {
        int mafiaTotal = 0;
        int townTotal = 0;
        for(Player p: playerInfo) {
            if(p.getStatus()!=0) {
                if(p.getRole().contains("Mafia")) {
                    mafiaTotal++;
                }else{
                    townTotal++;
                }
            }
        }if(mafiaTotal>=townTotal) {
            System.out.println("The Mafia have a majority: "+mafiaTotal+"|"+townTotal);
            return "Mafia";
        }
        return "Town";
    }

    public void setPlayerStatus(int position, int status) {
        playerInfo.get(position).setStatus(status);
    }

    public void setPlayerTarget(int position, boolean target) {
        playerInfo.get(position).setTarget(target);
    }
    //protected void setPlayer(List<Player> players) {
    //    this.players = players;
    //}
    public List<Player> getPlayerInfo() {
        List<Player> clone = new ArrayList<Player>(playerInfo);
        return clone;
    }

    public List<String> getMafiaMember() {
        List<String> clone = new ArrayList<String>(mafiaMembers);
        return clone;
    }

    public Player getPlayer(int i) {
        if(i>=0 && i< playerInfo.size()) {
            return playerInfo.get(i).copy();
        } else {
            return new Townie("No player"+i, -1);
        }
    }

}
