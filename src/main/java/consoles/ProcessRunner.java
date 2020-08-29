package consoles;


public class ProcessRunner extends Thread {

    //private List<String> cmds;
    private CommandListener listener;
    private CommandListener orderListener;
    private String order;
    private String command;
    private Process process;


    public ProcessRunner() {
        this.orderListener = orderListener;
        this.listener = listener;
        start();
    }

    @Override
    public void run() {
        //read(orderListener.commandOutput(process.getOutputStream().toString()));
        //write(listener.commandOutput(process.getInputStream().toString()));
    }

    public void read(String command) {
        StreamReader reader =
                new StreamReader(listener, process.getInputStream());

    }
    public void write(String text) {
        StreamWriter writer =
                new StreamWriter(listener, process.getOutputStream());
    }


}
