/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Student;

import hustleruniversity.Login;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import user_class.Student;

/**
 *
 * @author zrche
 */
public class ViewAssessment extends javax.swing.JFrame {

    /**
     * Creates new form ViewAssessment
     */
    
    private static Report report;
    private static String action;
    private static String filepath;
    private static Student student;
    
    public ViewAssessment() {
        initComponents();
        ShowUserIdLbl.setText(Login.getId());
        addInfoIntoTable();
    }

    public void addInfoIntoTable(){
        DefaultTableModel model = (DefaultTableModel) AssessmentTable.getModel();
        
        // fetch student information from the student id and create a student object
        String assessmentType = null;
        String supervisor = null;
        String dueDate = null;
        String status = null;
        String secondMarker = null;
        
        try (BufferedReader reader = new BufferedReader(new FileReader("src\\textfile\\student.txt"))) {
            String line;
            
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if(fields[0].equals(ShowUserIdLbl.getText())){
                    //save the details of the student who are using this system right now
                    ViewAssessment.student = new Student(fields[0],fields[1],"student",fields[2],fields[3],fields[4],fields[5]);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Opps, error happen! ");
        }
        
        // fetch information from assessment.txt
        try (BufferedReader reader = new BufferedReader(new FileReader("src\\textfile\\Assessment.txt"))) {
            String assessmentLine;
            
            while ((assessmentLine = reader.readLine()) != null) {
                boolean found = false;
                String[] assessmentFields = assessmentLine.split(",");
                if (ViewAssessment.student.getIntakeCode().equals("NONE(INDIVIDUAL)")) {
                    if (assessmentFields[1].equals(ViewAssessment.student.getId())) {
                        assessmentType = assessmentFields[2];
                        supervisor = assessmentFields[3];
                        secondMarker = assessmentFields[4];
                        dueDate = assessmentFields[5];
                        found = true;
                    }
                } else {
                    if (ViewAssessment.student.getIntakeCode().equals(assessmentFields[0])) {
                        assessmentType = assessmentFields[2];
                        supervisor = assessmentFields[3];
                        secondMarker = assessmentFields[4];
                        dueDate = assessmentFields[5];
                        found = true;
                    }
                }

                // fetch information from reports.txt by comparing with assessment and student details
                try (BufferedReader readers = new BufferedReader(new FileReader("src\\textfile\\report.txt"))) {
                    String reportLine;
                    while ((reportLine = readers.readLine()) != null) {
                        status = "not submitted";
                        String[] reportFields = reportLine.split(",");
                        
                        //find out whether there's a report submission of the student for the specific assessment
                        if (reportFields[0].equals(ViewAssessment.student.getIntakeCode()) && reportFields[1].equals(ViewAssessment.student.getId()) && reportFields[2].equals(assessmentType)) {
                            status = "submitted";
                            // save the submission file path for the report of the student
                            ViewAssessment.filepath = reportFields[3];
                            if (!reportFields[6].equals("none")) {
                                status = "graded";
                            }
                            break; // break the while loop after found the report submission
                        }
                    }
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Opps, error happen! ");
                }
                if(found){
                    model.addRow(new Object[]{assessmentType, supervisor,secondMarker, dueDate, status});
                }
            
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Opps, error happen! ");
        }
    }
    
    public static Student getStudent(){
        return ViewAssessment.student;
    }
    
    public static Report getReport(){
        return ViewAssessment.report;
    }
    
    public static String getFilePath(){
        return ViewAssessment.filepath;
    }
    
    public static String getAction(){
        return ViewAssessment.action;
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
        ShowUserIdLbl = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AssessmentTable = new javax.swing.JTable();
        HomeBttn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        SubmitBttn = new javax.swing.JButton();
        EditBttn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ShowUserIdLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ShowUserIdLbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Assessment Alloted", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        AssessmentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Assessment Type", "Supervisor", "Second Marker", "Due Date", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(AssessmentTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        HomeBttn.setText("Home");
        HomeBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeBttnActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Functionality", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        SubmitBttn.setText("Submit Report");
        SubmitBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitBttnActionPerformed(evt);
            }
        });

        EditBttn.setText("Edit Submission");
        EditBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditBttnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(EditBttn, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                    .addComponent(SubmitBttn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(SubmitBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102)
                .addComponent(EditBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(HomeBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)))
                .addGap(35, 35, 35))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(ShowUserIdLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 92, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ShowUserIdLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(31, 31, 31)
                .addComponent(HomeBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SubmitBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitBttnActionPerformed
        int selectedRow = AssessmentTable.getSelectedRow();

        if (selectedRow != -1) { // -1 indicates no row is selected
            // Get data from the selected row
            Object[] rowData = new Object[AssessmentTable.getColumnCount()];
            for (int i = 0; i < AssessmentTable.getColumnCount(); i++) {
                rowData[i] = AssessmentTable.getValueAt(selectedRow, i);
            }
            // only allow the student to submit the assessment that are havent been submitted
            if(rowData[4].equals("not submitted")){ 
                ViewAssessment.report = new Report(ViewAssessment.student.getIntakeCode(),rowData[0].toString(),rowData[1].toString(),rowData[2].toString());
                ViewAssessment.action = "submit";
                this.dispose();
                new ReportsSubmission().setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null,"You have already submitted the project for this assessment. ");
            }
        }else {
                JOptionPane.showMessageDialog(null,"You should select a row. ");
            }
                
    }//GEN-LAST:event_SubmitBttnActionPerformed

    private void EditBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditBttnActionPerformed
        int selectedRow = AssessmentTable.getSelectedRow();

        if (selectedRow != -1) { // -1 indicates no row is selected
            // Get data from the selected row
            Object[] rowData = new Object[AssessmentTable.getColumnCount()];
            for (int i = 0; i < AssessmentTable.getColumnCount(); i++) {
                rowData[i] = AssessmentTable.getValueAt(selectedRow, i);
            }
            
            // only allow the user to edit the submission only the status is submitted
            if(rowData[4].equals("submitted")){
                ViewAssessment.report = new Report(ViewAssessment.student.getIntakeCode(),rowData[0].toString(),rowData[1].toString(),rowData[2].toString(),ViewAssessment.getFilePath());
                ViewAssessment.action = "edit";
                this.dispose();
                new ReportsSubmission().setVisible(true);
            }else if(rowData[4].equals("graded") || rowData[4].equals("not submitted")){
                JOptionPane.showMessageDialog(null,"You cannot edit the submmission project for this assessment. ");
            }
        }else {
                JOptionPane.showMessageDialog(null,"You should select a row. ");
            }
    }//GEN-LAST:event_EditBttnActionPerformed

    private void HomeBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeBttnActionPerformed
        this.dispose();
        new Student_HomePage().setVisible(true);
    }//GEN-LAST:event_HomeBttnActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAssessment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ViewAssessment().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable AssessmentTable;
    private javax.swing.JButton EditBttn;
    private javax.swing.JButton HomeBttn;
    private javax.swing.JLabel ShowUserIdLbl;
    private javax.swing.JButton SubmitBttn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
