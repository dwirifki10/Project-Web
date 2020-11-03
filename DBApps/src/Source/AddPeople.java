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
public class AddPeople extends javax.swing.JFrame {
    int mousexdrag, mouseydrag;
    java.sql.Connection conn;
    java.sql.PreparedStatement pst;
    java.sql.ResultSet rs;
    
    /**
     * Creates new form AddPeople
     */
    public AddPeople() {
        initComponents();
        PanelA.setVisible(true);
        PanelB.setVisible(false);
        setIcon();
        try {
            tableA();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddPeople.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            tableS();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddPeople.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        TableS.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        TableS.getTableHeader().setOpaque(false);
        TableS.getTableHeader().setBackground(new Color(0,102,204));
        TableS.getTableHeader().setForeground(new Color(255,255,255));
        TableS.setRowHeight(25);
        TableS.setSelectionForeground(Color.WHITE);
        
                
        TableA.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        TableA.getTableHeader().setOpaque(false);
        TableA.getTableHeader().setBackground(new Color(0,102,204));
        TableA.getTableHeader().setForeground(new Color(255,255,255));
        TableA.setRowHeight(25);
        TableA.setSelectionForeground(Color.WHITE);
    }
    
    public void tableA() throws ClassNotFoundException{
       
       DefaultTableModel model = new DefaultTableModel();
       
       model.addColumn("No");
       model.addColumn("Kode");
       model.addColumn("Nama");
       model.addColumn("Mapel");
       model.addColumn("No Handphone");
       model.addColumn("Email");
       model.addColumn("Alamat");
       
       try{
       int numbers = 1;
       String SQL = "SELECT * FROM data_teacher";
       java.sql.Connection conn = Connections.getConnection();
       java.sql.Statement pst = conn.createStatement();
       java.sql.ResultSet rs = pst.executeQuery(SQL);
       
       while(rs.next()){
        model.addRow
        (new Object[]{numbers++, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)});
       }
       
       TableA.setModel(model);
       }catch(SQLException e){
           System.out.println(e.getMessage());
       }
   }
     
    private void tableS() throws ClassNotFoundException{
        DefaultTableModel model = new DefaultTableModel();
       
       model.addColumn("No");
       model.addColumn("NISN");
       model.addColumn("Nama");
       model.addColumn("Tanggal Lahir");
       model.addColumn("Jenis Kelamin");
       model.addColumn("Sekolah Asal");
       model.addColumn("Alamat");
       
       try{
       int numbers = 1;
       String SQL = "SELECT * FROM student";
       java.sql.Connection conn = Connections.getConnection();
       java.sql.Statement pst = conn.createStatement();
       java.sql.ResultSet rs = pst.executeQuery(SQL);
       
       while(rs.next()){
        model.addRow
        (new Object[]{numbers++, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(7), rs.getString(8)});
       }
       
       TableS.setModel(model);
       }catch(SQLException e){
           System.out.println(e.getMessage());
       }
    
    }
     
        public void delete() throws ClassNotFoundException{
       try{
            String code = Code1.getText();
            String SQL = "DELETE FROM data_teacher WHERE code = '" + code + "'";
            conn =  Connections.getConnection();
            pst = conn.prepareStatement(SQL);
            pst.execute(SQL);
            tableA();
       }catch(SQLException e){
           System.out.println(e.getMessage());
       }    
   }
    
        private void deleteS() throws ClassNotFoundException{
           try{
            String nisn = NISN.getText();
            String SQL = "DELETE FROM student WHERE NISN = '" + nisn + "'";
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
       
       model.addColumn("No");
       model.addColumn("NISN");
       model.addColumn("Nama");
       model.addColumn("Tanggal Lahir");
       model.addColumn("Jenis Kelamin");
       model.addColumn("Sekolah Asal");
       model.addColumn("Alamat");
       
       
       String G = Searching.getText();
       try{
       int numbers = 1;
       String SQL = "SELECT * FROM student WHERE "
       + "NISN LIKE '"+G+"%' OR name LIKE '"+G+"%' OR date LIKE '"+G+"%' OR gender LIKE '"+G+"%' OR school LIKE '"+G+"%' OR address LIKE '"+G+"%'";
       java.sql.Connection conn = Connections.getConnection();
       java.sql.Statement pst = conn.createStatement();
       java.sql.ResultSet rs = pst.executeQuery(SQL);
       
       while(rs.next()){
        model.addRow
        (new Object[]{numbers++, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(7), rs.getString(8)});
       }
       
       TableS.setModel(model);
       }catch(SQLException e){
           System.out.println(e.getMessage());
       }
    
    }
      
      public void showUpA(){
       
       DefaultTableModel model = new DefaultTableModel();
       
       model.addColumn("No");
       model.addColumn("Kode");
       model.addColumn("Nama");
       model.addColumn("Mapel");
       model.addColumn("No Handphone");
       model.addColumn("Email");
       model.addColumn("Alamat");
       
       String G = Searching1.getText();
       try{
       int numbers = 1;
       String SQL = "SELECT * FROM data_teacher WHERE "
       + "code LIKE '"+G+"%' OR name LIKE '"+G+"%' OR subject LIKE '"+G+"%' OR handphone LIKE '"+G+"%' OR email LIKE '"+G+"%' OR address LIKE '"+G+"%'";
       java.sql.Connection conn = Connections.getConnection();
       java.sql.Statement pst = conn.createStatement();
       java.sql.ResultSet rs = pst.executeQuery(SQL);
       
       while(rs.next()){
        model.addRow
        (new Object[]{numbers++, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)});
       }
       
       TableA.setModel(model);
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
        CPrint1 = new javax.swing.JLabel();
        CPrint2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Panel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        Panel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        Panel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        PanelB = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableA = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        Code1 = new javax.swing.JLabel();
        Searching1 = new javax.swing.JTextField();

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
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
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

        CPrint1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CPrint1.setForeground(new java.awt.Color(0, 102, 204));
        CPrint1.setText("Cetak Daftar Calon Siswa Baru");
        CPrint1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CPrint1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CPrint1MouseClicked(evt);
            }
        });
        PanelA.add(CPrint1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 170, 20));

        CPrint2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CPrint2.setForeground(new java.awt.Color(0, 102, 204));
        CPrint2.setText("Cetak Daftar Kelas dan Absensi");
        CPrint2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CPrint2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CPrint2MouseClicked(evt);
            }
        });
        PanelA.add(CPrint2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, 180, 20));

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
            .addGroup(Panel2Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        jPanel2.add(Panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, -1, 230));

        Panel3.setBackground(new java.awt.Color(0, 102, 204));
        Panel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Panel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Panel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Panel3MouseExited(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Source/Images/icons8_male_user_60px.png"))); // NOI18N

        javax.swing.GroupLayout Panel3Layout = new javax.swing.GroupLayout(Panel3);
        Panel3.setLayout(Panel3Layout);
        Panel3Layout.setHorizontalGroup(
            Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        Panel3Layout.setVerticalGroup(
            Panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel3Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        jPanel2.add(Panel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, -1, 240));

        Panel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 550));

        PanelB.setBackground(new java.awt.Color(255, 255, 255));
        PanelB.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Source/Images/icons8_news_70px_3.png"))); // NOI18N
        PanelB.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jLabel9.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 204));
        jLabel9.setText("SCHOOL MANAGEMENT INFORMATION");
        PanelB.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 260, 20));

        jLabel10.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 204));
        jLabel10.setText("Create Your Information with Us");
        PanelB.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 45, 215, -1));

        jLabel11.setFont(new java.awt.Font("Cambria", 0, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 204));
        jLabel11.setText("Version 1.0 BETA");
        PanelB.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 57, 150, -1));

        TableA.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TableA.setForeground(new java.awt.Color(0, 51, 204));
        TableA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nama", "Mata Pelajaran", "Alamat", "Alamat Email", "No HP"
            }
        ));
        TableA.setFocusable(false);
        TableA.setIntercellSpacing(new java.awt.Dimension(0, 0));
        TableA.setRowHeight(25);
        TableA.setSelectionBackground(new java.awt.Color(232, 57, 95));
        TableA.setShowVerticalLines(false);
        TableA.getTableHeader().setReorderingAllowed(false);
        TableA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableAMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableA);

        PanelB.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 700, 350));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Source/Images/icons8_search_30px_1.png"))); // NOI18N
        PanelB.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 80, 30, 40));

        jSeparator3.setBackground(new java.awt.Color(0, 102, 204));
        jSeparator3.setForeground(new java.awt.Color(0, 102, 204));
        PanelB.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 110, 160, 10));

        jButton5.setBackground(new java.awt.Color(0, 255, 0));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("CETAK DATA");
        jButton5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0)));
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        PanelB.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 490, 130, 40));

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("DELETE");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        PanelB.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 490, 130, 40));

        jButton1.setBackground(new java.awt.Color(0, 102, 204));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("REFRESH");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        PanelB.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 490, 130, 40));

        Code1.setBackground(new java.awt.Color(255, 255, 255));
        Code1.setForeground(new java.awt.Color(255, 255, 255));
        PanelB.add(Code1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 100, 20));

        Searching1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Searching1.setBorder(null);
        Searching1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Searching1KeyReleased(evt);
            }
        });
        PanelB.add(Searching1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, 150, 30));

        Panel.add(PanelB, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 770, 550));

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

    private void Panel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel3MouseEntered
        // TODO add your handling code here:
        Panel3.setBackground(new Color(51,102,255));
    }//GEN-LAST:event_Panel3MouseEntered

    private void Panel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel3MouseExited
        // TODO add your handling code here:
        Panel3.setBackground(new Color(0,102,204));
    }//GEN-LAST:event_Panel3MouseExited

    private void Panel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel2MouseClicked
        // TODO add your handling code here:
        PanelA.setVisible(true);
        PanelB.setVisible(false);
    }//GEN-LAST:event_Panel2MouseClicked

    private void Panel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel3MouseClicked
        // TODO add your handling code here:
        PanelA.setVisible(false);
        PanelB.setVisible(true);
    }//GEN-LAST:event_Panel3MouseClicked

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

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/scmi", "root", "");
            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\ACER\\Documents\\NetBeansProjects\\DBApps\\src\\Source\\Jasper\\ReportStudents.jrxml");
            String SQL = "SELECT * FROM student";
            
            JRDesignQuery updateQuery = new JRDesignQuery();
            updateQuery.setText(SQL);
            
            jdesign.setQuery(updateQuery);
            
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            JasperPrint jprint = JasperFillManager.fillReport(jreport, null, Connections.getConnection());
            JasperExportManager.exportReportToPdfFile(jprint, "E:\\JasperStudent.pdf");
            
            JasperViewer.viewReport(jprint, false);
                        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddPeople.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddPeople.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(AddPeople.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/scmi", "root", "");
            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\ACER\\Documents\\NetBeansProjects\\DBApps\\src\\Source\\Jasper\\ReportTeacher.jrxml");
            String SQL = "SELECT * FROM data_teacher";
            
            JRDesignQuery updateQuery = new JRDesignQuery();
            updateQuery.setText(SQL);
            
            jdesign.setQuery(updateQuery);
            
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            JasperPrint jprint = JasperFillManager.fillReport(jreport, null, Connections.getConnection());
            JasperExportManager.exportReportToPdfFile(jprint, "E:\\JasperTeacher.pdf");
            
            JasperViewer.viewReport(jprint, false);
                        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddPeople.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddPeople.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(AddPeople.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5MouseClicked

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
            try {
                tableA();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AddTeacher.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        case JOptionPane.NO_OPTION:
             break;  
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        try {
            // TODO add your handling code here:
            tableA();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddPeople.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void TableAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableAMouseClicked
        // TODO add your handling code here:
        int row = TableA.rowAtPoint(evt.getPoint());
       
       String code = TableA.getValueAt(row, 1).toString();
       Code1.setText(code);
    }//GEN-LAST:event_TableAMouseClicked

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
            Logger.getLogger(AddPeople.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6MouseClicked

    private void TableSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableSMouseClicked
        // TODO add your handling code here:
        int row = TableS.rowAtPoint(evt.getPoint());
       
        String nisn = TableS.getValueAt(row, 1).toString();
        NISN.setText(nisn);
    }//GEN-LAST:event_TableSMouseClicked

    private void SearchingKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchingKeyReleased
        // TODO add your handling code here:
        showUpS();
    }//GEN-LAST:event_SearchingKeyReleased

    private void Searching1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Searching1KeyReleased
        // TODO add your handling code here:
        showUpA();
    }//GEN-LAST:event_Searching1KeyReleased

    private void CPrint1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CPrint1MouseClicked
        // TODO add your handling code here:
         try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/scmi", "root", "");
            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\ACER\\Documents\\NetBeansProjects\\DBApps\\src\\Source\\Jasper\\ReportNewStudents.jrxml");
            String SQL = "SELECT * FROM Student WHERE class = '"+ "" +"' ";
            
            JRDesignQuery updateQuery = new JRDesignQuery();
            updateQuery.setText(SQL);
            
            jdesign.setQuery(updateQuery);
            
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            JasperPrint jprint = JasperFillManager.fillReport(jreport, null, Connections.getConnection());
            JasperExportManager.exportReportToPdfFile(jprint, "E:\\JasperNewStudents.pdf");
            
            JasperViewer.viewReport(jprint, false);
                        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddPeople.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddPeople.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(AddPeople.class.getName()).log(Level.SEVERE, null, ex);
        }
                      
    }//GEN-LAST:event_CPrint1MouseClicked

    private void CPrint2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CPrint2MouseClicked
        // TODO add your handling code here:
            try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/scmi", "root", "");
            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\ACER\\Documents\\NetBeansProjects\\DBApps\\src\\Source\\Jasper\\ReportStudentsOld.jrxml");
            String SQL = "SELECT * FROM Student ORDER BY class, absent";
            
            JRDesignQuery updateQuery = new JRDesignQuery();
            updateQuery.setText(SQL);
            
            jdesign.setQuery(updateQuery);
            
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            JasperPrint jprint = JasperFillManager.fillReport(jreport, null, Connections.getConnection());
            JasperExportManager.exportReportToPdfFile(jprint, "E:\\JasperOldStudent.pdf");
            
            JasperViewer.viewReport(jprint, false);
                        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddPeople.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddPeople.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(AddPeople.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_CPrint2MouseClicked

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
            java.util.logging.Logger.getLogger(AddPeople.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddPeople.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddPeople.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddPeople.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddPeople().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CPrint1;
    private javax.swing.JLabel CPrint2;
    private javax.swing.JLabel Code1;
    private javax.swing.JLabel NISN;
    private javax.swing.JPanel Panel;
    private javax.swing.JPanel Panel1;
    private javax.swing.JPanel Panel2;
    private javax.swing.JPanel Panel3;
    private javax.swing.JPanel PanelA;
    private javax.swing.JPanel PanelB;
    private javax.swing.JTextField Searching;
    private javax.swing.JTextField Searching1;
    private javax.swing.JTable TableA;
    private javax.swing.JTable TableS;
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
    private javax.swing.JLabel jLabel14;
    public javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
     
    
    public void setIcon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Images/icons8_news_10px.png")));
    }


}
