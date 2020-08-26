package consoleExample;

import com.itextpdf.text.pdf.codec.Base64;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsoleSuccess {

    //private Scanner name;
    private BufferedWriter writer;
    private InputStreamReader ir;
    private BufferedReader br;
    private File file;
    private String input;
    private FileWriter fw;
    //private FileOutputStream fo;
    //private OutputStreamWriter ow;
    private Files realFile;
    private PrintWriter pw;
    //private BufferedWriter out = new BufferedWriter(new FileWriter("c://output.txt"));

    public ConsoleSuccess() throws IOException {
        //System.out.println("Press Key to Continue.");
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //String lineFromInput = in.readLine();
        //PrintStream out = new PrintStream(String.valueOf(new FileWriter("players.txt")));
        //out.println(lineFromInput);
        //out.close();
        //System.setOut(out);
        //String file = "players.txt";
        //out.write(in.readLine());
        //out.close();
        //in.close();
        //List<String> lines = Arrays.asList("Hannah", "John");
        //name = new Scanner(System.in);
        file = new File("players.txt");
        fw = new FileWriter(file);
        pw = new PrintWriter(fw);
        ir = new InputStreamReader(System.in);
        br = new BufferedReader(ir);

        input = null;
        try {
            do{
                System.out.println("Please Type Day to Start the Game.");
                input = br.readLine();
                pw.println(input);
                System.out.println(input);
            } while (!input.equalsIgnoreCase("exit"));
        }catch(IOException exception) {
            exception.printStackTrace();
        }
        pw.close();
        //name.useDelimiter("\\n");
        //name.hasNext();
        //Files.write(Paths.get("players.txt"), lines);
        //file = new File("players.txt");
        //String content = name.next();
        //realFile.write(Paths.get("players.txt"), content.getBytes(StandardCharsets.UTF_8));
        //realFile.writeString();
        //fo = new FileOutputStream(file);
        //ow = new OutputStreamWriter(fo);
        //fw = new FileWriter(file);
        //fw.write(name.nextLine());
//        String file = "players.txt";
//        Scanner scan = new Scanner(System.in);
//        scan.useDelimiter("\\n");
//        System.out.println("Enter DONE to terminate");
//        try (PrintWriter fw = new PrintWriter(new File(file))) {
//            String line = null;
//            while ((line = scan.nextLine()) != null) {
//                if (line.trim().equalsIgnoreCase("done")) {
//                    System.out.println("Exiing");
//                    System.exit(0);
//                }
//            }
//            fw.println(line);
//        } catch (FileNotFoundException ex) {
//            ex.printStackTrace();
//        }
        //pw = new PrintWriter(file);
        //while(name.nextLine()==null){
        //    System.exit(0);
        //}
        //pw = fw;
        //PrintStream ps = new PrintStream(fo);
        //System.setOut(ps);
        //pw.print(name.nextLine());
        //pw.write(name.nextLine());
        //pw.close();
        //FileUtils.writeStringToFile(file, name.next());
        //writer = new BufferedWriter(fw);
        //writer.write(name.nextLine());
        //ow.write(name.nextLine());
        //ow.close();
        //writer.newLine();
        //writer.close();
        //fw.close();
        //name.close();
        //fw.close();
    }
}
