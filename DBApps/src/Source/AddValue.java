/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class AddValue extends javax.swing.JFrame {
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    int mousexdrag, mouseydrag;
    String code = session.get_Level();
    
    int value1, value2, value3, uts, uas, sum;
    String id;

    /**
     * Creates new form AddTeacher
     */
    public AddValue() {
        initComponents();
        setIcon();
        Code.setEnabled(false);
        Subject.setEnabled(false);
        Average.setEnabled(false);
        Category.setEnabled(false);
        tableS1();
        tableS();
        Code.setText(code);
        jButton1.setVisible(false);
        
        try {
            codeShow();
        } catch (SQLException ex) {
            Logger.getLogger(AddValue.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Tables.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        Tables.getTableHeader().setOpaque(false);
        Tables.getTableHeader().setBackground(new Color(0,102,204));
        Tables.getTableHeader().setForeground(new Color(255,255,255));
        Tables.setRowHeight(25);
        Tables.setSelectionForeground(Color.WHITE);
        
        Tables1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        Tables1.getTableHeader().setOpaque(false);
        Tables1.getTableHeader().setBackground(new Color(0,102,204));
        Tables1.getTableHeader().setForeground(new Color(255,255,255));
        Tables1.setRowHeight(25);
        Tables1.setSelectionForeground(Color.WHITE);
   }
    
    public void tableS1(){
        DefaultTableModel model = new DefaultTableModel();
        
        model.addColumn("No");
        model.addColumn("NISN");
        model.addColumn("Nama");
        model.addColumn("Kelas");
        model.addColumn("Absensi");
        
       try{
       int numbers = 1;
       String SQL = "SELECT * FROM student";
       java.sql.Connection conn = Connections.getConnection();
       java.sql.Statement pst = conn.createStatement();
       java.sql.ResultSet rs = pst.executeQuery(SQL);
       
       while(rs.next()){
        model.addRow
        (new Object[]{numbers++, rs.getString(1), rs.getString(2), rs.getString(10), rs.getString(12)});
       }
       
       Tables1.setModel(model);
       }catch(SQLException e){
           System.out.println(e.getMessage());
       }
    }
    
     public void tableS(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Absen");
        model.addColumn("NISN");
        model.addColumn("Nama");
        model.addColumn("Mapel");
        model.addColumn("Rata - Rata");
        model.addColumn("Keterangan");
        model.addColumn("Semester");
        
        
       try{
       String SQL = "SELECT A.absent, A.name, B.NISN, B.code, B.subject, B.value1, B.value2, B.value3, B.UTS, B.UAS, B.average, B.category, B.semester, B.id FROM student AS A INNER JOIN course AS B ON A.NISN = B.NISN WHERE B.code = '"+code+"'";
       java.sql.Connection conn = Connections.getConnection();
       java.sql.Statement pst = conn.createStatement();
       java.sql.ResultSet rs = pst.executeQuery(SQL);
       
       while(rs.next()){
        model.addRow
        (new Object[]{rs.getString(14), rs.getString(1), rs.getString(3), rs.getString(2), rs.getString(5), rs.getString(11), rs.getString(12), rs.getString(13)});
       }
       
       Tables.setModel(model);
       }catch(SQLException e){
           System.out.println(e.getMessage());
       }
    }
     
     public void codeShow() throws SQLException{
         String SQL = "SELECT * FROM data_teacher WHERE code = '"+code+"'";
         java.sql.Connection conn = Connections.getConnection();
         java.sql.Statement pst = conn.createStatement();
         java.sql.ResultSet rs = pst.executeQuery(SQL);
         rs.next();
         
         Subject.setText(rs.getString("subject"));
        
     }
     
     public void Resets(){
         NISN.setText(null);
         Semester.setText(null);
         Value1.setText(null);
         Value2.setText(null);
         Value3.setText(null);
         UTS.setText(null);
         UAS.setText(null);
         Average.setText("Rata-Rata Nilai");
         Category.setText("Keterangan Lulus atau Tidak");
         Average.setDisabledTextColor(Color.BLUE);
         Category.setDisabledTextColor(Color.BLUE);
     }
     
    public void delete() throws ClassNotFoundException{
       try{
            id = Labeling.getText();
            String SQL = "DELETE FROM course WHERE id = '" + id + "'";
            conn =  Connections.getConnection();
            pst = conn.prepareStatement(SQL);
            pst.execute(SQL);
            tableS();
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

        Panels = new javax.swing.JPanel();
        PanelA = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        PanelB = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        SearchT = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tables = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tables1 = new javax.swing.JTable();
        jSeparator3 = new javax.swing.JSeparator();
        SearchT1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Subject = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Value1 = new javax.swing.JTextField();
        Value2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Value3 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        Code = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        UTS = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        UAS = new javax.swing.JTextField();
        Category = new javax.swing.JTextField();
        Average = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        NISN = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        Semester = new javax.swing.JTextField();
        Labeling = new javax.swing.JLabel();
        PanelBC = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tambah Nilai Siswa");
        setUndecorated(true);
        setResizable(false);

        Panels.setBackground(new java.awt.Color(255, 255, 255));
        Panels.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelA.setBackground(new java.awt.Color(247, 247, 247));
        PanelA.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        PanelA.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                PanelAMouseDragged(evt);
            }
        });
        PanelA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PanelAMousePressed(evt);
            }
        });
        PanelA.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Source/Images/icons8_news_20px.png"))); // NOI18N
        jLabel1.setText("Tambah Data Nilai Siswa");
        PanelA.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 4, 190, 20));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Source/Images/icons8_close_window_30px_9.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
        });
        PanelA.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 0, 40, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Source/Images/icons8_minimize_window_30px_1.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });
        PanelA.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 0, -1, 30));

        Panels.add(PanelA, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 30));

        PanelB.setBackground(new java.awt.Color(255, 255, 255));
        PanelB.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Cambria", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 204));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("TABLE PREVIEW");
        PanelB.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 444, 60));

        jButton1.setBackground(new java.awt.Color(255, 255, 0));
        jButton1.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("EDIT");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        PanelB.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 570, 110, 35));

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("DELETE");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        PanelB.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 570, 110, 35));

        jButton3.setBackground(new java.awt.Color(0, 102, 204));
        jButton3.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("REFRESH");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        PanelB.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 570, 110, 35));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Source/Images/icons8_search_30px_1.png"))); // NOI18N
        PanelB.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 30, -1));

        SearchT.setForeground(new java.awt.Color(0, 102, 204));
        SearchT.setBorder(null);
        SearchT.setCaretColor(new java.awt.Color(0, 102, 204));
        PanelB.add(SearchT, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 210, 150, 30));

        jSeparator2.setForeground(new java.awt.Color(0, 102, 204));
        PanelB.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, 159, 10));

        Tables.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Tables.setForeground(new java.awt.Color(0, 102, 204));
        Tables.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nama", "Mata Pelajaran", "Alamat", "No Handphone"
            }
        ));
        Tables.setFocusable(false);
        Tables.setIntercellSpacing(new java.awt.Dimension(0, 0));
        Tables.setRowHeight(25);
        Tables.setSelectionBackground(new java.awt.Color(232, 57, 95));
        Tables.setShowVerticalLines(false);
        Tables.getTableHeader().setReorderingAllowed(false);
        Tables.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tables);

        PanelB.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 444, 125));

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Source/Images/icons8_back_to_60px.png"))); // NOI18N
        jLabel17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel17MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel17MouseExited(evt);
            }
        });
        PanelB.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 70, 70));

        Tables1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Tables1.setForeground(new java.awt.Color(0, 102, 204));
        Tables1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nama", "Mata Pelajaran", "Alamat", "No Handphone"
            }
        ));
        Tables1.setFocusable(false);
        Tables1.setIntercellSpacing(new java.awt.Dimension(0, 0));
        Tables1.setRowHeight(25);
        Tables1.setSelectionBackground(new java.awt.Color(232, 57, 95));
        Tables1.setShowVerticalLines(false);
        Tables1.getTableHeader().setReorderingAllowed(false);
        Tables1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tables1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Tables1);

        PanelB.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 444, 125));

        jSeparator3.setForeground(new java.awt.Color(0, 102, 204));
        PanelB.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 430, 159, 10));

        SearchT1.setForeground(new java.awt.Color(0, 102, 204));
        SearchT1.setBorder(null);
        SearchT1.setCaretColor(new java.awt.Color(0, 102, 204));
        PanelB.add(SearchT1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 400, 150, 30));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Source/Images/icons8_search_30px_1.png"))); // NOI18N
        PanelB.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, 30, -1));

        Panels.add(PanelB, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, 480, 630));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Cambria", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("TAMBAH DATA BARU");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 6, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 204));
        jLabel8.setText("Masukan Mata Pelajaran");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 130, 185, 21));

        Subject.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Subject.setForeground(new java.awt.Color(0, 102, 204));
        Subject.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));
        jPanel1.add(Subject, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 157, 201, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 204));
        jLabel9.setText("Masukan Nilai Ulangan Pertama");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 198, 201, 21));

        Value1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Value1.setForeground(new java.awt.Color(0, 102, 204));
        Value1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));
        jPanel1.add(Value1, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 225, 100, 30));

        Value2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Value2.setForeground(new java.awt.Color(0, 102, 204));
        Value2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));
        jPanel1.add(Value2, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 293, 100, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 204));
        jLabel11.setText("Masukan Nilai Ulangan Kedua");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 266, 185, 21));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 204));
        jLabel12.setText("Masukan Nilai Ulangan Ketiga");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 334, 185, 21));

        Value3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Value3.setForeground(new java.awt.Color(0, 102, 204));
        Value3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));
        jPanel1.add(Value3, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 361, 100, 30));

        jButton4.setBackground(new java.awt.Color(255, 0, 0));
        jButton4.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("CANCEL");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 583, 150, 36));

        jButton5.setBackground(new java.awt.Color(0, 255, 0));
        jButton5.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("SIMPAN");
        jButton5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0)));
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 583, 150, 36));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 102, 204));
        jLabel18.setText("Masukan Kode Guru");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 67, 185, 21));

        Code.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Code.setForeground(new java.awt.Color(0, 102, 204));
        Code.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));
        jPanel1.add(Code, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 94, 160, 30));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 102, 204));
        jLabel19.setText("Masukan Nilai Ujian Tengah Semester (UTS)");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 402, -1, 21));

        UTS.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        UTS.setForeground(new java.awt.Color(0, 102, 204));
        UTS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));
        jPanel1.add(UTS, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 429, 100, 30));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 102, 204));
        jLabel20.setText("Masukan Nilai Ujian Akhir Semester (UAS)");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 470, -1, 21));

        UAS.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        UAS.setForeground(new java.awt.Color(0, 102, 204));
        UAS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));
        jPanel1.add(UAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 497, 100, 30));

        Category.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Category.setForeground(new java.awt.Color(0, 102, 204));
        Category.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Category.setText("Keterangan Lulus Atau Tidak");
        Category.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));
        Category.setDisabledTextColor(new java.awt.Color(0, 102, 204));
        jPanel1.add(Category, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 538, 200, 30));

        Average.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Average.setForeground(new java.awt.Color(0, 102, 204));
        Average.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Average.setText("Rata-Rata Nilai");
        Average.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));
        Average.setDisabledTextColor(new java.awt.Color(0, 102, 204));
        jPanel1.add(Average, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 538, 134, 30));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 102, 204));
        jLabel21.setText("Masukan NISN Siswa");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 67, 185, 21));

        NISN.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        NISN.setForeground(new java.awt.Color(0, 102, 204));
        NISN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));
        jPanel1.add(NISN, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 94, 185, 30));

        jButton6.setBackground(new java.awt.Color(0, 102, 204));
        jButton6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Tampilkan");
        jButton6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        jButton6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton6KeyPressed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 497, 145, 30));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 102, 204));
        jLabel22.setText("Semester");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 130, 185, 21));

        Semester.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Semester.setForeground(new java.awt.Color(0, 102, 204));
        Semester.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));
        jPanel1.add(Semester, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 157, 185, 30));

        Labeling.setBackground(new java.awt.Color(255, 255, 255));
        Labeling.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(Labeling, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 225, 67, 30));

        Panels.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 450, 630));

        PanelBC.setBackground(new java.awt.Color(0, 102, 204));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Source/Images/icons8_news_135px.png"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("SCHOOL MANAGEMENT INFORMATION");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Create Your Information with Us");
        jLabel14.setToolTipText("");

        jLabel15.setFont(new java.awt.Font("Calibri", 1, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Version 1.0 BETA");

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Source/Images/icons8_view_more_70px.png"))); // NOI18N
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel16MouseExited(evt);
            }
        });

        javax.swing.GroupLayout PanelBCLayout = new javax.swing.GroupLayout(PanelBC);
        PanelBC.setLayout(PanelBCLayout);
        PanelBCLayout.setHorizontalGroup(
            PanelBCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBCLayout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addGroup(PanelBCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72))
            .addGroup(PanelBCLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelBCLayout.setVerticalGroup(
            PanelBCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBCLayout.createSequentialGroup()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addContainerGap(210, Short.MAX_VALUE))
        );

        Panels.add(PanelBC, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 490, 630));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panels, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panels, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(925, 660));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseEntered
        // TODO add your handling code here:
        ImageIcon A = new ImageIcon(getClass().getResource("Images/icons8_view_more_70px_1.png"));
        jLabel16.setIcon(A);
    }//GEN-LAST:event_jLabel16MouseEntered

    private void jLabel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseExited
        // TODO add your handling code here:
        ImageIcon A = new ImageIcon(getClass().getResource("Images/icons8_view_more_70px.png"));
        jLabel16.setIcon(A);
    }//GEN-LAST:event_jLabel16MouseExited

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        // TODO add your handling code here:
        PanelBC.setVisible(false);
        PanelB.setVisible(true);
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseEntered
        // TODO add your handling code here:
        ImageIcon A = new ImageIcon(getClass().getResource("Images/icons8_back_to_60px_1.png"));
        jLabel17.setIcon(A);
    }//GEN-LAST:event_jLabel17MouseEntered

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        // TODO add your handling code here:
        PanelBC.setVisible(true);
        PanelB.setVisible(false);
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jLabel17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseExited
        // TODO add your handling code here:
        ImageIcon A = new ImageIcon(getClass().getResource("Images/icons8_back_to_60px.png"));
        jLabel17.setIcon(A);
    }//GEN-LAST:event_jLabel17MouseExited

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        // TODO add your handling code here:
        ImageIcon A = new ImageIcon(getClass().getResource("Images/close_window_30px.png"));
        jLabel2.setIcon(A);
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        // TODO add your handling code here:
        ImageIcon A = new ImageIcon(getClass().getResource("Images/icons8_close_window_30px_9.png"));
        jLabel2.setIcon(A);
    }//GEN-LAST:event_jLabel2MouseExited

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        // TODO add your handling code here:
        ImageIcon A = new ImageIcon(getClass().getResource("Images/icons8_minimize_window_30px_2.png"));
        jLabel3.setIcon(A);
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        // TODO add your handling code here:
        ImageIcon A = new ImageIcon(getClass().getResource("Images/icons8_minimize_window_30px_1.png"));
        jLabel3.setIcon(A);
    }//GEN-LAST:event_jLabel3MouseExited

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        this.setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void PanelAMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelAMousePressed
        // TODO add your handling code here:
        mousexdrag = evt.getX();
        mouseydrag = evt.getY();
    }//GEN-LAST:event_PanelAMousePressed

    private void PanelAMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelAMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        this.setLocation(x - mousexdrag, y - mouseydrag);
        System.out.println(x + "," +y);
    }//GEN-LAST:event_PanelAMouseDragged

    private void Tables1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tables1MouseClicked
        // TODO add your handling code here:
       int row = Tables1.rowAtPoint(evt.getPoint());
       
       String code = Tables1.getValueAt(row, 1).toString();
       NISN.setText(code);
       NISN.setEnabled(false);
    }//GEN-LAST:event_Tables1MouseClicked

    private void TablesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablesMouseClicked
        // TODO add your handling code here:
        int row = Tables.rowAtPoint(evt.getPoint());
        
        id = Tables.getValueAt(row, 0).toString();
        Labeling.setText(id);
        Labeling.setEnabled(false);
        
        String nisn2 = Tables.getValueAt(row, 2).toString();
        NISN.setText(nisn2);
        NISN.setEnabled(false);
        jButton1.setVisible(true);
        jButton5.setVisible(false);
        
        try{
            String SQL = "SELECT A.absent, A.name, B.NISN, B.code, B.subject, B.value1, B.value2, B.value3, B.UTS, B.UAS, B.average, B.category, B.semester, B.id FROM student AS A INNER JOIN course AS B ON A.NISN = B.NISN WHERE B.id = '"+id+"'";
            java.sql.Connection conn = Connections.getConnection();
            java.sql.Statement pst = conn.createStatement();
            java.sql.ResultSet rs = pst.executeQuery(SQL);
            rs.next();
            
            
            String AAA = rs.getString(6);
            Value1.setText(AAA);
            
            String BBB = rs.getString(7);
            Value2.setText(BBB);
            
            String CCC = rs.getString(8);
            Value3.setText(CCC);
            
            String DDD = rs.getString(9);
            UTS.setText(DDD);
            
            String EEE = rs.getString(10);
            UAS.setText(EEE);
            
            String FFF = rs.getString(11);
            Average.setText(FFF);
            
            String GGG = rs.getString(12);
            Category.setText(GGG);
            
            String HHH = rs.getString(13);
            Semester.setText(HHH);
            
            
            
        }catch(SQLException e){
            e.getMessage();
        }
    }//GEN-LAST:event_TablesMouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        // TODO add your handling code here:
        try{
            String B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11;
            B1 = NISN.getText();
            B2 = Code.getText();
            B3 = Subject.getText();
            B4 = Value1.getText();
            B5 = Value2.getText();
            B6 = Value3.getText();
            B7 = UTS.getText();
            B8 = UAS.getText();
            B9 = Average.getText();
            B10 = Category.getText();
            B11 = Semester.getText();
            
                    
            if(B1.equals("") || B2.equals("") || B3.equals("") || B4.equals("") || B5.equals("") || B6.equals("") || B7.equals("") || B8.equals("") || B9.equals("") || B10.equals("") || B11.equals("")){
               new Mistakes().show();
            }else{
                String SQL = "INSERT INTO course VALUES"
                         + "('"+0+"','"+B1+"', '"+B2+"', '"+B3+"', '"+B4+"', '"+B5+"', '"+B6+"', '"+B7+"', '"+B8+"', '"+B9+"', '"+B10+"', '"+B11+"')";
                
                conn = Connections.getConnection();
                pst = conn.prepareStatement(SQL);
                pst.execute(SQL);
                
                Congrats AC = new Congrats();
                AC.show();
                
                Resets();
                tableS();
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            new Errors().show();
        }
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton6KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
           if(Value1.getText().equals("") || Value2.getText().equals("") || Value3.getText().equals("") || UTS.getText().equals("") || UAS.getText().equals("")){
               new Mistakes().show();
           }else{
           value1 = Integer.parseInt(Value1.getText());
           value2 = Integer.parseInt(Value2.getText());
           value3 = Integer.parseInt(Value3.getText());
           uts = Integer.parseInt(UTS.getText());
           uas = Integer.parseInt(UAS.getText());
           
           sum = (value1 + value2 + value3 + uts + uas)/5;
           if(sum > 75){
               Category.setText("LULUS");
               Category.setDisabledTextColor(Color.GREEN);
               Average.setDisabledTextColor(Color.GREEN);
           }else{
               Category.setText("REMEDIAL");
               Category.setDisabledTextColor(Color.RED);
               Average.setDisabledTextColor(Color.RED);
           }
           Average.setText("" + sum);
        }
      }     
    }//GEN-LAST:event_jButton6KeyPressed

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        // TODO add your handling code here:
           if(Value1.getText().equals("") || Value2.getText().equals("") || Value3.getText().equals("") || UTS.getText().equals("") || UAS.getText().equals("")){
               new Mistakes().show();
           }else{
           value1 = Integer.parseInt(Value1.getText());
           value2 = Integer.parseInt(Value2.getText());
           value3 = Integer.parseInt(Value3.getText());
           uts = Integer.parseInt(UTS.getText());
           uas = Integer.parseInt(UAS.getText());
           
           sum = (value1 + value2 + value3 + uts + uas)/5;
           if(sum > 75){
               Category.setText("LULUS");
               Category.setDisabledTextColor(Color.GREEN);
               Average.setDisabledTextColor(Color.GREEN);
           }else{
               Category.setText("REMEDIAL");
               Category.setDisabledTextColor(Color.RED);
               Average.setDisabledTextColor(Color.RED);
           }
           Average.setText("" + sum);
        }
    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
        Resets();
        tableS();
        tableS1();
        jButton5.setVisible(true);
        jButton1.setVisible(false);
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        Resets();
        tableS();
        tableS1();
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        ImageIcon A = new ImageIcon(getClass().getResource("Images/icons8_error_103px.png"));
        int answer = JOptionPane.showConfirmDialog(this, "Apakah Anda Yakin ?");
        
        switch(answer){
        case JOptionPane.YES_OPTION:
             new SaveData().show();
        {
            try {
                delete();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AddTeacher.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        {
            tableS();
        }
        case JOptionPane.NO_OPTION:
             break;  
        }
        jButton5.setVisible(true);
        jButton1.setVisible(false);
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
            String B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12;
            B1 = NISN.getText();
            B2 = Code.getText();
            B3 = Subject.getText();
            B4 = Value1.getText();
            B5 = Value2.getText();
            B6 = Value3.getText();
            B7 = UTS.getText();
            B8 = UAS.getText();
            B9 = Average.getText();
            B10 = Category.getText();
            B11 = Semester.getText();
            B12 = Labeling.getText();
            
           
             if(B1.equals("") || B2.equals("") || B3.equals("") || B4.equals("") || B5.equals("") || B6.equals("") || B7.equals("") || B8.equals("") || B9.equals("") || B10.equals("") || B11.equals("")){
               new Mistakes().show();
            }else{
                try {
                    String SQL =
                            "UPDATE course SET id = '"+B12+"', NISN = '"+B1+"', code = '"+B2+"', subject = '"+B3+"', value1 = '"+B4+"', value2 = '"+B5+"', value3 = '"+B6+"', UTS = '"+B7+"', UAS = '"+B8+"', average = '"+B9+"', category = '"+B10+"', semester = '"+B11+"' WHERE id = '"+B12+"'";
                    conn = Connections.getConnection();
                    pst = conn.prepareStatement(SQL);
                    pst.execute(SQL);
                    new SaveData().show();
                    tableS();
                    Resets();
                    jButton5.setVisible(true);
                    jButton1.setVisible(false);
                } catch (SQLException ex) {
                    Logger.getLogger(AddValue.class.getName()).log(Level.SEVERE, null, ex);
                }
             }
    }//GEN-LAST:event_jButton1MouseClicked

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
            java.util.logging.Logger.getLogger(AddValue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddValue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddValue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddValue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddValue().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Average;
    private javax.swing.JTextField Category;
    private javax.swing.JTextField Code;
    private javax.swing.JLabel Labeling;
    private javax.swing.JTextField NISN;
    private javax.swing.JPanel PanelA;
    private javax.swing.JPanel PanelB;
    private javax.swing.JPanel PanelBC;
    private javax.swing.JPanel Panels;
    private javax.swing.JTextField SearchT;
    private javax.swing.JTextField SearchT1;
    private javax.swing.JTextField Semester;
    private javax.swing.JTextField Subject;
    private javax.swing.JTable Tables;
    private javax.swing.JTable Tables1;
    private javax.swing.JTextField UAS;
    private javax.swing.JTextField UTS;
    private javax.swing.JTextField Value1;
    private javax.swing.JTextField Value2;
    private javax.swing.JTextField Value3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
   public void setIcon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Images/icons8_news_10px.png")));
    }

}
