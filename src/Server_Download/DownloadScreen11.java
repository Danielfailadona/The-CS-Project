/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server_Download;

import Client_Download.ClientDownloadScreen;
import static Server_Download.DownloadScreen8.use;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class DownloadScreen11 extends javax.swing.JFrame {
    
    private Image originalImage;
    private Color H;
    Color h = new Color(51, 51, 255);
    private Color D;
    Color d = new Color(255, 255, 255);

    public DownloadScreen11() {
        initComponents(); // I summon thee
        this.setResizable(false); // Lock diminutive Form

        // I cast a protective barrier against the vanished
        if (image1.getIcon() != null && image1.getIcon() instanceof ImageIcon) {
            originalImage = ((ImageIcon) image1.getIcon()).getImage();
        } else {
            System.out.println("⚠️ Warning: image1 icon is null or not an ImageIcon!");
        }

        // I cast binding body morph when one is not vanished
        if (originalImage != null) {
            image1.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    int labelWidth = image1.getWidth();
                    int labelHeight = image1.getHeight();

                    if (labelWidth > 0 && labelHeight > 0) {
                        int newHeight = getHeightFromWidth(originalImage, labelWidth);
                        Image scaledImage = originalImage.getScaledInstance(labelWidth, newHeight, Image.SCALE_SMOOTH);
                        image1.setIcon(new ImageIcon(scaledImage));
                        image1.repaint();
                    }
                }
            });

            // Now resize my creation!
            int initialWidth = image1.getWidth();
            int initialHeight = image1.getHeight();
            if (initialWidth > 0 && initialHeight > 0) {
                int newHeight = getHeightFromWidth(originalImage, initialWidth);
                Image scaledImage = originalImage.getScaledInstance(initialWidth, newHeight, Image.SCALE_SMOOTH);
                image1.setIcon(new ImageIcon(scaledImage));
                image1.repaint();
            }
        }
    }

    private int getHeightFromWidth(Image image, int desiredWidth) {
        int originalWidth = image.getWidth(null);
        int originalHeight = image.getHeight(null);

        // Debugging: Check original image dimensions
//        System.out.println("Original Image Dimensions: Width = " + originalWidth + " Height = " + originalHeight);

        return (int) (((double) desiredWidth / originalWidth) * originalHeight);
    }













   
   
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        image1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1170, 640));
        jPanel1.setPreferredSize(new java.awt.Dimension(1170, 640));
        jPanel1.setLayout(null);

        image1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/s10.png"))); // NOI18N
        jPanel1.add(image1);
        image1.setBounds(0, 0, 1170, 640);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1170, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        use.delay(5, () -> {
            JOptionPane.showMessageDialog(null, "This is client installation");
            ClientDownloadScreen cds = new ClientDownloadScreen();
            cds.setVisible(true);
            this.dispose();
        });
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(DownloadScreen11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DownloadScreen11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DownloadScreen11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DownloadScreen11.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DownloadScreen11().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel image1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
