package controllers;


import javax.swing.*;

public class PlayerNames extends ConsolePane {

    protected JTextArea textAreaOrder;
    protected static JPanel contentPane = new JPanel();
    protected static JPanel north = new JPanel();
    protected static JPanel south = new JPanel();

    public PlayerNames(String panelName) {
        north = new JPanel();
        textAreaOrder = new JTextArea(20, 30);
        createPanel(panelName);
    }

    public void createPanel(String panelName) {
        textAreaOrder.setText("Type Players's Names");
        textAreaOrder.setEditable(false);
        north.add(new JLabel(panelName));
        north.add(new JScrollPane(textAreaOrder));
    }
}
