package gameNetwork;

import com.bayesserver.*;
import com.bayesserver.inference.*;

public class BayesServer {

    private Network network = new Network("Demo");
    private State aTrue = new State("True");
    private State aFalse = new State("False");
    private Node a = new Node("A", aTrue, aFalse);

    private State bTrue = new State("True");
    private State bFalse = new State("False");
    private Node b = new Node("B", bTrue, bFalse);

    private State cTrue = new State("True");
    private State cFalse = new State("False");
    private Node c = new Node("C", cTrue, cFalse);

    private Table tableA = a.newDistribution().getTable();
    private Table tableB = b.newDistribution().getTable();
    private Table tableC = c.newDistribution().getTable();


    public Network getNetwork() {
        network.getNodes().add(a);
        network.getNodes().add(b);
        network.getNodes().add(c);
        network.getLinks().add(new Link(a, b));
        network.getLinks().add(new Link(a, c));
        return this.network;
    }

    public void setNetwork(Network network) {
        this.network=network;
        this.setTableA(tableA);
        this.setTableB(tableB);
        this.setTableC(tableC);
    }

    public void setTableA(Table tableA) {
        tableA.set(0.1, aTrue);
        tableA.set(0.9, aFalse);
        a.setDistribution(tableA);
        this.setTableA(tableA);
    }

    public void setTableB(Table tableB) {
        tableB.set(0.2, aTrue, bTrue);
        tableB.set(0.8, aTrue, bFalse);
        tableB.set(0.15, aFalse, bTrue);
        tableB.set(0.85, aFalse, bFalse);
        b.setDistribution(tableB);
        this.setTableB(tableB);
    }

    public void setTableC(Table tableC) {
        tableC.set(0.3, aTrue, cTrue);
        tableC.set(0.7, aTrue, cFalse);
        tableC.set(0.4, aFalse, cTrue);
        tableC.set(0.6, aFalse, cFalse);
        c.setDistribution(tableC);
        this.setTableC(tableC);
    }

    Table queryA = new Table(a);
    Table queryB = new Table(b);
    Table queryC = new Table(c);


    public BayesServer() {

        Network myNetwork = getNetwork();

        InferenceFactory factory = new RelevanceTreeInferenceFactory();
        Inference inference = factory.createInferenceEngine(myNetwork);
        QueryOptions queryOptions = factory.createQueryOptions();
        QueryOutput queryOutput = factory.createQueryOutput();
        queryOptions.setLogLikelihood(true);
        inference.getEvidence().setState(aTrue);
        //inference.query(queryOptions, queryOutput);
        System.out.println(String.format(
                "P(A|B=True, C=True) = {%s,%s}, log-likelihood = %s.",
                this.queryA.get(this.aTrue), this.queryA.get(this.aFalse),
                queryOutput.getLogLikelihood()));
    }

}
