package state;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class CardLayoutFocus extends JPanel {
    private static final int PREF_W = 300;
    private static final int PREF_H = 150;
    private static final int COUNT = 4;
    private CardLayout cardlayout = new CardLayout();
    private JPanel cardHolder = new JPanel(cardlayout );

    public CardLayoutFocus() {
        setLayout(new BorderLayout());
        add(cardHolder, BorderLayout.CENTER);
        for (int i = 0; i < COUNT; i++) {
            String labelString = "Card " + i;
            cardHolder.add(createCardLabel(labelString), labelString);
        }

        int timerDelay = 1000;
        new Timer(timerDelay , new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                cardlayout.next(cardHolder);
            }
        }).start();
    }

    private JLabel createCardLabel(String labelString) {
        final JLabel label = new JLabel(labelString, SwingConstants.CENTER);
        label.setName(labelString);
        label.setOpaque(true);
        label.setFocusable(true);
        label.addFocusListener(new FocusListener() {

            @Override
            public void focusLost(FocusEvent arg0) {
                label.setBackground(null);
            }

            @Override
            public void focusGained(FocusEvent arg0) {
                label.setBackground(Color.pink);
            }
        });
        label.addComponentListener(new ComponentAdapter() {

            @Override
            public void componentShown(ComponentEvent cEvt) {
                Component src = (Component) cEvt.getSource();
                src.requestFocusInWindow();
            }

        });
        return label;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(PREF_W, PREF_H);
    }

    private static void createAndShowGui() {
        CardLayoutFocus mainPanel = new CardLayoutFocus();

        JFrame frame = new JFrame("Pink if has the focus");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}
