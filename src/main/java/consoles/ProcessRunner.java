package consoles;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.StringJoiner;

public class ProcessRunner extends ConsolePane {

    private List<String> cmds;
    private ActionListener listener;
    private StringJoiner sj;

    private Process process;

    public ProcessRunner(ActionListener listener, List<String> cmds) {
        super(listener);
        this.cmds = cmds;
        run();
    }

    public void run() {
        try {
            System.out.println("cmds = " + cmds);
            ProcessBuilder pb = new ProcessBuilder(cmds);
            pb.redirectErrorStream();
            process = pb.start();
            StreamReader reader = new StreamReader
                    (listener, process.getInputStream());
            // Need a stream writer...

            int result = process.waitFor();

            // Terminate the stream writer
            reader.join();

            sj = new StringJoiner(" ");
            cmds.stream().forEach((cmd) -> {
                sj.add(cmd);
            });
            sj.toString();
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    public void write(String text) throws IOException {
        if (process != null && process.isAlive()) {
            process.getOutputStream().write(text.getBytes());
            process.getOutputStream().flush();
        }
    }
}
