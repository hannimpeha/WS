package graphViz;

import java.io.File;

public class Proba
{
	public static void main(String[] args)
	{
		Proba p = new Proba();
		p.start2();
	}

	private void start2()
	{
		String dir = "/Users/hannimpeha/HANNIMPEHA/Thesis/" +
				"FascinatingProject/example";
		String input = dir + "/simple.dot";

		GraphVizExe gv = new GraphVizExe();
		gv.readSource(input);
		System.out.println(gv.getDotSource());

		String type = "gif";

		String repesentationType= "dot";

		File out = new File("/Users/hannimpeha/HANNIMPEHA/Thesis/" +
				"FascinatingProject/example/simple." + type);
		gv.writeGraphToFile( gv.getGraph(gv.getDotSource(), type, repesentationType), out );
	}
}
