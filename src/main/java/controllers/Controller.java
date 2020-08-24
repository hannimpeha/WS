package controllers;

import util.LoadFileUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class Controller implements ActionListener {

    private JFrame frame;
    private LoadFileUtil fu;
    private SetUpController suc;
    private GameController gc;
    private MainController mc;

    public Controller() {
        frame = new JFrame();
    }

    public void run() {
        suc = new SetUpController(frame, this);
        gc = new GameController(frame, this);
        mc = new MainController(frame, this);
        fu = new LoadFileUtil();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame source = (JFrame) e.getSource();
        String name = source.getName();

        switch (name) {
            case "Day":
                suc.start();
                fu.newFile(suc.getPlayerNames(), suc.getRoles());
                break;
            case "Night":
                fu.loadFile();
                gc.start(fu.getPlayerInfo());
                break;
            case "Home":
                mc.start();
                break;
            default:
                break;
        }
    }
}
