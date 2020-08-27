package consoles;

public class AppendTask implements Runnable {

    private Terminal terminal;
    private String text;
    private String order;

        public AppendTask(Terminal textArea, String text, String order) {
            this.terminal = textArea;
            this.text = text;
            this.order = order;
    }

    @Override
    public void run() {
            terminal.appendOrder(order);
            terminal.appendText(text);
    }
}
