/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doublependulum;

import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author Kyungbin
 */
public class OpeningScreen extends javax.swing.JFrame {

    /**
     * Creates new form OpeningScreen
     */
    public OpeningScreen() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        getStarted = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        getStarted.setBackground(new java.awt.Color(153, 153, 255));
        getStarted.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        getStarted.setForeground(new java.awt.Color(255, 255, 255));
        getStarted.setText("Let's Get Started! ");
        getStarted.setBorder(null);
        getStarted.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getStartedMouseClicked(evt);
            }
        });
        getStarted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getStartedActionPerformed(evt);
            }
        });
        getContentPane().add(getStarted, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 360, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kyungbin\\Downloads\\GraphicDesign.png")); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void getStartedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getStartedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_getStartedActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        
    }//GEN-LAST:event_jLabel1MouseClicked

    private void getStartedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_getStartedMouseClicked
        //WHEN THE CREATE BUTTON IS CLICKED 
        //TI DISPOSES THE OPENING SCREEN
        dispose();
        //THE SELECTION MENU POPS UP 
        new Selection().setVisible(true);
        
    }//GEN-LAST:event_getStartedMouseClicked

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
            java.util.logging.Logger.getLogger(OpeningScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OpeningScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OpeningScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OpeningScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OpeningScreen().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton getStarted;
    public javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
