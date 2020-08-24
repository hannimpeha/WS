package gameNetwork;

import org.gephi.graph.api.*;
import org.gephi.io.exporter.api.ExportController;
import org.gephi.project.api.ProjectController;
import org.gephi.project.api.Workspace;
import org.openide.util.Lookup;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HannahModel {

    public ProjectController pc() {
        ProjectController pc = Lookup.getDefault().lookup(ProjectController.class);
        pc.newProject();
        return pc;
    }

    public Workspace ws() {
        Workspace ws = pc().newWorkspace(pc().getCurrentProject());
        return ws;
    }

    public void buildExporter() throws IOException {
        GraphModel model = GraphModel.Factory.newInstance();
        Node n0 = model.factory().newNode();
        Node n1 = model.factory().newNode();
        Node n2 = model.factory().newNode();

        ArrayList<Node> nodes = new ArrayList<Node>(Arrays.asList(n0, n1, n2));

        Edge e1 = model.factory().newEdge(n0, n1, true);
        Edge e2 = model.factory().newEdge(n0, n2, true);
        Edge e3 = model.factory().newEdge(n2, n0, true);
        ArrayList<Edge> edges = new ArrayList<Edge>(Arrays.asList(e1, e2, e3));

        GraphController gc = Lookup.getDefault().lookup(GraphController.class);
        gc.getGraphModel(ws()).getDirectedGraph().addAllNodes(nodes);
        gc.getGraphModel(ws()).getDirectedGraph().addAllEdges(edges);
        ExportController ec = Lookup.getDefault().lookup(ExportController.class);
        File file = new File("hannimpeha.gexf");
        ec.exportFile(file);
    }
}