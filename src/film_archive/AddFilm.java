/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package film_archive;

import java.io.File;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author suleyman
 */
public class AddFilm extends javax.swing.JFrame {

    /**
     * Creates new form AddFilm
     */
    String file_path;
    String cover_path;
    Integer year;
    Integer time;
    public AddFilm() {
        initComponents();
        lblRate.setText(sldRate.getValue() + "/5");
        txtDescription.setLineWrap(true);
        txtDescription.setWrapStyleWord(true);
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
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jLabel1 = new javax.swing.JLabel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDirector = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtStars = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtWriters = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        comboGenre = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtYear = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtLong = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        sldRate = new javax.swing.JSlider();
        lblRate = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        lblFile = new javax.swing.JLabel();
        lblCover = new javax.swing.JLabel();
        btnCover = new javax.swing.JButton();
        btnFile = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jLabel11 = new javax.swing.JLabel();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        jPanel10 = new javax.swing.JPanel();
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        btnCancel = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Add New Film Data");

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));
        jPanel1.add(filler1);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        jLabel1.setText("Add New Film Data");
        jPanel1.add(jLabel1);
        jPanel1.add(filler2);

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel3.setText("Name: ");
        jPanel3.add(jLabel3);

        txtName.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jPanel3.add(txtName);

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel4.setText("Director: ");
        jPanel3.add(jLabel4);

        txtDirector.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jPanel3.add(txtDirector);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel5.setText("Stars: ");
        jPanel2.add(jLabel5);

        txtStars.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jPanel2.add(txtStars);

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel6.setText("Writers: ");
        jPanel2.add(jLabel6);

        txtWriters.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jPanel2.add(txtWriters);

        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));
        jPanel4.add(filler3);

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        jLabel2.setText("*Separate with comma for multiple options ");
        jPanel4.add(jLabel2);

        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel7.setText("Genre: ");
        jPanel5.add(jLabel7);

        comboGenre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Action", "Adventure", "Comedy", "Crime & Gangster", "Drama", "Epics & Historical", "Fantastic", "Horror", "Musicals & Dance", "Science Fiction", "War", "Westerns" }));
        jPanel5.add(comboGenre);

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel8.setText("Year: ");
        jPanel5.add(jLabel8);

        txtYear.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jPanel5.add(txtYear);

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel9.setText("Long: ");
        jPanel5.add(jLabel9);

        txtLong.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jPanel5.add(txtLong);

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel10.setText("Rate: ");
        jPanel5.add(jLabel10);

        sldRate.setMajorTickSpacing(5);
        sldRate.setMaximum(5);
        sldRate.setPaintLabels(true);
        sldRate.setPaintTicks(true);
        sldRate.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldRateStateChanged(evt);
            }
        });
        jPanel5.add(sldRate);

        lblRate.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        lblRate.setText("2.5/5");
        jPanel5.add(lblRate);

        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.LINE_AXIS));

        jPanel8.setLayout(new java.awt.BorderLayout());

        lblFile.setFont(new java.awt.Font("Helvetica", 0, 16)); // NOI18N
        lblFile.setText("File: unchosen");
        jPanel8.add(lblFile, java.awt.BorderLayout.CENTER);

        lblCover.setFont(new java.awt.Font("Helvetica", 0, 16)); // NOI18N
        lblCover.setText("Cover Picture: unchosen");
        jPanel8.add(lblCover, java.awt.BorderLayout.PAGE_START);

        jPanel7.add(jPanel8);

        btnCover.setText("Add Cover Picture");
        btnCover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCoverActionPerformed(evt);
            }
        });
        jPanel7.add(btnCover);

        btnFile.setText("Add File Url");
        btnFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFileActionPerformed(evt);
            }
        });
        jPanel7.add(btnFile);

        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.LINE_AXIS));
        jPanel9.add(filler4);

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel11.setText("Description");
        jPanel9.add(jLabel11);
        jPanel9.add(filler5);

        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.LINE_AXIS));

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane1.setViewportView(txtDescription);

        jPanel6.add(jScrollPane1);

        jPanel10.setLayout(new javax.swing.BoxLayout(jPanel10, javax.swing.BoxLayout.LINE_AXIS));
        jPanel10.add(filler6);

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel10.add(btnCancel);

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel10.add(btnSave);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 987, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFileActionPerformed
        JFileChooser fc = new JFileChooser();
        try {
            fc.setCurrentDirectory(new File(AddFilm.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()));
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(this,ex.getMessage());
        }
        int response = fc.showOpenDialog(this);
        if (response == JFileChooser.APPROVE_OPTION){
            file_path = fc.getSelectedFile().getAbsolutePath();
            lblFile.setText("Selected File: " + fc.getSelectedFile().getName());
        }
    }//GEN-LAST:event_btnFileActionPerformed

    private void btnCoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCoverActionPerformed
        JFileChooser fc = new JFileChooser();
        try {
            fc.setCurrentDirectory(new File(AddFilm.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()));
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(this,ex.getMessage());
        }
        int response = fc.showOpenDialog(this);
        if (response == JFileChooser.APPROVE_OPTION){
            cover_path = fc.getSelectedFile().getAbsolutePath();
            lblCover.setText("Selected Cover Picture: "+fc.getSelectedFile().getName());
        }
    }//GEN-LAST:event_btnCoverActionPerformed

    private void sldRateStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldRateStateChanged
        Integer value = sldRate.getValue();
        lblRate.setText(value + "/5");
    }//GEN-LAST:event_sldRateStateChanged

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String name = txtName.getText();
        String director = txtDirector.getText();
        String writers = txtWriters.getText();
        String stars = txtStars.getText();
        String genre = comboGenre.getSelectedItem().toString();
        String descrption = txtDescription.getText();
        Integer rate = sldRate.getValue();
        try{
            year = Integer.parseInt(txtYear.getText());
            time = Integer.parseInt(txtLong.getText());
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this,"Year and long fields must be a number!");
        }
        if(name.trim().equals("")){
            JOptionPane.showMessageDialog(this,"Name field can not be empty");
        }else{
            String sql = "INSERT INTO films(name,description,director,cast,writers,year,picture,genre,rate,time,file) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            try {
                Database db = new Database();
                Connection con = db.connect();
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setString(1, name);
                pstmt.setString(2, descrption);
                pstmt.setString(3, director);
                pstmt.setString(4, stars);
                pstmt.setString(5, writers);
                pstmt.setInt(6, year);
                pstmt.setString(7, cover_path);
                pstmt.setString(8, genre);
                pstmt.setInt(9, rate);
                pstmt.setInt(10, time);
                pstmt.setString(11, file_path);
                pstmt.executeUpdate();
                this.setVisible(false);
                this.dispose();
                JOptionPane.showMessageDialog(this,"Successfully Saved");
               
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this,ex.getMessage());
                Logger.getLogger(AddFilm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(AddFilm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

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
            java.util.logging.Logger.getLogger(AddFilm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddFilm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddFilm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddFilm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddFilm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCover;
    private javax.swing.JButton btnFile;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> comboGenre;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCover;
    private javax.swing.JLabel lblFile;
    private javax.swing.JLabel lblRate;
    private javax.swing.JSlider sldRate;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtDirector;
    private javax.swing.JTextField txtLong;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtStars;
    private javax.swing.JTextField txtWriters;
    private javax.swing.JTextField txtYear;
    // End of variables declaration//GEN-END:variables
}