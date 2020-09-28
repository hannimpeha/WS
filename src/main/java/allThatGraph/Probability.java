package allThatGraph;

import java.io.File;

public class Probability {

    private String path = "/Users/hannimpeha/HANNIMPEHA/Thesis/" +
            "FascinatingProject/example/awesome.dot";

    public Probability() {
    }

    public void start() {
        GraphVizExe gv = new GraphVizExe();
        gv.readSource(path);
        System.out.println(gv.getDotSource());

        String type = "gif";

        String repesentationType= "dot";

        File out = new File("/Users/hannimpeha/HANNIMPEHA/Thesis/" +
                "FascinatingProject/example/simple." + type);
        gv.writeGraphToFile( gv.getGraph(gv.getDotSource(), type, repesentationType), out );
    }
}
