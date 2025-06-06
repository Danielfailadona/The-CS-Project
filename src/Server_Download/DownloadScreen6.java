/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server_Download;

import Client_Download.*;
import Config.Session;
import Config.dbConnect;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author DANIEL FAILADONA
 */


public class DownloadScreen6 extends javax.swing.JFrame {

    private Image originalImage;
    private Color H;
    Color h = new Color(51, 51, 255);
    private Color D;
    Color d = new Color(255, 255, 255);
    
    List<Integer> rowCIDs = new ArrayList<>();
    public DownloadScreen6() {
        initComponents(); // I summon thee
        this.setResizable(false); // Lock diminutive Form
//        displayData();
        NotShowDeletedUsers();


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
    
    
    
    
    
    
    
    
    public void deleteUser() {
        int selectedRow = tbl1.getSelectedRow();
        int cid = rowCIDs.get(selectedRow);
//        System.out.println("🧙‍♂️ Attempting to delete selected row: " + selectedRow);
//        System.out.println("📌 rowCIDs size: " + rowCIDs.size());

        if (selectedRow < 0 || selectedRow >= rowCIDs.size()) {
//            System.out.println("⚠️ No valid row selected for deletion.");
            JOptionPane.showMessageDialog(this, "Please select a valid partition to delete.");
            return;
        }else if(cid == 5)
        {
            JOptionPane.showMessageDialog(this, "You cannot delete this");
        }else
        {
//            int cid = rowCIDs.get(selectedRow);
    //        System.out.println("🗑️ Deleting user with c_id: " + cid);

            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cs_s", "root", "");
                    PreparedStatement pst = con.prepareStatement("UPDATE client_partition SET Deleted = 'Yes' WHERE c_id = ?")) {

                pst.setInt(1, cid);
                int affected = pst.executeUpdate();

                if (affected > 0) {
    //                System.out.println("✅ Partition deleted.");
                    NotShowDeletedUsers(); // Reload data with updated visibility
                } else {
    //                System.out.println("❌ Deletion failed. No rows affected.");
                }

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "💥 Error deleting user: " + e.getMessage());
            }
        }
    }





    
    
    
    
    
    
    public void loadUsersData() {
        DefaultTableModel model = (DefaultTableModel) tbl1.getModel();
        model.setRowCount(0); // Clear existing rows
        rowCIDs.clear();      // Clear old c_ids

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cs_s", "root", "");
                Statement stmt = con.createStatement()) {

            // Check Deleted status of c_id 1-3
            ResultSet rsCheck = stmt.executeQuery("SELECT COUNT(*) AS count FROM client_partition WHERE c_id IN (1,2,3,4) AND Deleted = 'No'");
            rsCheck.next();
            int activeCount = rsCheck.getInt("count");
//            System.out.println("🔍 Checking deletion status of c_id 1, 2, and 3...");
//            System.out.println("🧮 Number of non-deleted among 1, 2, 3: " + activeCount);

            String query;
            if (activeCount == 0) {
//                System.out.println("✅ All required partitions deleted. Revealing c_id 4.");
                query = "SELECT * FROM client_partition WHERE Deleted = 'No'";
            } else {
//                System.out.println("⛔ Some of c_id 1,2,3 are still active. Hiding c_id 4.");
                query = "SELECT * FROM client_partition WHERE c_id != 5 AND Deleted = 'No'";
            }

            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int cid = rs.getInt("c_id");
                String name = rs.getString("Name");
                String totalSize = rs.getString("Total_size");
                String freeSpace = rs.getString("Free_Space");
                String type = rs.getString("Type");

                model.addRow(new Object[]{name, totalSize, freeSpace, type});
                rowCIDs.add(cid); // Map row to cid

//                System.out.println("📦 Loading: " + name + "  (c_id: " + cid + ")");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "💥 Error loading data: " + e.getMessage());
        }
    }

    
    
    
    
    
    
    public void NotShowDeletedUsers() {
        List<Object[]> rowData = new ArrayList<>();
        rowCIDs.clear(); // Clear the old mappings!

        try {
            dbConnect dbc = new dbConnect();

//            System.out.println("🔍 Checking deletion status of c_id 1, 2, and 3...");

            ResultSet checkRs = dbc.getData("SELECT COUNT(*) AS activeCount FROM client_partition WHERE c_id IN (1, 2, 3, 4) AND Deleted != 'Yes'");
            boolean allDeleted = true;

            if (checkRs.next()) {
                int activeCount = checkRs.getInt("activeCount");
//                System.out.println("🧮 Number of non-deleted among 1, 2, 3: " + activeCount);
                allDeleted = (activeCount == 0);
            }
            checkRs.close();

            String query;
            if (allDeleted) {
                query = "SELECT * FROM client_partition WHERE Deleted != 'Yes'";
//                System.out.println("✅ All c_id 1,2,3 are deleted. Revealing c_id 4.");
            } else {
                query = "SELECT * FROM client_partition WHERE c_id != 5 AND Deleted != 'Yes'";
//                System.out.println("⛔ Some of c_id 1,2,3 are still active. Hiding c_id 4.");
            }

            ResultSet rs = dbc.getData(query);

            while (rs.next()) {
                String name = rs.getString("Name");
                String totalSize = rs.getString("Total_size");
                String freeSpace = rs.getString("Free_Space");
                String type = rs.getString("Type");
                int cid = rs.getInt("c_id");

//                System.out.println("📦 Loading: " + name + " (c_id: " + cid + ")");
                rowData.add(new Object[]{name, totalSize, freeSpace, type});
                rowCIDs.add(cid); // 🔑 Map table row to its c_id
            }

            rs.close();

            SwingUtilities.invokeLater(() -> {
                DefaultTableModel model = new DefaultTableModel(
                        new String[]{"Name", "Total Size", "Free Space", "Type"}, 0
                );
                for (Object[] row : rowData) {
                    model.addRow(row);
                }

                tbl1.setModel(model);
                tbl1.getColumnModel().getColumn(0).setPreferredWidth(200);
                tbl1.getColumnModel().getColumn(1).setPreferredWidth(100);
                tbl1.getColumnModel().getColumn(2).setPreferredWidth(100);
                tbl1.getColumnModel().getColumn(3).setPreferredWidth(100);
                tbl1.repaint();
            });

        } catch (SQLException ex) {
//            System.out.println("🔥 An SQL error has been unleashed: " + ex.getMessage());
            ex.printStackTrace();
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl1 = new javax.swing.JTable();
        Button1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Button2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        image1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1170, 640));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(null);

        tbl1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbl1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(90, 150, 1010, 260);

        Button1.setBackground(new java.awt.Color(255, 255, 255));
        Button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Button1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Button1MouseExited(evt);
            }
        });
        Button1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Delete");
        Button1.add(jLabel1);
        jLabel1.setBounds(40, 0, 70, 40);

        jPanel1.add(Button1);
        Button1.setBounds(329, 412, 150, 44);

        Button2.setBackground(new java.awt.Color(255, 255, 255));
        Button2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Button2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Button2MouseExited(evt);
            }
        });
        Button2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Next");
        Button2.add(jLabel2);
        jLabel2.setBounds(40, 0, 50, 30);

        jPanel1.add(Button2);
        Button2.setBounds(997, 583, 133, 30);

        image1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client1/c6.png"))); // NOI18N
        jPanel1.add(image1);
        image1.setBounds(0, 0, 1170, 640);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1170, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button1MouseClicked
        deleteUser();
    }//GEN-LAST:event_Button1MouseClicked

    private void Button1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button1MouseEntered
        Button1.setBackground(h);
    }//GEN-LAST:event_Button1MouseEntered

    private void Button1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button1MouseExited
        Button1.setBackground(d);
    }//GEN-LAST:event_Button1MouseExited

    private void Button2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button2MouseClicked
        int rowIndex = tbl1.getSelectedRow();

        if (rowIndex < 0) {
            JOptionPane.showMessageDialog(null, "Please select an Item");
        } else {
            try {
                dbConnect dbc = new dbConnect();
                TableModel tbl = tbl1.getModel();
                String selectedName = tbl.getValueAt(rowIndex, 0).toString();

                ResultSet rs = dbc.getData("SELECT * FROM client_partition WHERE Name = '" + selectedName + "'");

                if (rs.next()) {
                    // 🧙‍♂️ The Restoration Spell
                    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cs_s", "root", "");
                            PreparedStatement pst = con.prepareStatement(
                                    "UPDATE client_partition SET Deleted = 'No' WHERE c_id IN (1, 2, 3, 4)"
                            )) {

                        int affected = pst.executeUpdate();
                        System.out.println("🔁 Resurrection complete. Partitions revived: " + affected);

                    } catch (SQLException e) {
                        System.err.println("💥 Failed to update c_id 1–4: " + e.getMessage());
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Failed to update partitions.");
                        return; // Exit before moving forward if error
                    }

                    // 🧭 The Portal Opens
                    DownloadScreen7 ds7 = new DownloadScreen7();
                    ds7.setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "No data found for selected item.");
                }

                rs.close();
            } catch (SQLException ex) {
                System.err.println("🔥 A database error has occurred: " + ex.getMessage());
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "An error occurred while loading data.");
            }
        }


    }//GEN-LAST:event_Button2MouseClicked

    private void Button2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button2MouseEntered
        Button2.setBackground(h);
    }//GEN-LAST:event_Button2MouseEntered

    private void Button2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button2MouseExited
        Button2.setBackground(d);
    }//GEN-LAST:event_Button2MouseExited

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
            java.util.logging.Logger.getLogger(DownloadScreen6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DownloadScreen6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DownloadScreen6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DownloadScreen6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DownloadScreen6().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Button1;
    private javax.swing.JPanel Button2;
    private javax.swing.JLabel image1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl1;
    // End of variables declaration//GEN-END:variables
}
