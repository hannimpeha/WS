package graphViz;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Combination {

    private List<List<String>> whole = new ArrayList<List<String>>();
    private List<String[]> list = new ArrayList<String[]>();
    private String[] result = new String[2];
    private FileWriter writer;
    private String path = "/Users/hannimpeha/HANNIMPEHA/Thesis/" +
            "FascinatingProject/example/awesome.dot";

    public static void main(String[] args) {
        new Combination();
    }


    public Combination() {
            writeDot();
    }

    public List<String[]> combination
            (String[] arr, int len, int startPosition, String[] result) {
        if (len == 0) {
            //System.out.println(Arrays.toString(result));
            return null;
        }
        for (int i = startPosition; i <= arr.length - len; i++) {
            result[result.length - len] = arr[i];
            combination(arr, len - 1, i + 1, result);
            list.add(result);
        }
        //return result;
       return list;
    }

    public void writeDot() {
          try(PrintStream out = new PrintStream(path, "UTF-8")) {
//        try (BufferedWriter out = new BufferedWriter(
//                new OutputStreamWriter(new FileOutputStream(
//                        "/Users/hannimpeha/HANNIMPEHA/Thesis/" +
//                                "FascinatingProject/example/" +
//                                "awesome.dot")))) {
            out.print("digraph {\n");
            String[] arr = {"hyo", "ji", "yoo", "mi", "vi","se", "ari"};
            combination(arr, 2, 0, new String[2])
                    .stream()
                    .map(a->Arrays.toString(a).join(" -> "))
                    .forEach(out::print);
//                    .forEach(a->{
//                        try{ out.write(a); }
//                        catch(IOException e){
//                            e.printStackTrace();
//                        }});

            //out.write(Arrays.stream(result).
            //                collect(Collectors.joining("->")));
            out.println(";\n");
            out.println("}");
            }catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
