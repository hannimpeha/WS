package graphViz;

import static guru.nidi.graphviz.attribute.Attributes.attr;
import static guru.nidi.graphviz.attribute.Rank.RankDir.LEFT_TO_RIGHT;
import static guru.nidi.graphviz.model.Factory.*;

import guru.nidi.graphviz.attribute.Font;
import guru.nidi.graphviz.attribute.Rank;
import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.model.Graph;

import java.io.File;
import java.io.IOException;

import static guru.nidi.graphviz.model.Factory.graph;

public class GraphViz {


    public GraphViz() throws IOException {
            Graph g = graph("hannimpeha").directed()
                    .graphAttr().with(Rank.dir(LEFT_TO_RIGHT))
                    .nodeAttr().with(Font.name("arial"))
                    .linkAttr().with("class", "link-class")
                    .with(
                            node("hyo").link(node("ji")),
                            node("ji").link(node("hyo")),
                            node("ji").link(node("yoo")),
                            node("yoo").link(node("ji")),
                            node("yoo").link(node("mi")),
                            node("mi").link(node("yoo")),
                            node("mi").link(node("vi")),
                            node("vi").link(node("mi")),
                            node("vi").link(node("se")),
                            node("se").link(node("vi")),
                            node("se").link(node("ari")),
                            node("ari").link(node("se")),
                            node("ari").link(node("hyo")),
                            node("hyo").
                                    link(to(node("ari")).with(attr("weight", 5)))
                    );
            Graphviz.fromGraph(g).height(500).render(Format.PNG).
                    toFile(new File("example/hannimpeha.png"));
    }

    public static void main(String[] args) throws IOException {
        new GraphViz();
    }
}
