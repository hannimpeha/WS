package panels;

import ballot.Voting;
import controllers.Controller;
import controllers.GameController;
import util.LoadFileUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DayPanel {

    private LoadFileUtil fu;
    private NightPanel np;
    private String input;
    private Voting vote;
    private BufferedReader br;
    private InputStreamReader ir;
    private GameController gc;
    private int round;
    private String playerLine;

    public DayPanel(String input, int round){
        this.input = input;
        this.round = round;
    }

    public void start(int round) {
        ir = new InputStreamReader(System.in);
        br = new BufferedReader(ir);
        if (round == 0) {
            vote = new Voting();
            System.out.println(round);
            vote.run();
            System.out.println("Type \"night\" to continue.");
            np = new NightPanel(input);
            np.start();
        } else {
            ir = new InputStreamReader(System.in);
            br = new BufferedReader(ir);
            fu.loadFile();
            vote = new Voting();
            System.out.println(round);
            vote.run();
            fu.saveGame();
            System.out.println("Type \"night\" to continue.");
        }
    }
}
