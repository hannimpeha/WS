package controllers;

import util.LoadFileUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {

    private SetUpController suc;
    private GameController gc;
    private InputStreamReader ir;
    private BufferedReader br;
    private LoadFileUtil fu;
    private String input;

    public void Controller() {
    }

    public void run() {
        System.out.println("\"game\" or \"exit\".");
        ir = new InputStreamReader(System.in);
        br = new BufferedReader(ir);
        fu = new LoadFileUtil();
        int round = 0;
        try {
            do{
                input = br.readLine();
                switch(input) {
                    case "game":
                        fu.newFile();
                        input = br.readLine();
                        new SetUpController(input).start(0);
                    default:
                        break;
                    }
            } while (!input.equalsIgnoreCase("exit"));
        }catch(IOException exception) {
            exception.printStackTrace();
        }
    }

}
