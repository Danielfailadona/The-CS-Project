/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backup;

import Config.dbConnect;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DANIEL FAILADONA
 */
public class CDS5 {
//    public void displayData() {
//        try {
//            dbConnect dbc = new dbConnect();
//
//            // First, check the 'deleted' status for c_id 1, 2, and 3
//            String deletedCheckQuery = "SELECT deleted FROM client_partition WHERE c_id IN (1, 2, 3)";
//            ResultSet checkRs = dbc.getData(deletedCheckQuery);
//
//            boolean isDeletedYes = false;
//
//            // Check if any of c_id 1, 2, or 3 have "Yes" in the 'deleted' column
//            while (checkRs.next()) {
//                String deletedStatus = checkRs.getString("deleted");
//                if ("Yes".equalsIgnoreCase(deletedStatus)) {
//                    isDeletedYes = true;
//                    break;  // If any c_id has deleted = 'Yes', stop checking further
//                }
//            }
//
//            checkRs.close(); // Close the check query result set
//
//            // Now, based on the 'deleted' status, decide which query to execute
//            String finalQuery;
//            if (isDeletedYes) {
//                // If any c_id 1, 2, or 3 has "Yes" for deleted, only show c_id 4
//                finalQuery = "SELECT Name, Total_Size, Free_Space, Type FROM client_partition WHERE c_id = 4";
//            } else {
//                // If no c_id 1, 2, or 3 is deleted, show all but c_id 4
//                finalQuery = "SELECT Name, Total_Size, Free_Space, Type FROM client_partition WHERE c_id NOT IN (4)";
//            }
//
//            // Execute the final query based on the condition
//            ResultSet rs = dbc.getData(finalQuery);
//            DefaultTableModel model = new DefaultTableModel();
//            model.addColumn("Name");
//            model.addColumn("Total Size");
//            model.addColumn("Free Space");
//            model.addColumn("Type");
//
//            // Process the results and fill the table model
//            while (rs.next()) {
//                String name = rs.getString("Name");
//                String totalSize = rs.getString("Total_Size");
//                String freeSpace = rs.getString("Free_Space");
//                String type = rs.getString("Type");
//
//                // Add row to model
//                model.addRow(new Object[]{name, totalSize, freeSpace, type});
//            }
//
//            // Bind the model to the table
//            tbl1.setModel(model);
//
//            // Adjust column widths
//            tbl1.getColumnModel().getColumn(0).setPreferredWidth(200); // Increase the width of 'Name' column
//            tbl1.getColumnModel().getColumn(1).setPreferredWidth(100); // Adjust width of 'Total Size' column
//            tbl1.getColumnModel().getColumn(2).setPreferredWidth(100); // Adjust width of 'Free Space' column
//            tbl1.getColumnModel().getColumn(3).setPreferredWidth(100); // Adjust width of 'Type' column
//
//            rs.close();  // Close the result set
//        } catch (SQLException ex) {
//            System.out.println("💥 A dark SQL force struck: " + ex.getMessage());
//        }
//    }
//
//// Helper method to check if the 'Name' is already in the table model
//    private boolean isNewName(DefaultTableModel model, String name) {
//        for (int i = 0; i < model.getRowCount(); i++) {
//            if (model.getValueAt(i, 0).equals(name)) {
//                return false; // Name already exists
//            }
//        }
//        return true; // New name, add it
//    }
//
//// Helper method to pad the string to a specific length
//    private String padString(String value, int length) {
//        if (value.length() < length) {
//            StringBuilder sb = new StringBuilder(value);
//            while (sb.length() < length) {
//                sb.append(" ");  // Add spaces to pad the string
//            }
//            return sb.toString();
//        }
//        return value; // Return the string as-is if it's already long enough
//    }
//
////    dbConnect dbc = new dbConnect();
////    ResultSet rs1;
////
////    
////        try{
////            if (ResultSet 
////            rs1 = dbc.getData("SELECT * FROM client_partition WHERE c_id IN (1, 2, 3) WHERE deleted = 'Yes' ")
////        
////            )
////            {
////                System.out.println("all is delted");
////        }else
////            {
////                // 🛡️ Cast a barrier to exclude c_id 4
////            ResultSet rs = dbc.getData("SELECT Name, Total_Size, Free_Space, Type FROM client_partition WHERE c_id NOT IN (4)");
////            tbl1.setModel(DbUtils.resultSetToTableModel(rs));
////            rs.close();
////            }
////    }
////    catch (SQLException ex
////
////    
////        ) {
////            System.out.println("Errors: " + ex.getMessage());
////    }
////}
////
//////        try {
//////            
//////        } catch (SQLException ex) {
//////            System.out.println("Errors: " + ex.getMessage());
//////        }
}
