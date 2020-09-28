package allThatGraph;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Combination {

    private List<String[]> list = new ArrayList<String[]>();
    private String path = "/Users/hannimpeha/HANNIMPEHA/Thesis/" +
            "FascinatingProject/example/awesome.dot";

    public Combination() {
    }

    public void writeDot() {
        try(PrintStream out = new PrintStream(path, "UTF-8")) {
            out.print("digraph {\n");
            String[] arr = {"hyo", "ji", "yoo", "mi", "vi","se", "ari"};
            //combination(arr, 2, 0, new String[2])
            makePairsFromArray(arr)
                    .stream()
                    .map(a->String.join(" -> ", a)+";\n")
                    .forEach(out::print);
            out.println("}");
        }catch (IOException ioException) {
            ioException.printStackTrace();
        }
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
            list.add(result.clone());
        }
        return list;
    }

    public static List<String[]> makePairsFromArray(String[] arr) {
        List<String[]> list = new ArrayList<>();

        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                String[] pair = new String[2];
                pair[0] = arr[i];
                pair[1] = arr[j];
                list.add(pair);
                String[] opp = new String[2];
                opp[0] = arr[j];
                opp[1] = arr[i];
                list.add(opp);
            }
        }
        return list;
    }

}
