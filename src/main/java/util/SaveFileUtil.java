package util;

import playerInfo.Player;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

public class SaveFileUtil {

    private static final String saveFile =
            "/Users/hannimpeha/HANNIMPEHA/" +
                    "Thesis/FascinatingProject" +
                    "/src/main/java/resource/saveGame.txt";;

    public static void saveGame(List<Player> playerInfo) {
        try (PrintWriter pw = new PrintWriter(
                new FileOutputStream(saveFile, false))) {
            for (Player p : playerInfo) {
                pw.print(p.getStatus() + ",");
                pw.print(p.getRole() + ",");
                pw.print(p.getName() + ",");
                pw.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}