package swings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConsoleForProgram implements KeyListener, ActionListener {

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int screenWidth = screenSize.width;
    int screenHeight = screenSize.height;

    String title = null;
    String text = null;

    JFrame jf = null;
    JTextArea jta = null;
    JScrollPane jsp = null;
    JMenuBar jmb = null;
    JMenu jm = null;
    JMenuItem jmi = null;

    int initialCaretPosition = 0;
    int currentCaretPosition = 0;
    boolean inputAvailable = false;

    // key codes
    int BACKSPACE = 8;
    int ENTER = 10;
    int PG_UP = 33; // do nothing for this key pressed
    int PG_DN = 34; // do nothing for this key pressed
    int END = 35;
    int HOME = 36;
    int LEFT_ARROW = 37;
    int UP_ARROW = 38; // do nothing for this key pressed
    //int RIGHT_ARROW = 39; // handled by JTextArea
    int DOWN_ARROW = 40; // do nothing for this key pressed

    int CTRL = 128;
    int A = 65; // disable ctrl-a
    int H = 72; // handle ctrl-h
    //int DELETE = 127; // handled by JTextArea

    public void actionPerformed(ActionEvent ae) {
        int cCurrPos = jta.getCaretPosition();
        jta.selectAll();
        jta.copy();
        jta.select(cCurrPos, cCurrPos);
    } // end of actionPerformed

    public void keyTyped(KeyEvent ke) {
    } // end of keyTyped

    public void keyReleased(KeyEvent ke) {
    } // end of keyReleased

    public void keyPressed(KeyEvent ke) {
        int keyCode = ke.getKeyCode();
        if ((keyCode == PG_UP) || (keyCode == PG_DN) || (keyCode == UP_ARROW) || (keyCode == DOWN_ARROW) || ((keyCode == A) && (ke.getModifiersEx() == CTRL))) {
            ke.consume();
        } else if ((keyCode == LEFT_ARROW) || (keyCode == BACKSPACE) || ((keyCode == H) && (ke.getModifiersEx() == CTRL))) {
            synchronized (this) {
                if (jta.getCaretPosition() <= initialCaretPosition) {
                    ke.consume();
                }
            } // end of synchronized block
        } else if (keyCode == HOME) {
            synchronized (this) {
                jta.setCaretPosition(initialCaretPosition);
                ke.consume();
            } // end of synchronized block
        } else if (keyCode == END) {
            synchronized (this) {
                jta.setCaretPosition(jta.getDocument().getLength());
                ke.consume();
            } // end of synchronized block
        } else if (keyCode == ENTER) {
            jta.setCaretPosition(jta.getDocument().getLength());
            synchronized (this) {
                currentCaretPosition = jta.getCaretPosition();

                // If character at initial caret position is newline then it means that the user has
                // pressed enter without enetring any other character. Also, the code gets called here
                // as soon as enter is pressed which means that the caret position (jta.getCaretPosition())
                // of the document will be incremented by 1 by the system after this code returns.
                // This means that if at initial caret position, the character is newline, then we must ignore
                // this enter and increment initial caret position by 1 and do not set inputAvailable to true.
                try {
                    String charAtInitialCaretPosition = jta.getText(initialCaretPosition, 1);
                    if ((charAtInitialCaretPosition.equals("\n")) == true) {
                        initialCaretPosition++;
                    }
                } catch (Exception e) {
                }
                /*
                debug: start
                try {
                    System.out.println("keyPressed (1): initial = " + initialCaretPosition + ", current = " + currentCaretPosition + ", System current = " + jta.getDocument().getLength());
                    String initialString = jta.getText(initialCaretPosition, 1);
                    String currentString = jta.getText(currentCaretPosition, 1);
                    System.out.println("char at initial = " + initialString + ", char at current = " + currentString);
                    if ((initialString.equals("\n")) == true) {
                        System.out.println("char at initial is newline");
                    }
                    if ((currentString.equals("\n")) == true) {
                        System.out.println("char at current is newline");
                    }
                } catch (Exception e) {
                }
                debug:end
                */

                if ((currentCaretPosition - initialCaretPosition) > 0) {
                    inputAvailable = true;
                    notifyAll();
                }
            } // end of synchronized block
        } // end of if else if
    } // end of keyPressed

    String getInputFromJTextArea(JTextArea jta) {
        int len = 0;
        String inputFromUser = "";
        while (true) {
            synchronized (this) {
                if (inputAvailable == true) {
                    len = currentCaretPosition - initialCaretPosition;

                    try {
                        inputFromUser = jta.getText(initialCaretPosition, len);
                        initialCaretPosition = currentCaretPosition;
                    } catch (Exception e) {
                        inputFromUser = "";
                        return inputFromUser;
                    } // end of outer try catch

                    /*
                    The following lines of code are not needed now.
                    if ((len == 1) && (inputFromUser.equals("\n")) == true) {
                        try {
                            wait();
                            continue;
                        } catch (Exception e) {
                        } // end of try catch
                    } else if (Character.compare(inputFromUser.charAt(0), '\n') == 0) { // matched
                        // remove first character from inputFromUser
                        inputFromUser = inputFromUser.substring(1);
                    }
                    */
                    inputAvailable = false;
                    return inputFromUser;
                } else {
                    try {
                        wait();
                        continue;
                    } catch (Exception e) {
                    } // end of try catch
                } // end of if else inputAvailable
            } // end of synchronized block
        } // end of while true
    } // end of getInoutFromJtextArea

    void outputToJTextArea(JTextArea jta, String text) {
        jta.append(text);
        jta.setCaretPosition(jta.getDocument().getLength());
        synchronized (this) {
            initialCaretPosition = jta.getCaretPosition();
        }
    } // end of outputToJTextArea

    void begin() {
        while (true) {
            outputToJTextArea(jta, "Enter some input (press enter after inputting): ");
            String input = getInputFromJTextArea(jta);
            outputToJTextArea(jta, "User input was: " + input + "\n\n");
        }
    } // end of begin

    void configureJTextAreaForInputOutput(JTextArea jta) {
        jta.addKeyListener(this);

        // remove all mouse listeners
        for (MouseListener listener : jta.getMouseListeners()) {
            //outputToJTextArea(jta, "\nRemoving mouse listener\n");
            jta.removeMouseListener(listener);
        }

        // remove all mouse motion listeners
        for (MouseMotionListener listener : jta.getMouseMotionListeners()) {
            //outputToJTextArea(jta, "\nRemoving mouse motion listener\n");
            jta.removeMouseMotionListener(listener);
        }

        // remove all mouse wheel listeners
        for (MouseWheelListener listener : jta.getMouseWheelListeners()) {
            //outputToJTextArea(jta, "\nRemoving mouse wheel listener\n");
            jta.removeMouseWheelListener(listener);
        }
    } // end of configureJTextAreaForInputOutput

    void createAndShowGUI() {
        title = "Hannah Lee's Mafia Game";
        jf = InitComponents.setupJFrameAndGet(title, screenWidth - 150, screenHeight - 100);

        jta = InitComponents.setupJTextAreaAndGet("", 20, 30, true, true, true, false, 0, 0, 0, 0);
        configureJTextAreaForInputOutput(jta);

        jsp = InitComponents.setupScrollableJTextAreaAndGet(jta, 10, 10, screenWidth - 180, screenHeight - 180);
        jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jf.add(jsp);
        //jf.setLocation(screenWidth / 5, screenHeight / 6);

        jmb = InitComponents.setupJMenuBarAndGet();
        jm = InitComponents.setupJMenuAndGet("Hannah Lee");
        jm.setBorder(BorderFactory.createLineBorder(Color.green, 2));
        jmi = InitComponents.setupJMenuItemAndGet("Hannah Lee");
        jm.add(jmi);
        jmb.add(jm);
        jmi.addActionListener(this);
        jf.setJMenuBar(jmb);

        jf.setVisible(true);
    } // end of createAndShowGUI
}