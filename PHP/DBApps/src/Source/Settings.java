/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source;

import java.awt.BorderLayout;
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
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author ACER
 */
public class Settings extends javax.swing.JFrame {
    int mousexdrag;
    int mouseydrag;
    java.sql.Connection conn = null;
    java.sql.PreparedStatement pst = null;
    java.sql.ResultSet rs = null;

    String log_id = session.get_log_id();
    
    /**
     * Creates new form Settings
     */
    public Settings() {
        initComponents();
        PanelB.setVisible(false);
        PanelC.setVisible(false);
        setIcon();
        UsernameA.setText(log_id);
        UsernameA.setEnabled(false);
        
        TableS();
        TableA();
        
        tableS.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        tableS.getTableHeader().setOpaque(false);
        tableS.getTableHeader().setBackground(new Color(0,102,204));
        tableS.getTableHeader().setForeground(new Color(255,255,255));
        tableS.setRowHeight(25);
        tableS.setSelectionForeground(Color.WHITE);
        CenterS();
        
        
        tableA.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        tableA.getTableHeader().setOpaque(false);
        tableA.getTableHeader().setBackground(new Color(0,102,204));
        tableA.getTableHeader().setForeground(new Color(255,255,255));
        tableA.setRowHeight(25);
        tableA.setSelectionForeground(Color.WHITE);
        CenterA();
    }
    
    public void TableS(){
       DefaultTableModel model = new DefaultTableModel();
       model.addColumn("No");
       model.addColumn("NISN");
       model.addColumn("Nama");
       model.addColumn("Kelas");
       
       try{
       int numbers = 1;
       String SQL = "SELECT * FROM student";
       java.sql.Connection conn = Connections.getConnection();
       java.sql.Statement pst = conn.createStatement();
       java.sql.ResultSet rs = pst.executeQuery(SQL);
       
       while(rs.next()){
       model.addRow(new Object[]{numbers++, rs.getString(1), rs.getString(2), rs.getString(10)});}
       tableS.setModel(model);
       
       }catch(SQLException e){
           System.out.println(e.getMessage());
       } 
    }
    
    public void TableA(){
       DefaultTableModel model = new DefaultTableModel();
       model.addColumn("No");
       model.addColumn("Kode");
       model.addColumn("Nama");
       model.addColumn("Email");
       
       try{
       int numbers = 1;
       String SQL = "SELECT * FROM data_teacher";
       java.sql.Connection conn = Connections.getConnection();
       java.sql.Statement pst = conn.createStatement();
       java.sql.ResultSet rs = pst.executeQuery(SQL);
       
       while(rs.next()){
       model.addRow(new Object[]{numbers++, rs.getString(1), rs.getString(2), rs.getString(5)});}
       tableA.setModel(model);
       
       }catch(SQLException e){
           System.out.println(e.getMessage());
       } 
    }
    
    public void CenterS(){
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            tableS.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
            tableS.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
            tableS.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
    }
    
    public void CenterA(){
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            tableS.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
            tableS.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
            tableS.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
    }
    
    public void showUp(){
       DefaultTableModel model = new DefaultTableModel();
       model.addColumn("No");
       model.addColumn("Kode");
       model.addColumn("Nama");
       model.addColumn("Email");
       
       
       String A = SearchT.getText();
       try{
       int numbers = 1;
       String SQL = "SELECT * FROM data_teacher WHERE code LIKE '"+A+"%' OR  name LIKE '"+A+"%' OR  email LIKE '"+A+"%'";
       java.sql.Connection conn = Connections.getConnection();
       java.sql.Statement pst = conn.createStatement();
       java.sql.ResultSet rs = pst.executeQuery(SQL);
       
       while(rs.next()){
       model.addRow(new Object[]{numbers++, rs.getString(1), rs.getString(2), rs.getString(5)});}
       tableA.setModel(model);
       
       }catch(SQLException e){
           System.out.println(e.getMessage());
       } 
    }
    
    public void ShowUps(){
    DefaultTableModel model = new DefaultTableModel();
       model.addColumn("No");
       model.addColumn("NISN");
       model.addColumn("Nama");
       model.addColumn("Kelas");
       
       String B = SearchS.getText();
       
       try{
       int numbers = 1;
       String SQL = "SELECT * FROM student WHERE NISN LIKE '"+B+"%' OR name LIKE '"+B+"%' OR class LIKE '"+B+"%' ";
       java.sql.Connection conn = Connections.getConnection();
       java.sql.Statement pst = conn.createStatement();
       java.sql.ResultSet rs = pst.executeQuery(SQL);
       
       while(rs.next()){
       model.addRow(new Object[]{numbers++, rs.getString(1), rs.getString(2), rs.getString(10)});}
       tableS.setModel(model);
       
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
        Panels = new javax.swing.JPanel();
        Panels1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        Panels2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        Panels3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        Panel4 = new javax.swing.JPanel();
        labels = new javax.swing.JLabel();
        PanelA = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        UsernameS = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        PasswordS = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        EmailS = new javax.swing.JTextField();
        Button1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableS = new javax.swing.JTable();
        SearchS = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        PanelB = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        UsernameT = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        NameT = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        EmailT = new javax.swing.JTextField();
        Button2 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        PasswordT = new javax.swing.JPasswordField();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableA = new javax.swing.JTable();
        SearchT = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        PanelC = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        UsernameA = new javax.swing.JTextField();
        Password2A = new javax.swing.JPasswordField();
        PasswordA = new javax.swing.JPasswordField();
        Button3 = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        IdA = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Settings");
        setAutoRequestFocus(false);
        setUndecorated(true);

        Panel.setBackground(new java.awt.Color(255, 255, 255));
        Panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204)));
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

        Panels.setBackground(new java.awt.Color(153, 153, 153));
        Panels.setForeground(new java.awt.Color(255, 255, 255));
        Panels.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panels1.setBackground(new java.awt.Color(51, 51, 51));
        Panels1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Panels1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panels1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Panels1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Panels1MouseExited(evt);
            }
        });

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Source/Images/icons8_user_groups_60px.png"))); // NOI18N

        javax.swing.GroupLayout Panels1Layout = new javax.swing.GroupLayout(Panels1);
        Panels1.setLayout(Panels1Layout);
        Panels1Layout.setHorizontalGroup(
            Panels1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        Panels1Layout.setVerticalGroup(
            Panels1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panels1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        Panels.add(Panels1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 70, 130));

        Panels2.setBackground(new java.awt.Color(51, 51, 51));
        Panels2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Panels2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panels2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Panels2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Panels2MouseExited(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Source/Images/icons8_male_user_60px.png"))); // NOI18N

        javax.swing.GroupLayout Panels2Layout = new javax.swing.GroupLayout(Panels2);
        Panels2.setLayout(Panels2Layout);
        Panels2Layout.setHorizontalGroup(
            Panels2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Panels2Layout.setVerticalGroup(
            Panels2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panels2Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        Panels.add(Panels2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 70, 110));

        Panels3.setBackground(new java.awt.Color(51, 51, 51));
        Panels3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Panels3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panels3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Panels3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Panels3MouseExited(evt);
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Source/Images/icons8_home_60px.png"))); // NOI18N

        javax.swing.GroupLayout Panels3Layout = new javax.swing.GroupLayout(Panels3);
        Panels3.setLayout(Panels3Layout);
        Panels3Layout.setHorizontalGroup(
            Panels3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Panels3Layout.setVerticalGroup(
            Panels3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panels3Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        Panels.add(Panels3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 70, 120));

        Panel4.setBackground(new java.awt.Color(51, 51, 51));
        Panel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Panel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Panel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Panel4MouseExited(evt);
            }
        });

        labels.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labels.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Source/Images/icons8_delete_40px.png"))); // NOI18N

        javax.swing.GroupLayout Panel4Layout = new javax.swing.GroupLayout(Panel4);
        Panel4.setLayout(Panel4Layout);
        Panel4Layout.setHorizontalGroup(
            Panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labels, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );
        Panel4Layout.setVerticalGroup(
            Panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labels, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        Panels.add(Panel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 90));

        Panel.add(Panels, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 450));

        PanelA.setBackground(new java.awt.Color(0, 102, 204));
        PanelA.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NEW ACCOUNT FOR STUDENT");
        PanelA.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 37, 590, 50));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Masukan NISN Siswa");
        PanelA.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 117, 130, -1));

        UsernameS.setBackground(new java.awt.Color(0, 102, 204));
        UsernameS.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        UsernameS.setForeground(new java.awt.Color(255, 255, 255));
        UsernameS.setBorder(null);
        UsernameS.setCaretColor(new java.awt.Color(255, 255, 255));
        UsernameS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                UsernameSKeyReleased(evt);
            }
        });
        PanelA.add(UsernameS, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 137, 235, 35));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Masukan Password");
        PanelA.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 190, 140, -1));

        PasswordS.setBackground(new java.awt.Color(0, 102, 204));
        PasswordS.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        PasswordS.setForeground(new java.awt.Color(255, 255, 255));
        PasswordS.setBorder(null);
        PasswordS.setCaretColor(new java.awt.Color(255, 255, 255));
        PanelA.add(PasswordS, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 210, 235, 35));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Masukan E- Mail");
        PanelA.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 263, 135, -1));

        EmailS.setBackground(new java.awt.Color(0, 102, 204));
        EmailS.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        EmailS.setForeground(new java.awt.Color(255, 255, 255));
        EmailS.setBorder(null);
        EmailS.setCaretColor(new java.awt.Color(255, 255, 255));
        PanelA.add(EmailS, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 283, 235, 35));

        Button1.setBackground(new java.awt.Color(0, 204, 0));
        Button1.setForeground(new java.awt.Color(255, 255, 255));
        Button1.setText("BUAT ACCOUNT");
        Button1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 0)));
        Button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button1MouseClicked(evt);
            }
        });
        PanelA.add(Button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 356, 235, 45));
        PanelA.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 172, 235, 10));
        PanelA.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 250, 235, 10));
        PanelA.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 320, 235, 20));

        tableS.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tableS.setForeground(new java.awt.Color(0, 102, 204));
        tableS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableS.setSelectionBackground(new java.awt.Color(232, 57, 95));
        tableS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tableSMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tableS);

        PanelA.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 330, 90));

        SearchS.setBackground(new java.awt.Color(0, 102, 204));
        SearchS.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        SearchS.setForeground(new java.awt.Color(255, 255, 255));
        SearchS.setBorder(null);
        SearchS.setCaretColor(new java.awt.Color(255, 255, 255));
        SearchS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchSKeyReleased(evt);
            }
        });
        PanelA.add(SearchS, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 160, 150, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Source/Images/icons8_search_30px_3.png"))); // NOI18N
        PanelA.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, 40, 30));
        PanelA.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, 160, -1));

        Panel.add(PanelA, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 660, 450));

        PanelB.setBackground(new java.awt.Color(0, 102, 204));
        PanelB.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("NEW ACCOUNT FOR TEACHER");
        PanelB.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 600, 50));

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Masukan Username");
        PanelB.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 280, -1));

        UsernameT.setBackground(new java.awt.Color(0, 102, 204));
        UsernameT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        UsernameT.setForeground(new java.awt.Color(255, 255, 255));
        UsernameT.setBorder(null);
        UsernameT.setCaretColor(new java.awt.Color(255, 255, 255));
        PanelB.add(UsernameT, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 280, 35));

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Masukan Kode Guru");
        PanelB.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 280, -1));

        NameT.setBackground(new java.awt.Color(0, 102, 204));
        NameT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        NameT.setForeground(new java.awt.Color(255, 255, 255));
        NameT.setBorder(null);
        NameT.setCaretColor(new java.awt.Color(255, 255, 255));
        PanelB.add(NameT, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 280, 35));

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Masukan Password");
        jLabel15.setToolTipText("");
        PanelB.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 280, -1));

        EmailT.setBackground(new java.awt.Color(0, 102, 204));
        EmailT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        EmailT.setForeground(new java.awt.Color(255, 255, 255));
        EmailT.setBorder(null);
        EmailT.setCaretColor(new java.awt.Color(255, 255, 255));
        PanelB.add(EmailT, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 280, 35));

        Button2.setBackground(new java.awt.Color(0, 204, 0));
        Button2.setForeground(new java.awt.Color(255, 255, 255));
        Button2.setText("BUAT ACCOUNT");
        Button2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 0)));
        Button2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button2MouseClicked(evt);
            }
        });
        PanelB.add(Button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 280, 45));

        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Masukan E-Mail");
        PanelB.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 280, -1));

        PasswordT.setBackground(new java.awt.Color(0, 102, 204));
        PasswordT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        PasswordT.setForeground(new java.awt.Color(255, 255, 255));
        PasswordT.setBorder(null);
        PasswordT.setCaretColor(new java.awt.Color(255, 255, 255));
        PanelB.add(PasswordT, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 280, 35));
        PanelB.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 280, -1));
        PanelB.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 280, -1));
        PanelB.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 280, 10));
        PanelB.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 280, -1));

        tableA.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tableA.setForeground(new java.awt.Color(0, 102, 204));
        tableA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableA.setSelectionBackground(new java.awt.Color(232, 57, 95));
        tableA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tableAMouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(tableA);

        PanelB.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 280, 90));

        SearchT.setBackground(new java.awt.Color(0, 102, 204));
        SearchT.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        SearchT.setForeground(new java.awt.Color(255, 255, 255));
        SearchT.setBorder(null);
        SearchT.setCaretColor(new java.awt.Color(255, 255, 255));
        SearchT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchTKeyReleased(evt);
            }
        });
        PanelB.add(SearchT, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 170, 150, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Source/Images/icons8_search_30px_3.png"))); // NOI18N
        PanelB.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, 40, 30));
        PanelB.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, 160, 10));

        Panel.add(PanelB, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 660, 450));

        PanelC.setBackground(new java.awt.Color(0, 102, 204));
        PanelC.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("CHANGE PASSWORD");
        PanelC.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 570, 60));

        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Masukan Password Baru");
        PanelC.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 170, -1));

        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Masukan Username");
        PanelC.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 170, -1));

        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Masukan Password Lama");
        PanelC.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 170, -1));

        UsernameA.setBackground(new java.awt.Color(0, 102, 204));
        UsernameA.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        UsernameA.setForeground(new java.awt.Color(255, 255, 255));
        UsernameA.setBorder(null);
        UsernameA.setCaretColor(new java.awt.Color(255, 255, 255));
        UsernameA.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        PanelC.add(UsernameA, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 250, 35));

        Password2A.setBackground(new java.awt.Color(0, 102, 204));
        Password2A.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Password2A.setForeground(new java.awt.Color(255, 255, 255));
        Password2A.setBorder(null);
        Password2A.setCaretColor(new java.awt.Color(255, 255, 255));
        PanelC.add(Password2A, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 250, 35));

        PasswordA.setBackground(new java.awt.Color(0, 102, 204));
        PasswordA.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        PasswordA.setForeground(new java.awt.Color(255, 255, 255));
        PasswordA.setBorder(null);
        PasswordA.setCaretColor(new java.awt.Color(255, 255, 255));
        PanelC.add(PasswordA, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 250, 35));

        Button3.setBackground(new java.awt.Color(0, 204, 0));
        Button3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Button3.setForeground(new java.awt.Color(255, 255, 255));
        Button3.setText("BUAT ACCOUNT");
        Button3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 0)));
        Button3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button3MouseClicked(evt);
            }
        });
        PanelC.add(Button3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 250, 40));
        PanelC.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 250, -1));
        PanelC.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 250, 10));
        PanelC.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 250, 10));
        PanelC.add(IdA, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, 50, 20));

        Panel.add(PanelC, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 660, 450));

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

        setSize(new java.awt.Dimension(725, 445));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Panels1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panels1MouseEntered
        // TODO add your handling code here:
        Panels1.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_Panels1MouseEntered

    private void Panels2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panels2MouseEntered
        // TODO add your handling code here:
        Panels2.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_Panels2MouseEntered

    private void Panels3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panels3MouseEntered
        // TODO add your handling code here:
        Panels3.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_Panels3MouseEntered

    private void Panels3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panels3MouseExited
        // TODO add your handling code here:
        Panels3.setBackground(new Color(51,51,51));
    }//GEN-LAST:event_Panels3MouseExited

    private void Panels2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panels2MouseExited
        // TODO add your handling code here:
        Panels2.setBackground(new Color(51,51,51));
    }//GEN-LAST:event_Panels2MouseExited

    private void Panels1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panels1MouseExited
        // TODO add your handling code here:
        Panels1.setBackground(new Color(51,51,51));
    }//GEN-LAST:event_Panels1MouseExited

    private void Panels1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panels1MouseClicked
        // TODO add your handling code here:
        PanelA.setVisible(true);
        PanelB.setVisible(false);
        PanelC.setVisible(false);
    }//GEN-LAST:event_Panels1MouseClicked

    private void Panels2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panels2MouseClicked
        // TODO add your handling code here:
        PanelA.setVisible(false);
        PanelB.setVisible(true);
        PanelC.setVisible(false);
    }//GEN-LAST:event_Panels2MouseClicked

    private void Panel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel4MouseEntered
        // TODO add your handling code here:
        Panel4.setBackground(new Color(102,102,102));
        ImageIcon A = new ImageIcon(getClass().getResource("Images/icons8_delete_40px_4.png"));
        labels.setIcon(A);
    }//GEN-LAST:event_Panel4MouseEntered

    private void Panel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel4MouseExited
        // TODO add your handling code here:
        Panel4.setBackground(new Color (51,51,51));
        ImageIcon A = new ImageIcon(getClass().getResource("Images/icons8_delete_40px_3.png"));
        labels.setIcon(A);
    }//GEN-LAST:event_Panel4MouseExited

    private void Panel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel4MouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_Panel4MouseClicked

    private void Panels3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panels3MouseClicked
        // TODO add your handling code here:
        PanelC.setVisible(true);
        PanelA.setVisible(false);
        PanelB.setVisible(false);
    }//GEN-LAST:event_Panels3MouseClicked

    private void PanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelMousePressed
        // TODO add your handling code here:
        mousexdrag = evt.getX();
        mouseydrag = evt.getY();
    }//GEN-LAST:event_PanelMousePressed

    private void PanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        this.setLocation(x - mousexdrag,y - mouseydrag);
        System.out.println(x + "," + y);
    }//GEN-LAST:event_PanelMouseDragged

    private void UsernameSKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UsernameSKeyReleased
        // TODO add your handling code here:
        String A = UsernameS.getText();
        PasswordS.setText(A);
        EmailS.setText(A + "@gmail.com");
    }//GEN-LAST:event_UsernameSKeyReleased

    private void Button1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button1MouseClicked
        // TODO add your handling code here:
        try{
        String A,B,C,D,E;
        A = UsernameS.getText().toLowerCase();
        B = PasswordS.getText();
        D = UsernameS.getText();
        C = EmailS.getText();
        E = "siswa";
        
        if(A.equals("") || B.equals("") || D.equals("")){
            new Mistakes().show();
        }else{
        String SQL = "INSERT INTO sign_in VALUES"
                + "('" + A + "', '" + B + "', '" + C + "', '" + D + "', '" + E + "')";
        
        conn = Connections.getConnection();
        pst = conn.prepareStatement(SQL);
        pst.execute(SQL);
                    
        Congrats AC = new Congrats();
        AC.show();       
        }
        
        }catch(SQLException e){
            new Exception().show();
        }    
    }//GEN-LAST:event_Button1MouseClicked

    private void Button2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button2MouseClicked
        // TODO add your handling code here:
        try{
        String A,B,C,D,E;
        A = UsernameT.getText().toLowerCase();
        B = PasswordT.getText();
        D = NameT.getText();
        C = EmailT.getText();
        E = "guru";
        
        if(A.equals("") || B.equals("") || D.equals("")){
            new Mistakes().show();
        }else{        
        String SQL = "INSERT INTO sign_in VALUES"
                + "('" + A + "', '" + B + "', '" + C + "', '" + D + "', '" + E + "')";
        
        conn = Connections.getConnection();
        pst = conn.prepareStatement(SQL);
        pst.execute(SQL);
                    
        Congrats AC = new Congrats();
        AC.show();       
        }    
        
        }catch(SQLException e){
            new Exception().show();
        }             
    }//GEN-LAST:event_Button2MouseClicked

    private void Button3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button3MouseClicked
        // TODO add your handling code here:
        try{
            String AAA, BCA, CCC;
            AAA = UsernameA.getText();
            BCA = PasswordA.getText();
            CCC = Password2A.getText();
            
            String SQL = "SELECT * FROM sign_in WHERE username = ? and password = ?";
            conn = Connections.getConnection();
            pst = conn.prepareStatement(SQL);
            pst.setString(1, AAA);
            pst.setString(2, BCA);
            rs = pst.executeQuery();
            
            if(rs.next()){
            String Local, Pass;
            Local = rs.getString("type");
            Pass = rs.getString("password");
            if(Local.equalsIgnoreCase("admin") && BCA.equals(Pass)){
            String SQL1 = 
            "UPDATE sign_in SET username = username ,password='" + CCC + "', NISN = NISN, email = email ,  type = type WHERE username = '"+ AAA +"'";
            conn = Connections.getConnection();
            pst = conn.prepareStatement(SQL1);
            pst.execute(SQL1);
            new Congrats().show();
            
            }else{
              new Errors().show();
            }
            
            }else{
              new Error().show();  
        }
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
    }//GEN-LAST:event_Button3MouseClicked

    private void tableSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSMouseClicked
        // TODO add your handling code here:
        int row = tableS.rowAtPoint(evt.getPoint());
       
        String nisn = tableS.getValueAt(row, 1).toString();
        UsernameS.setText(nisn);
        PasswordS.setText(nisn);
        EmailS.setText(nisn + "gmail.com");
        
    }//GEN-LAST:event_tableSMouseClicked

    private void tableAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAMouseClicked
        // TODO add your handling code here:
        int row = tableA.rowAtPoint(evt.getPoint());
       
        String nisn = tableA.getValueAt(row, 1).toString();
        NameT.setText(nisn);
        
        String email = tableA.getValueAt(row, 3).toString();
        EmailT.setText(email);
    }//GEN-LAST:event_tableAMouseClicked

    private void SearchTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchTKeyReleased
        // TODO add your handling code here:
        showUp();
    }//GEN-LAST:event_SearchTKeyReleased

    private void SearchSKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchSKeyReleased
        // TODO add your handling code here:
        ShowUps();
    }//GEN-LAST:event_SearchSKeyReleased

    private void tableSMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSMouseEntered
        // TODO add your handling code here:
        TableS();
    }//GEN-LAST:event_tableSMouseEntered

    private void tableAMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAMouseEntered
        // TODO add your handling code here:
        TableA();
    }//GEN-LAST:event_tableAMouseEntered

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
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Settings().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button1;
    private javax.swing.JButton Button2;
    private javax.swing.JButton Button3;
    private javax.swing.JTextField EmailS;
    private javax.swing.JTextField EmailT;
    private javax.swing.JLabel IdA;
    private javax.swing.JTextField NameT;
    public javax.swing.JPanel Panel;
    public javax.swing.JPanel Panel4;
    private javax.swing.JPanel PanelA;
    private javax.swing.JPanel PanelB;
    private javax.swing.JPanel PanelC;
    private javax.swing.JPanel Panels;
    private javax.swing.JPanel Panels1;
    private javax.swing.JPanel Panels2;
    private javax.swing.JPanel Panels3;
    private javax.swing.JPasswordField Password2A;
    private javax.swing.JPasswordField PasswordA;
    private javax.swing.JTextField PasswordS;
    private javax.swing.JPasswordField PasswordT;
    private javax.swing.JTextField SearchS;
    private javax.swing.JTextField SearchT;
    public javax.swing.JTextField UsernameA;
    private javax.swing.JTextField UsernameS;
    private javax.swing.JTextField UsernameT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel labels;
    private javax.swing.JTable tableA;
    private javax.swing.JTable tableS;
    // End of variables declaration//GEN-END:variables
   public void setIcon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Images/icons8_news_10px.png")));
    }


}
