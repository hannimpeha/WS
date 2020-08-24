package util;

import playerInfo.Player;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class SaveFileUtil {

    private static final String saveFile = "src/resources/saveGame.txt";

    public static void saveGame(List<Player> playerInfo) throws FileNotFoundException {
        try(PrintWriter pw = new PrintWriter(saveFile)) {
            for (Player p : playerInfo) {
                pw.print(p.getStatus());
                pw.print(p.getRole());
                pw.print(p.getName());
                pw.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
