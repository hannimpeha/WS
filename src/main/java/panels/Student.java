package panels;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Student {

    private State state;
    private List<State> playList = new ArrayList<>();
    private int currentTrack = 0;

    public Student() {
        this.state = new PlayerNames(this);
        playList.add(new PlayerRoles(this));
        playList.add(new DayPanel(this));
        playList.add(new NightPanel(this));
        playList.add(new DayPanel(this));
        playList.add(new NightPanel(this));
        playList.add(new DayPanel(this));
        playList.add(new NightPanel(this));
        playList.add(new DayPanel(this));
        playList.add(new NightPanel(this));
        playList.add(new DayPanel(this));
        playList.add(new NightPanel(this));
        playList.add(new DayPanel(this));
        playList.add(new NightPanel(this));
        playList.add(new DayPanel(this));
        playList.add(new NightPanel(this));
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public String getName() { return state.getName(); }

    public JPanel createPanel(){ return state.createPanel(this);}

    public JPanel createButton() {return state.createButton(this);}

    public State nextTrack() {
        currentTrack++;
        if (currentTrack > playList.size() - 1) {
            currentTrack = 0;
        }
        return playList.get(currentTrack);
    }
}
