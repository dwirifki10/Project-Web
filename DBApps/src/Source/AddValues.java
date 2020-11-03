/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;


/**
 *
 * @author ACER
 */
public class AddValues extends javax.swing.JFrame {
    int mousexdrag, mouseydrag;
    String level = session.get_Level();
    java.sql.Connection conn;
    java.sql.PreparedStatement pst;
    java.sql.ResultSet rs;
    
    /**
     * Creates new form AddPeople
     */
    public AddValues() {
        initComponents();
        setIcon();
        try {
            tableS();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddValues.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        TableS.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        TableS.getTableHeader().setOpaque(false);
        TableS.getTableHeader().setBackground(new Color(0,102,204));
        TableS.getTableHeader().setForeground(new Color(255,255,255));
        TableS.setRowHeight(25);
        TableS.setSelectionForeground(Color.WHITE);
    }
    
     
    private void tableS() throws ClassNotFoundException{
        DefaultTableModel model = new DefaultTableModel();
       
       model.addColumn("Id");
       model.addColumn("NISN");
       model.addColumn("Nama");
       model.addColumn("Mata Pelajaran");
       model.addColumn("Kelas");
       model.addColumn("No Absensi");
       model.addColumn("UTS");
       model.addColumn("UAS");
       model.addColumn("Rata - Rata");
       model.addColumn("Keterangan");
       
       try{
       String SQL = "SELECT B.id, B.NISN, A.name, B.subject, A.class, A.absent, B.UTS, B.UAS, B.average, B.category FROM student AS A INNER JOIN course AS B ON A.NISN = B.NISN WHERE code = '"+level+"'";
       java.sql.Connection conn = Connections.getConnection();
       java.sql.Statement pst = conn.createStatement();
       java.sql.ResultSet rs = pst.executeQuery(SQL);
       
       while(rs.next()){
        model.addRow
        (new Object[]{rs.getString("id"), rs.getString("NISN"), rs.getString("name"), rs.getString("subject"), rs.getString("class"), rs.getString("absent"), rs.getString("UTS"), rs.getString("UAS"), rs.getString("average"), rs.getString("category")});
       }     
       TableS.setModel(model);
       }catch(SQLException e){
           System.out.println(e.getMessage());
       }
    
    }
     
    
        private void deleteS() throws ClassNotFoundException{
           try{
            String id = NISN.getText();
            String SQL = "DELETE FROM course WHERE id = '"+id+"'";
            conn =  Connections.getConnection();
            pst = conn.prepareStatement(SQL);
            pst.execute(SQL);
            tableS();
       }catch(SQLException e){
           System.out.println(e.getMessage());
       } 
    }
    
      private void showUpS(){
      DefaultTableModel model = new DefaultTableModel();
       
       model.addColumn("Id");
       model.addColumn("NISN");
       model.addColumn("Nama");
       model.addColumn("Mata Pelajaran");
       model.addColumn("Kelas");
       model.addColumn("No Absensi");
       model.addColumn("UTS");
       model.addColumn("UAS");
       model.addColumn("Rata - Rata");
       model.addColumn("Keterangan");
       
       
       String G = Searching.getText();
       try{
       String SQL = "SELECT * FROM student WHERE "
       + "id LIKE '"+G+"%' OR NISN LIKE '"+G+"%' OR name LIKE '"+G+"%' OR subject LIKE '"+G+"%' OR class LIKE '"+G+"%' OR absent LIKE '"+G+"%'OR UTS LIKE '"+G+"%'OR UAS LIKE '"+G+"%'OR average LIKE '"+G+"%'OR category LIKE '"+G+"%'";
       java.sql.Connection conn = Connections.getConnection();
       java.sql.Statement pst = conn.createStatement();
       java.sql.ResultSet rs = pst.executeQuery(SQL);
       
       while(rs.next()){
         model.addRow
        (new Object[]{rs.getString("id"), rs.getString("NISN"), rs.getString("nama"), rs.getString("subject"), rs.getString("class"), rs.getString("absent"), rs.getString("UTS"), rs.getString("UAS"), rs.getString("average"), rs.getString("category")});
       }   
       
       TableS.setModel(model);
       }catch(SQLException e){
           System.out.println(e.getMessage());
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

        Panel = new javax.swing.JPanel();
        PanelA = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableS = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        NISN = new javax.swing.JLabel();
        Searching = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        Panel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        Panel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tabel Siswa dan Guru");
        setUndecorated(true);
        setResizable(false);

        Panel.setBackground(new java.awt.Color(255, 255, 255));
        Panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                PanelMouseDragged(evt);
            }
        });
        Panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PanelMousePressed(evt);
            }
        });
        Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelA.setBackground(new java.awt.Color(255, 255, 255));
        PanelA.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Source/Images/icons8_news_70px_3.png"))); // NOI18N
        PanelA.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 204));
        jLabel2.setText("SCHOOL MANAGEMENT INFORMATION");
        PanelA.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 260, 20));

        jLabel3.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 204));
        jLabel3.setText("Create Your Information with Us");
        PanelA.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 45, 215, -1));

        jLabel4.setFont(new java.awt.Font("Cambria", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 204));
        jLabel4.setText("Version 1.0 BETA");
        PanelA.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 57, 150, -1));

        TableS.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TableS.setForeground(new java.awt.Color(0, 51, 204));
        TableS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nama", "Kelas", "Alamat", "Nama Orang Tua", "No HP", "Sekolah Asal"
            }
        ));
        TableS.setFocusable(false);
        TableS.setIntercellSpacing(new java.awt.Dimension(0, 0));
        TableS.setRowHeight(25);
        TableS.setSelectionBackground(new java.awt.Color(232, 57, 95));
        TableS.setShowVerticalLines(false);
        TableS.getTableHeader().setReorderingAllowed(false);
        TableS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableSMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableS);

        PanelA.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 700, 350));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Source/Images/icons8_search_30px_1.png"))); // NOI18N
        PanelA.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 80, 30, 40));

        jSeparator2.setBackground(new java.awt.Color(0, 102, 204));
        jSeparator2.setForeground(new java.awt.Color(0, 102, 204));
        PanelA.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 110, 160, 10));

        jButton3.setBackground(new java.awt.Color(0, 255, 0));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("CETAK DATA");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0)));
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelA.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 490, 130, 40));

        jButton4.setBackground(new java.awt.Color(255, 0, 0));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("DELETE");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        PanelA.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 490, 130, 40));

        jButton6.setBackground(new java.awt.Color(0, 102, 204));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("REFRESH");
        jButton6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        PanelA.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 490, 130, 40));

        NISN.setForeground(new java.awt.Color(255, 255, 255));
        PanelA.add(NISN, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 104, 80, 20));

        Searching.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Searching.setBorder(null);
        Searching.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchingKeyReleased(evt);
            }
        });
        PanelA.add(Searching, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, 150, 30));

        Panel.add(PanelA, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 770, 550));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel1.setBackground(new java.awt.Color(0, 102, 204));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Source/Images/icons8_delete_40px_3.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
        });

        javax.swing.GroupLayout Panel1Layout = new javax.swing.GroupLayout(Panel1);
        Panel1.setLayout(Panel1Layout);
        Panel1Layout.setHorizontalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        Panel1Layout.setVerticalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        jPanel2.add(Panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 80));

        Panel2.setBackground(new java.awt.Color(0, 102, 204));
        Panel2.setForeground(new java.awt.Color(0, 102, 204));
        Panel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Panel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Panel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Panel2MouseExited(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Source/Images/icons8_user_groups_60px.png"))); // NOI18N

        javax.swing.GroupLayout Panel2Layout = new javax.swing.GroupLayout(Panel2);
        Panel2.setLayout(Panel2Layout);
        Panel2Layout.setHorizontalGroup(
            Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        Panel2Layout.setVerticalGroup(
            Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );

        jPanel2.add(Panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, -1, 470));

        Panel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 550));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(835, 550));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        // TODO add your handling code here:
        Panel1.setBackground(new Color(51,102,255));
        ImageIcon A = new ImageIcon(getClass().getResource("Images/icons8_delete_40px_4.png"));
        jLabel5.setIcon(A);
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
        // TODO add your handling code here:
        Panel1.setBackground(new Color(0,102,204));
        ImageIcon A = new ImageIcon(getClass().getResource("Images/icons8_delete_40px_3.png"));
        jLabel5.setIcon(A);
    }//GEN-LAST:event_jLabel5MouseExited

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void Panel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel2MouseEntered
        // TODO add your handling code here:
        Panel2.setBackground(new Color(51,102,255));
    }//GEN-LAST:event_Panel2MouseEntered

    private void Panel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel2MouseExited
        // TODO add your handling code here:
        Panel2.setBackground(new Color(0,102,204));
    }//GEN-LAST:event_Panel2MouseExited

    private void Panel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel2MouseClicked
        // TODO add your handling code here:
        PanelA.setVisible(true);
    }//GEN-LAST:event_Panel2MouseClicked

    private void PanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelMousePressed
        // TODO add your handling code here:
        mousexdrag = evt.getX();
        mouseydrag = evt.getY();
    }//GEN-LAST:event_PanelMousePressed

    private void PanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        this.setLocation(x - mousexdrag, y - mouseydrag);
        System.out.println(x + "," + y);
    }//GEN-LAST:event_PanelMouseDragged

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
        ImageIcon A = new ImageIcon(getClass().getResource("Images/icons8_error_103px.png"));
        int answer = JOptionPane.showConfirmDialog(this, "Apakah Anda Yakin ?");
        
        switch(answer){
        case JOptionPane.YES_OPTION:
             new SaveData().show();
                {
                    try {
                        deleteS();
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                {
                    try {
                        tableS();
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        case JOptionPane.NO_OPTION:
             break;  
        }
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        // TODO add your handling code here:
        try {
            tableS();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddValues.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6MouseClicked

    private void TableSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableSMouseClicked
        // TODO add your handling code here:
        int row = TableS.rowAtPoint(evt.getPoint());
       
        String id = TableS.getValueAt(row, 0).toString();
        NISN.setText(id);
    }//GEN-LAST:event_TableSMouseClicked

    private void SearchingKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchingKeyReleased
        // TODO add your handling code here:
        showUpS();
    }//GEN-LAST:event_SearchingKeyReleased

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
            java.util.logging.Logger.getLogger(AddValues.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddValues.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddValues.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddValues.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddValues().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NISN;
    private javax.swing.JPanel Panel;
    private javax.swing.JPanel Panel1;
    private javax.swing.JPanel Panel2;
    private javax.swing.JPanel PanelA;
    private javax.swing.JTextField Searching;
    private javax.swing.JTable TableS;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    public javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
     
    
    public void setIcon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Images/icons8_news_10px.png")));
    }


}
