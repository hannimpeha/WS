package consoleExample;

import java.io.*;
import java.util.Scanner;

public class RealSuccess {

    public RealSuccess() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        File file = new File("players.txt");
        PrintWriter pw = new PrintWriter(file);

        String in = "";
        while ( !(in = sc.nextLine()).equals("") ) {
            pw.println(in);
        }

        sc.close();
        pw.close();
    }

//    public void log(String message) {
//        PrintWriter out = null;
//        try {
//            out = new PrintWriter(new FileWriter(
//                    "players.txt", true), true);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        out.write(message);
//        out.close();
//    }
}
