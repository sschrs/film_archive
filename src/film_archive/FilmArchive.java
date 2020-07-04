/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package film_archive;


import java.awt.Image;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author suleyman
 */
public class FilmArchive extends javax.swing.JFrame {

    /**
     * Creates new form FilmArchive
     */
    Database db;
    public FilmArchive() throws Exception {
        initComponents();
        db = new Database();
        initFilmsTable();
        initSeriesTable();
        
    }
    
    public void initFilmsTable() throws SQLException, Exception{
        //filmModel = (DefaultTableModel) tblFilms.getModel();
        //seriesModel = (DefaultTableModel) tblSeries.getModel();
        String[] cols  = {"#","Cover","Name","Director","Stars","Year","Genre","Long","Rate"};
        DefaultTableModel model = new DefaultTableModel(cols, 0) {
         @Override
         public Class<?> getColumnClass(int column) {
            if (getRowCount() > 0) {
               Object value = getValueAt(0, column);
               if (value != null) {
                  return getValueAt(0, column).getClass();
               }
            }

            return super.getColumnClass(column);
         }
          @Override
            public boolean isCellEditable(int row, int column) {
            return false;
    }
      };

        ArrayList<Film> filmList = db.selectAllFilms("SELECT * FROM films");
        try{
            for (int i = 0 ; i<filmList.size();i++){
            Film f = filmList.get(i);
            ImageIcon icon = new ImageIcon(f.getPicture());
            Image image = icon.getImage(); // transform it 
            Image newimg = image.getScaledInstance(50, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
            icon = new ImageIcon(newimg);  // transform it back
            Integer index = i+1;
            Object[] row = {index.toString(),icon,f.getName(),f.getDirector(),f.getCast(),f.getYear().toString(),f.getGenre(),f.getTime().toString()+"min",f.getRate().toString()+"/5"};
            model.addRow(row);
        }
        tblFilms.setModel(model);
        tblFilms.setRowHeight(((ImageIcon)model.getValueAt(0, 1)).getIconHeight()); 
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        tblFilms.setDefaultRenderer(Object.class, centerRenderer);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        initStat();
    }
    
    public void initSeriesTable() throws Exception{
        try{
        String[] colseries  = {"#","Cover","Name","Director","Stars","Year","Genre","Season","Rate"};
        DefaultTableModel modelSeries = new DefaultTableModel(colseries, 0) {
         @Override
         public Class<?> getColumnClass(int column) {
            if (getRowCount() > 0) {
               Object value = getValueAt(0, column);
               if (value != null) {
                  return getValueAt(0, column).getClass();
               }
            }

            return super.getColumnClass(column);
         }
          @Override
            public boolean isCellEditable(int row, int column) {
               //all cells false
               return false;
    }
      };
        ArrayList<Series> seriesList = db.selectAllSeries();
        for (int i = 0 ; i<seriesList.size();i++){
            Series s = seriesList.get(i);
            ImageIcon icon = new ImageIcon(s.getPicture());
            Image image = icon.getImage(); // transform it 
            Image newimg = image.getScaledInstance(50, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
            icon = new ImageIcon(newimg);  // transform it back
            Integer index = i+1;
            Object[] row = {index.toString(),icon,s.getName(),s.getDirector(),s.getCast(),s.getYear().toString(),s.getGenre(),s.getSeason().toString()+" Season",s.getRate().toString()+"/5"};
            modelSeries.addRow(row);
        }
        tblSeries.setModel(modelSeries);
        tblSeries.setRowHeight(((ImageIcon)modelSeries.getValueAt(0, 1)).getIconHeight());
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        tblSeries.setDefaultRenderer(Object.class, centerRenderer);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        initStat();
    }
    
    public void initStat() throws Exception{
        Integer totalMovie = db.selectAllFilms("SELECT * FROM films").size();
        Integer totalSeries = db.selectAllSeries().size();
        Integer totalEpisodes = db.selectAllEpisodes().size();
        Integer totalTime = db.getTotalTime();
        stMovies.setText("Total Movies: "+totalMovie.toString());
        stSeries.setText("Total Series: "+totalSeries.toString());
        stEpisodes.setText("Total Episodes: "+totalEpisodes.toString());
        stTime.setText("Total Media Time: "+totalTime.toString());
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
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        btnAddFilm = new javax.swing.JButton();
        btnAddSeries = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        stMovies = new javax.swing.JLabel();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        stSeries = new javax.swing.JLabel();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        stEpisodes = new javax.swing.JLabel();
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        stTime = new javax.swing.JLabel();
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        tabPane = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFilms = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSeries = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));
        jPanel1.add(filler1);

        jLabel1.setFont(new java.awt.Font("Helvetica", 0, 66)); // NOI18N
        jLabel1.setText("Personal Movie Database");
        jPanel1.add(jLabel1);
        jPanel1.add(filler2);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        jPanel4.add(txtSearch);

        btnAddFilm.setText("Add New Film");
        btnAddFilm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFilmActionPerformed(evt);
            }
        });
        jPanel4.add(btnAddFilm);

        btnAddSeries.setText("Add New Series");
        btnAddSeries.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSeriesActionPerformed(evt);
            }
        });
        jPanel4.add(btnAddSeries);

        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.LINE_AXIS));
        jPanel6.add(filler3);

        stMovies.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        stMovies.setText("Total Movies:");
        jPanel6.add(stMovies);
        jPanel6.add(filler4);

        stSeries.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        stSeries.setText("Total Series:");
        jPanel6.add(stSeries);
        jPanel6.add(filler5);

        stEpisodes.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        stEpisodes.setText("Total Episodes:");
        jPanel6.add(stEpisodes);
        jPanel6.add(filler6);

        stTime.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        stTime.setText("Total Media Time:");
        jPanel6.add(stTime);
        jPanel6.add(filler7);

        tblFilms.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        tblFilms.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Cover", "Name", "Director", "Stars", "Year", "Genre", "Long", "Rate"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblFilms.getTableHeader().setReorderingAllowed(false);
        tblFilms.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFilmsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblFilms);

        tabPane.addTab("Films", jScrollPane1);

        tblSeries.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        tblSeries.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Cover", "Name", "Director", "Stars", "Year", "Genre", "Season", "Rate"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSeries.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSeriesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSeries);

        tabPane.addTab("Series", jScrollPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(tabPane, javax.swing.GroupLayout.PREFERRED_SIZE, 973, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(tabPane, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddSeriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSeriesActionPerformed
        AddSeries window = new AddSeries();
        window.setVisible(true);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
            if(window.isVisible()){
                System.out.print("");
                continue;
            }else{
                try {
                    initSeriesTable();
                    System.out.print("!");                    
                    break;
                } catch (Exception ex) {
                    Logger.getLogger(FilmArchive.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
            }
        });
        thread.start();
    }//GEN-LAST:event_btnAddSeriesActionPerformed

    private void btnAddFilmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFilmActionPerformed
        AddFilm window = new AddFilm();
        window.setVisible(true);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
            if(window.isVisible()){
                System.out.print(".");
                continue;
            }else{
                try {
                    initFilmsTable();
                    System.out.print("!");
                    break;
                } catch (Exception ex) {
                    Logger.getLogger(FilmArchive.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
            }
        });
        thread.start();
        
    }//GEN-LAST:event_btnAddFilmActionPerformed
    
    
    private void tblFilmsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFilmsMouseClicked
        if(evt.getClickCount() == 2 && tblFilms.getSelectedRow() != -1 ){
            ArrayList<Film> film = null;
            int row = tblFilms.getSelectedRow();
            String name = tblFilms.getValueAt(row, 2).toString();
            String director = tblFilms.getModel().getValueAt(row, 3).toString();
            try {
                film = db.selectFilm(name, director);
                if(film.size() == 0){
                    return;
                }
                Film f = film.get(0);
                FilmDetail window = new FilmDetail();
                window.init(f.getPicture(), f.getName(),f.getDescription(), f.getDirector(), f.getCast(), f.getWriters(), f.getYear(), f.getGenre(), f.getRate(), f.getTime(), f.getFile());
                window.setVisible(true);
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while(true){
                            if(window.isVisible()){
                                System.out.print(".");
                                continue; 
                            }else{
                                try {
                                    initFilmsTable();
                                } catch (Exception ex) {
                                    Logger.getLogger(FilmArchive.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                System.out.println("!");
                                break;
                            }
                        }
                    }
                });
                thread.start();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            
        }
    }//GEN-LAST:event_tblFilmsMouseClicked

    private void tblSeriesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSeriesMouseClicked
        if(evt.getClickCount() == 2 && tblSeries.getSelectedRow() != -1 ){
            ArrayList<Series> series = null;
            int row = tblSeries.getSelectedRow();
            String name = tblSeries.getValueAt(row, 2).toString();
            String director = tblSeries.getModel().getValueAt(row, 3).toString();
            try {
                series = db.selectSeries(name, director);
                if(series.isEmpty()){
                    return;
                }
                Series s = series.get(0);
                SeriesDetail window = new SeriesDetail();
                window.init(s);
                window.setExtendedState(JFrame.MAXIMIZED_BOTH);
                window.setVisible(true);
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while(true){
                            if(window.isVisible()){
                                System.out.println("Waiting");
                                continue;
                            }else{
                                System.out.println("!");
                                try {
                                    initSeriesTable();
                                } catch (Exception ex) {
                                    Logger.getLogger(FilmArchive.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                break;
                            }
                        }
                    }
                });
                thread.start();
            } catch (SQLException ex) {
                Logger.getLogger(FilmArchive.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(FilmArchive.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_tblSeriesMouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        TableRowSorter<DefaultTableModel> sorterFilms = new TableRowSorter<DefaultTableModel>((DefaultTableModel) tblFilms.getModel());
        tblFilms.setRowSorter(sorterFilms);
        sorterFilms.setRowFilter(RowFilter.regexFilter(txtSearch.getText()));
        TableRowSorter<DefaultTableModel> sorterSeries = new TableRowSorter<DefaultTableModel>((DefaultTableModel) tblSeries.getModel());
        tblSeries.setRowSorter(sorterSeries);
        sorterSeries.setRowFilter(RowFilter.regexFilter(txtSearch.getText()));
    }//GEN-LAST:event_txtSearchKeyReleased

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
            java.util.logging.Logger.getLogger(FilmArchive.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FilmArchive.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FilmArchive.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FilmArchive.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FilmArchive().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(FilmArchive.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddFilm;
    private javax.swing.JButton btnAddSeries;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.Box.Filler filler7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel stEpisodes;
    private javax.swing.JLabel stMovies;
    private javax.swing.JLabel stSeries;
    private javax.swing.JLabel stTime;
    private javax.swing.JTabbedPane tabPane;
    private javax.swing.JTable tblFilms;
    private javax.swing.JTable tblSeries;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
