/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class AddStudent extends javax.swing.JFrame {
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    int mousexdrag, mouseydrag;

    /**
     * Creates new form AddTeacher
     */
    public AddStudent(){
        initComponents();
        setIcon();
        try {
            tables();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        Edit.setVisible(false);
        Labeling.setText(null);
        PanelB.setVisible(false);
        PanelBC.setVisible(true);
        PanelA2.setVisible(false);
        back.setVisible(false);
        
        Tables.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        Tables.getTableHeader().setOpaque(false);
        Tables.getTableHeader().setBackground(new Color(0,102,204));
        Tables.getTableHeader().setForeground(new Color(255,255,255));
        Tables.setRowHeight(25);
        Tables.setSelectionForeground(Color.WHITE);
   }
    
    private void tables() throws ClassNotFoundException{
        DefaultTableModel model = new DefaultTableModel();
       
       model.addColumn("No");
       model.addColumn("NISN");
       model.addColumn("Nama");
       model.addColumn("Tanggal Lahir");
       model.addColumn("Jenis Kelamin");
       model.addColumn("Kelas");
       model.addColumn("Angkatan");
       
       try{
       int numbers = 1;
       String SQL = "SELECT * FROM student";
       java.sql.Connection conn = Connections.getConnection();
       java.sql.Statement pst = conn.createStatement();
       java.sql.ResultSet rs = pst.executeQuery(SQL);
       
       while(rs.next()){
        model.addRow
        (new Object[]{numbers++, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(10), rs.getString(11) });
       }
       
       Tables.setModel(model);
       }catch(SQLException e){
           System.out.println(e.getMessage());
       }
    
    }
    
    private void clear(){
        NISN.setText(null);
        Name.setText(null);
        Parents.setText(null);
        HP.setText(null);
        School.setText(null);
        Address.setText(null);
        Labeling.setText(null);
        ((JTextField)Date.getDateEditor().getUiComponent()).setText(null);
        Gender.setSelectedItem("SELECT");
        NISN2.setText(null);
        NIS.setText(null);
        Class.setText(null);
        Years.setText(null);
        Absent.setText(null);
    }
    
    private void delete() throws ClassNotFoundException{
           try{
            String nisn = NISN.getText();
            String SQL = "DELETE FROM student WHERE NISN = '" + nisn + "'";
            conn =  Connections.getConnection();
            pst = conn.prepareStatement(SQL);
            pst.execute(SQL);
            tables();
       }catch(SQLException e){
           System.out.println(e.getMessage());
       } 
    }
    
       private void showUp(){
       DefaultTableModel model = new DefaultTableModel();
       
       model.addColumn("No");
       model.addColumn("NISN");
       model.addColumn("Nama");
       model.addColumn("Tanggal Lahir");
       model.addColumn("Jenis Kelamin");
       model.addColumn("Kelas");
       model.addColumn("Angkatan");
       
       String G = SearchT.getText();
       try{
       int numbers = 1;
       String SQL = "SELECT * FROM student WHERE "
       + "NISN LIKE '"+G+"%' OR name LIKE '"+G+"%' OR date LIKE '"+G+"%' OR gender LIKE '"+G+"%' OR class LIKE '"+G+"%' OR years LIKE '"+G+"%' ";
       java.sql.Connection conn = Connections.getConnection();
       java.sql.Statement pst = conn.createStatement();
       java.sql.ResultSet rs = pst.executeQuery(SQL);
       
       while(rs.next()){
        model.addRow
        (new Object[]{numbers++, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(10), rs.getString(11) });
       }
       
       Tables.setModel(model);
       }catch(SQLException e){
           System.out.println(e.getMessage());
       }
    
    }
       
        public void NewsS(){
            try{
             DefaultTableModel model = new DefaultTableModel();
       
            model.addColumn("No");
            model.addColumn("NISN");
            model.addColumn("Nama");
            model.addColumn("Tanggal Lahir");
            model.addColumn("Jenis Kelamin");
            model.addColumn("Kelas");
            model.addColumn("Angkatan");
             
            int numbers = 1;
            String SQL = "SELECT * FROM student WHERE class = '"+ "" +"'";
             java.sql.Connection conn = Connections.getConnection();
             java.sql.Statement pst = conn.createStatement();
             java.sql.ResultSet rs = pst.executeQuery(SQL);
       
            while(rs.next()){
            model.addRow
            (new Object[]{numbers++, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(10), rs.getString(11) });
            }
       
       Tables.setModel(model);
        
        }catch(SQLException e){
            e.getMessage();
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

        jTextField3 = new javax.swing.JTextField();
        Panels = new javax.swing.JPanel();
        PanelA = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        PanelB = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        Edit = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        SearchT = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tables = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        adding = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        NewS = new javax.swing.JLabel();
        PanelA1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Name = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Parents = new javax.swing.JTextField();
        HP = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        School = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Address = new javax.swing.JTextArea();
        Cancel = new javax.swing.JButton();
        Save = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        NISN = new javax.swing.JTextField();
        Labeling = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        Date = new com.toedter.calendar.JDateChooser();
        Gender = new javax.swing.JComboBox<>();
        PanelBC = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        PanelA2 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        NISN2 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        NIS = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        Class = new javax.swing.JTextField();
        Years = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        Absent = new javax.swing.JTextField();
        Update = new javax.swing.JButton();
        Cancel2 = new javax.swing.JButton();

        jTextField3.setText("jTextField3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tambah Data Guru");
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
        jLabel1.setText("Tambah Data Siswa");
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
        PanelB.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 444, 60));

        Edit.setBackground(new java.awt.Color(255, 255, 0));
        Edit.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        Edit.setForeground(new java.awt.Color(255, 255, 255));
        Edit.setText("EDIT");
        Edit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)));
        Edit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditMouseClicked(evt);
            }
        });
        PanelB.add(Edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, 110, 35));

        Delete.setBackground(new java.awt.Color(255, 0, 0));
        Delete.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        Delete.setForeground(new java.awt.Color(255, 255, 255));
        Delete.setText("DELETE");
        Delete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        Delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteMouseClicked(evt);
            }
        });
        PanelB.add(Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, 110, 35));

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
        PanelB.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 390, 110, 35));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Source/Images/icons8_search_30px_1.png"))); // NOI18N
        PanelB.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 30, -1));

        SearchT.setForeground(new java.awt.Color(0, 102, 204));
        SearchT.setBorder(null);
        SearchT.setCaretColor(new java.awt.Color(0, 102, 204));
        SearchT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchTKeyReleased(evt);
            }
        });
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

        PanelB.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 444, 125));

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

        adding.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        adding.setForeground(new java.awt.Color(0, 102, 204));
        adding.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        adding.setText("Mengisi data tambahan siswa ");
        adding.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        adding.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addingMouseClicked(evt);
            }
        });
        PanelB.add(adding, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 430, 230, 30));

        back.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        back.setForeground(new java.awt.Color(0, 102, 204));
        back.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        back.setText("Kembali ke Halaman Awal");
        back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        PanelB.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 430, 170, 30));

        NewS.setForeground(new java.awt.Color(0, 102, 204));
        NewS.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        NewS.setText("Cari Calon Siswa Baru");
        NewS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NewSMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                NewSMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                NewSMouseExited(evt);
            }
        });
        PanelB.add(NewS, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 460, 120, 20));

        Panels.add(PanelB, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, 480, 630));

        PanelA1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Cambria", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("TAMBAH DATA BARU");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 204));
        jLabel8.setText("Masukan Nama Lengkap");

        Name.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Name.setForeground(new java.awt.Color(0, 102, 204));
        Name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 204));
        jLabel9.setText("Masukan Nama Orang Tua (Ayah)");

        Parents.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Parents.setForeground(new java.awt.Color(0, 102, 204));
        Parents.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));

        HP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        HP.setForeground(new java.awt.Color(0, 102, 204));
        HP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 204));
        jLabel11.setText("Masukan Nomor Handphone");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 204));
        jLabel12.setText("Masukan Sekolah Asal");

        School.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        School.setForeground(new java.awt.Color(0, 102, 204));
        School.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 204));
        jLabel13.setText("Masukan Alamat Lengkap");

        Address.setColumns(20);
        Address.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N
        Address.setForeground(new java.awt.Color(0, 102, 204));
        Address.setRows(5);
        Address.setBorder(null);
        jScrollPane2.setViewportView(Address);

        Cancel.setBackground(new java.awt.Color(255, 0, 0));
        Cancel.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        Cancel.setForeground(new java.awt.Color(255, 255, 255));
        Cancel.setText("CANCEL");
        Cancel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        Cancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CancelMouseClicked(evt);
            }
        });

        Save.setBackground(new java.awt.Color(0, 255, 0));
        Save.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        Save.setForeground(new java.awt.Color(255, 255, 255));
        Save.setText("SIMPAN");
        Save.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0)));
        Save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SaveMouseClicked(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 102, 204));
        jLabel18.setText("Masukan NISN Siswa");

        NISN.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        NISN.setForeground(new java.awt.Color(0, 102, 204));
        NISN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));

        Labeling.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Labeling.setForeground(new java.awt.Color(255, 0, 0));
        Labeling.setText("NIS SUDAH ADA");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 102, 204));
        jLabel19.setText("Masukan Tanggal Lahir & Jenis Kelamin");

        Date.setDateFormatString("d MMMMM yyyy");
        Date.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        Gender.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Gender.setForeground(new java.awt.Color(0, 102, 204));
        Gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECT", "PEREMPUAN", "LAKI-LAKI" }));

        javax.swing.GroupLayout PanelA1Layout = new javax.swing.GroupLayout(PanelA1);
        PanelA1.setLayout(PanelA1Layout);
        PanelA1Layout.setHorizontalGroup(
            PanelA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelA1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(PanelA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelA1Layout.createSequentialGroup()
                        .addComponent(NISN, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Labeling, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                    .addComponent(Name)
                    .addGroup(PanelA1Layout.createSequentialGroup()
                        .addComponent(Save, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelA1Layout.createSequentialGroup()
                        .addGroup(PanelA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Date, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Parents, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Gender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelA1Layout.createSequentialGroup()
                        .addGroup(PanelA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(School, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HP, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelA1Layout.setVerticalGroup(
            PanelA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelA1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Labeling, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NISN, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Gender)
                    .addComponent(Date, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Parents, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(School, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanelA1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Save, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        Panels.add(PanelA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 450, 630));

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

        PanelA2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel20.setFont(new java.awt.Font("Cambria", 1, 36)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 102, 204));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("TAMBAH DATA SISWA");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 102, 204));
        jLabel21.setText("KELAS");

        NISN2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        NISN2.setForeground(new java.awt.Color(0, 102, 204));
        NISN2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 102, 204));
        jLabel22.setText("NISN");

        NIS.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        NIS.setForeground(new java.awt.Color(0, 102, 204));
        NIS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 102, 204));
        jLabel23.setText("NIS");

        Class.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Class.setForeground(new java.awt.Color(0, 102, 204));
        Class.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));

        Years.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Years.setForeground(new java.awt.Color(0, 102, 204));
        Years.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 102, 204));
        jLabel24.setText("ABSENSI");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 102, 204));
        jLabel25.setText("ANGKATAN");

        Absent.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Absent.setForeground(new java.awt.Color(0, 102, 204));
        Absent.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));

        Update.setBackground(new java.awt.Color(0, 255, 0));
        Update.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        Update.setForeground(new java.awt.Color(255, 255, 255));
        Update.setText("UPDATE ");
        Update.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0)));
        Update.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpdateMouseClicked(evt);
            }
        });

        Cancel2.setBackground(new java.awt.Color(255, 0, 0));
        Cancel2.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        Cancel2.setForeground(new java.awt.Color(255, 255, 255));
        Cancel2.setText("CANCEL");
        Cancel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        Cancel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cancel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Cancel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PanelA2Layout = new javax.swing.GroupLayout(PanelA2);
        PanelA2.setLayout(PanelA2Layout);
        PanelA2Layout.setHorizontalGroup(
            PanelA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelA2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(PanelA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelA2Layout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                        .addGap(32, 32, 32))
                    .addGroup(PanelA2Layout.createSequentialGroup()
                        .addGroup(PanelA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                            .addComponent(NISN2, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                            .addComponent(NIS)
                            .addComponent(Class, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Years, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Absent, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelA2Layout.createSequentialGroup()
                        .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Cancel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))))
        );
        PanelA2Layout.setVerticalGroup(
            PanelA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelA2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel20)
                .addGap(28, 28, 28)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NISN2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NIS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Class, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Years, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Absent, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(PanelA2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cancel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(98, Short.MAX_VALUE))
        );

        Panels.add(PanelA2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 450, 630));

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

    private void SaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveMouseClicked
        // TODO add your handling code here:
        try{
        String nisn, name, dates, gender,  parents, hp, school, address;
        nisn = NISN.getText().toLowerCase();
        name = Name.getText();
        dates = ((JTextField)Date.getDateEditor().getUiComponent()).getText();
        gender = Gender.getSelectedItem().toString();
        parents = Parents.getText();
        hp = HP.getText();
        school = School.getText();
        address = Address.getText();
        
        if(nisn.equals("") || name.equals("") || dates.equals("") || gender.equals("") || parents.equals("") || hp.equals("") || school.equals("") || address.equals("")){
            new Mistakes().show();
        }else{
            String SQL = "INSERT INTO student VALUES "
             + "('" + nisn + "','" + name + "','" + dates + "','" + gender + "','" + parents + "','" + hp + "','" + school + "','" + address + "' ,'" + nisn + "','" + "" + "','" + "" + "','" + "" + "')";
        conn = Connections.getConnection();
        pst = conn.prepareStatement(SQL);
        pst.execute(SQL);
        new SaveData().show();
        clear();
        tables();
        }
        
        }catch(SQLException e){
            System.out.println(e.getMessage());
            new Exceptions().show();
            NISN.setText(null);
            Labeling.setText("NIS SUDAH ADA");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SaveMouseClicked

    private void CancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelMouseClicked
        // TODO add your handling code here:
        clear();
        try {
            tables();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        Save.setVisible(true);
        Edit.setVisible(false);
        NISN.setEnabled(true);
    }//GEN-LAST:event_CancelMouseClicked

    private void EditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditMouseClicked
        // TODO add your handling code here:
        try{
        String nisn, name, date, gender, parents, hp, school, address, nis, classes, years, absent;
        nisn = NISN.getText().toLowerCase();
        name = Name.getText();
        date = ((JTextField)Date.getDateEditor().getUiComponent()).getText();
        gender = Gender.getSelectedItem().toString();
        parents = Parents.getText();
        hp = HP.getText();
        school = School.getText();
        address = Address.getText();
        nis = NIS.getText().toLowerCase();
        classes = Class.getText();
        years = Years.getText();
        absent = Absent.getText();
        
        if(name.equals("") || date.equals("") || gender.equals("") ||  parents.equals("") || hp.equals("") || school.equals("") || address.equals("") || nis.equals("") || classes.equals("") || years.equals("") || absent.equals("")){
            new Mistakes().show();
        }else{
            String SQL = "UPDATE student SET "
             + "NISN = '" + nisn + "', name = '" + name + "', date = '" + date + "', gender = '" + gender + "', parents = '" + parents + "', handphone = '" + hp + "', school = '" + school + "', address = '" + address + "', NIS = '" + nis + "', class = '" + classes + "', years = '" + years + "', absent = '" + absent + "' WHERE  NISN = '" + nisn + "'";
        conn = Connections.getConnection();
        pst = conn.prepareStatement(SQL);
        pst.execute(SQL);
        new SaveData().show();
        clear();
        tables();
        Save.setVisible(true);
        Edit.setVisible(false);
        NISN.setEnabled(true);
        }
        
        }catch(SQLException e){
            System.out.println(e.getMessage());
            new Exceptions2().show();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_EditMouseClicked

    private void TablesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablesMouseClicked
        // TODO add your handling code here:
       int row = Tables.rowAtPoint(evt.getPoint());
       
       String nisn = Tables.getValueAt(row, 1).toString();
       NISN.setText(nisn);
       NISN2.setText(nisn);
       NISN.setEnabled(false);
       NISN2.setEnabled(false);
       
       String name = Tables.getValueAt(row, 2).toString();
       Name.setText(name);
       
       String dates = Tables.getValueAt(row, 3).toString();
       ((JTextField)Date.getDateEditor().getUiComponent()).setText(dates);
       
       String gender = Tables.getValueAt(row, 4).toString();
       Gender.setSelectedItem(gender);
       
       try{
            String SQL = "SELECT * FROM student WHERE NISN = '" + nisn +"'";
            java.sql.Connection conn = Connections.getConnection();
            java.sql.Statement pst = conn.createStatement();
            java.sql.ResultSet rs = pst.executeQuery(SQL);
            rs.next();
            
            String parent = rs.getString(5);
            Parents.setText(parent);
            
            String hp = rs.getString(6);
            HP.setText(hp);
            
            String school = rs.getString(7);
            School.setText(school);
            
            String address = rs.getString(8);
            Address.setText(address);
            
            String nis = rs.getString(9);
            NIS.setText(nis);
            
            String classes = rs.getString(10);
            Class.setText(classes);
            
            String years = rs.getString(11);
            Years.setText(years);
            
            String absent = rs.getString(12);
            Absent.setText(absent);
            
       }catch(SQLException e){
           System.out.println(e.getMessage());
       }
       
       
       Edit.setVisible(true);
       Save.setVisible(false);
    }//GEN-LAST:event_TablesMouseClicked

    private void DeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteMouseClicked
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
                        Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                {
                    try {
                        tables();
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        case JOptionPane.NO_OPTION:
             break;  
        }
        Save.setVisible(true);
        NISN.setEnabled(true);
        Edit.setVisible(false);
    }//GEN-LAST:event_DeleteMouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        try {
            // TODO add your handling code here:
            tables();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        clear();
    }//GEN-LAST:event_jButton3MouseClicked

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
        System.out.println(x + "," + y);
    }//GEN-LAST:event_PanelAMouseDragged

    private void addingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addingMouseClicked
        // TODO add your handling code here:
        PanelA2.setVisible(true);
        PanelA1.setVisible(false);
        adding.setVisible(false);
        back.setVisible(true);
    }//GEN-LAST:event_addingMouseClicked

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        // TODO add your handling code here:
        PanelA2.setVisible(false);
        PanelA1.setVisible(true);
        adding.setVisible(true);
        back.setVisible(false);
    }//GEN-LAST:event_backMouseClicked

    private void UpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateMouseClicked
        // TODO add your handling code here:
        try{
        String nisn, nis, classes, years, absent;
        nisn = NISN2.getText().toLowerCase();
        nis = NIS.getText().toLowerCase();
        classes = Class.getText();
        years = Years.getText();
        absent = Absent.getText();
        
        if(nis.equals("") || classes.equals("") || years.equals("") || absent.equals("")){
            new Mistakes().show();
        }else{
        String SQL =  "UPDATE student SET "
                + "NISN = '" + nisn + "', NIS = '" + nis + "', Class = '" + classes + "', Years = '" + years + "', Absent = '" + absent + "' WHERE NISN = '" + nisn + "' ";
        conn = Connections.getConnection();
        pst = conn.prepareStatement(SQL);
        pst.execute(SQL);
        clear();
        new SaveData().show();
        try {
          tables();
        } catch (ClassNotFoundException ex) {
           Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            new Exceptions2().show();
        }
    }//GEN-LAST:event_UpdateMouseClicked

    private void Cancel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Cancel2MouseClicked
        // TODO add your handling code here:
        clear();
        Save.setVisible(true);
        try {
            tables();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Cancel2MouseClicked

    private void SearchTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchTKeyReleased
        // TODO add your handling code here:
        showUp();
    }//GEN-LAST:event_SearchTKeyReleased

    private void NewSMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewSMouseEntered
        // TODO add your handling code here:
        NewS.setForeground(Color.RED);
    }//GEN-LAST:event_NewSMouseEntered

    private void NewSMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewSMouseExited
        // TODO add your handling code here:
        NewS.setForeground(new Color(0,102,204));
    }//GEN-LAST:event_NewSMouseExited

    private void NewSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewSMouseClicked
        // TODO add your handling code here:
        NewsS();
    }//GEN-LAST:event_NewSMouseClicked

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
            java.util.logging.Logger.getLogger(AddStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Absent;
    private javax.swing.JTextArea Address;
    private javax.swing.JButton Cancel;
    private javax.swing.JButton Cancel2;
    private javax.swing.JTextField Class;
    private com.toedter.calendar.JDateChooser Date;
    private javax.swing.JButton Delete;
    private javax.swing.JButton Edit;
    private javax.swing.JComboBox<String> Gender;
    private javax.swing.JTextField HP;
    private javax.swing.JLabel Labeling;
    private javax.swing.JTextField NIS;
    private javax.swing.JTextField NISN;
    private javax.swing.JTextField NISN2;
    private javax.swing.JTextField Name;
    private javax.swing.JLabel NewS;
    private javax.swing.JPanel PanelA;
    private javax.swing.JPanel PanelA1;
    private javax.swing.JPanel PanelA2;
    private javax.swing.JPanel PanelB;
    private javax.swing.JPanel PanelBC;
    private javax.swing.JPanel Panels;
    private javax.swing.JTextField Parents;
    private javax.swing.JButton Save;
    private javax.swing.JTextField School;
    private javax.swing.JTextField SearchT;
    private javax.swing.JTable Tables;
    private javax.swing.JButton Update;
    private javax.swing.JTextField Years;
    private javax.swing.JLabel adding;
    private javax.swing.JLabel back;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
   public void setIcon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Images/icons8_news_10px.png")));
    }


}
