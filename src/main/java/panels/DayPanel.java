package panels;

import consoles.ConsolePane;

import javax.swing.*;


public class DayPanel {

    protected int userInputStart = 0;
    protected JTextArea textArea = new JTextArea(30, 30);
    protected ConsolePane cp;
    protected String startGame = "Game or Exit";
    //protected Command cmd = new Command(cp, startGame);

    public DayPanel() {}

//        setLayout(new BorderLayout());
//        ((AbstractDocument) textArea.getDocument()).setDocumentFilter(
//                new ProtectedDocumentFilter(this, this));
//        add(new JScrollPane(textArea));
//
//        InputMap im = textArea.getInputMap(WHEN_FOCUSED);
//        ActionMap am = textArea.getActionMap();
//
//        Action oldAction = am.get("insert-break");
//        am.put("insert-break", new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int range = textArea.getCaretPosition() - userInputStart;
//                try {
//                    String text = textArea.getText(userInputStart, range).trim();
//                    System.out.println("[" + text + "]");
//                    userInputStart += range;
//                    if (!cmd.isRunning()) {
//                        cmd.execute(text);
//                    } else {
//                        try {
//                            cmd.send(text + "\n");
//                        } catch (IOException ex) {
//                            appendText("!! Failed to send command to process: " + ex.getMessage() + "\n");
//                        }
//                    }
//                } catch (BadLocationException ex) {
//                    Logger.getLogger(ConsoleExample.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                oldAction.actionPerformed(e);
//            }
//        });
//        setTheme();
//    }
//
//    public void start() {
//        System.out.println("Press Day to Continue.");
//    }
//
//    protected void setTheme(){
//        try {
//            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (Exception e) {
//            System.out.println("Nimbus theme is not found.");
//            e.printStackTrace();
//        }
//    }

}
