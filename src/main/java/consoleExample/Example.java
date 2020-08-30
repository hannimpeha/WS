package consoleExample;

import javax.swing.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Example extends JFrame {

        /** Creates new form StdOutErr */
        public Example() {
            initComponents();
            PrintOutErrStream poes = new PrintOutErrStream(this.jTextAreaOutErrLog);
            System.setErr(new PrintStream(poes, true));
            System.setOut(new PrintStream(poes, true));
        }

        /** This method is called from within the constructor to
         * initialize the form.
         * WARNING: Do NOT modify this code. The content of this
         * method is
         * always regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
// <editor-fold defaultstate="collapsed" desc="Generated Code">
        private void initComponents() {
            java.awt.GridBagConstraints gridBagConstraints;

            jButtonStdout = new javax.swing.JButton();
            jButtonStderr = new javax.swing.JButton();
            jPanelOutErrLog = new javax.swing.JPanel();
            jScrollPaneOutErrLog = new javax.swing.JScrollPane();
            jTextAreaOutErrLog = new javax.swing.JTextArea();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            getContentPane().setLayout(new java.awt.FlowLayout());

            jButtonStdout.setText("stdout");
            jButtonStdout.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButtonStdoutActionPerformed(evt);
                }
            });
            getContentPane().add(jButtonStdout);

            jButtonStderr.setText("stderr");
            jButtonStderr.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButtonStderrActionPerformed(evt);
                }
            });
            getContentPane().add(jButtonStderr);

            jTextAreaOutErrLog.setColumns(20);
            jTextAreaOutErrLog.setRows(5);
            jScrollPaneOutErrLog.setViewportView(jTextAreaOutErrLog);

            javax.swing.GroupLayout jPanelOutErrLogLayout = new javax.swing.GroupLayout(jPanelOutErrLog);
            jPanelOutErrLog.setLayout(jPanelOutErrLogLayout);
            jPanelOutErrLogLayout.setHorizontalGroup(
                    jPanelOutErrLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGap(0, 835, Short.MAX_VALUE)
                            .addGroup(jPanelOutErrLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPaneOutErrLog, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE))
            );
            jPanelOutErrLogLayout.setVerticalGroup(
                    jPanelOutErrLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGap(0, 378, Short.MAX_VALUE)
                            .addGroup(jPanelOutErrLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPaneOutErrLog, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE))
            );

            getContentPane().add(jPanelOutErrLog);

            pack();
        }// </editor-fold>

        private void jButtonStdoutActionPerformed(java.awt.event.ActionEvent evt) {
            System.out.println("message via stdout");
        }

        private void jButtonStderrActionPerformed(java.awt.event.ActionEvent evt) {
            System.err.println("message via stderr");
        }

        /**
         * @param args the command line arguments
         */
        public static void main(String args[]) {
            /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
             * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
             */
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(Example.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(Example.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(Example.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(Example.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new Example().setVisible(true);
                }
            });
        }
        // Variables declaration - do not modify
        private javax.swing.JButton jButtonStderr;
        private javax.swing.JButton jButtonStdout;
        private javax.swing.JPanel jPanelOutErrLog;
        private javax.swing.JScrollPane jScrollPaneOutErrLog;
        private javax.swing.JTextArea jTextAreaOutErrLog;
// End of variables declaration
}

class PrintOutErrStream extends ByteArrayOutputStream {

    final int maxTextAreaSize = 1000;
    private JTextArea textArea;
    public PrintOutErrStream(JTextArea textArea) {
        this.textArea = textArea;
    }

    public void flush() throws IOException {
        synchronized(this) {
            super.flush();
            String outputStr = this.toString();
            super.reset();
            if(textArea.getText().length() > maxTextAreaSize) {
                textArea.replaceRange("", 0, 100);
            }
            textArea.append(outputStr);
        }
    }
}