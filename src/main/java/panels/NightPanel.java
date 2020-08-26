package panels;

import controllers.Controller;
import controllers.GameController;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NightPanel {

    private String input;
    private GameController gc;
    private BufferedReader br;
    private InputStreamReader ir;
    private int round;

    public NightPanel(String input) {
        this.input = input;
    }

    public void start() {
        if(round==0) {
            System.out.println("what to do in the nights.");
        } else {
        System.out.println("This is second time nights.");
        }
        System.out.println("Type \"day\" to continue.");
        ir = new InputStreamReader(System.in);
        br = new BufferedReader(ir);
    }

}

