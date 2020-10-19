package thatGraph;

import java.io.File;

public class Probability {

    private String path = "/Users/hannahlee/HANNIMPEHA/Thesis/" +
            "FascinatingProject/src/main/java/resource/awesome.dot";

    public Probability() {
    }

    public void start() {
        GraphVizExe gv = new GraphVizExe();
        gv.readSource(path);
        //System.out.println(gv.getDotSource());

        String type = "png";

        String repesentationType= "dot";

        File out = new File("/Users/hannahlee/HANNIMPEHA/Thesis/" +
                "FascinatingProject//src/main/java/resource/simple." + type);
        gv.writeGraphToFile( gv.getGraph(gv.getDotSource(), type, repesentationType), out );
    }
}
