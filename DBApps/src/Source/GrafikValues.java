/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source;

import com.lowagie.text.Font;
import java.awt.Color;
import static java.awt.Font.BOLD;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;


/**
 *
 * @author Dwi Rifki Novianto
 */
public class GrafikValues extends javax.swing.JFrame {
    int total1, total2, total3;
    int Totals1, Totals2, Totals3, Totals4, Totals5,Totals6, Totals7, Totals8, Totals9, Totals10, sum, sum1;
    String local1, local2, local3;
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    
    int mousexdrag;
    int mouseydrag;
    
    String code = session.get_Level();
    

    /**
     * Creates new form Grafik
     */
    public GrafikValues(){
        initComponents();
        setIcon();
        GraphF();
        Graph1();
        Graph2();
        Graph3();
        Graph4();
        Graph5();
        Graph6();
        Graph8();
        Graph9();
        
        summ();
        summ1();
    }


        public void GraphF(){
        try {
            String SQL = "SELECT * FROM course WHERE code = '"+code+"' AND average LIKE '"+"9"+"%'";
            java.sql.Connection conn = Connections.getConnection();
            java.sql.Statement pst = conn.createStatement();
            java.sql.ResultSet rs = pst.executeQuery(SQL);
            
            rs.next();
            if(rs.last()){
                Totals10 = rs.getRow();
                rs.beforeFirst();
            }   } catch (SQLException ex) {
            Logger.getLogger(GrafikValues.class.getName()).log(Level.SEVERE, null, ex);
        }
 }

    public void Graph1(){
        try {
            String SQL = "SELECT * FROM course WHERE code = '"+code+"' AND average LIKE '"+"9"+"%'";
            java.sql.Connection conn = Connections.getConnection();
            java.sql.Statement pst = conn.createStatement();
            java.sql.ResultSet rs = pst.executeQuery(SQL);
            
            rs.next();
            if(rs.last()){
                Totals1 = rs.getRow();
                rs.beforeFirst();
            }   } catch (SQLException ex) {
            Logger.getLogger(GrafikValues.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
    
        public void Graph2() {    
        try {
            String SQL = "SELECT * FROM course WHERE code = '"+code+"' AND average LIKE '"+"8"+"%'";
            java.sql.Connection conn = Connections.getConnection();
            java.sql.Statement pst = conn.createStatement();
            java.sql.ResultSet rs = pst.executeQuery(SQL);
            
            rs.next();
            if(rs.last()){
                Totals2 = rs.getRow();
                rs.beforeFirst();
            }   } catch (SQLException ex) {
            Logger.getLogger(GrafikValues.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
        
        public void Graph3() {    
        try {
            String SQL = "SELECT * FROM course WHERE code = '"+code+"' AND average LIKE '"+"7"+"%'";
            java.sql.Connection conn = Connections.getConnection();
            java.sql.Statement pst = conn.createStatement();
            java.sql.ResultSet rs = pst.executeQuery(SQL);
            
            rs.next();
            if(rs.last()){
                Totals3 = rs.getRow();
                rs.beforeFirst();
            }   } catch (SQLException ex) {
            Logger.getLogger(GrafikValues.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
        
        
//        Last of First Graph
        
        public void Graph4() {    
        try {
            String SQL = "SELECT * FROM course WHERE code = '"+code+"' AND average LIKE '"+"6"+"%'";
            java.sql.Connection conn = Connections.getConnection();
            java.sql.Statement pst = conn.createStatement();
            java.sql.ResultSet rs = pst.executeQuery(SQL);
            
            rs.next();
            if(rs.last()){
                Totals4 = rs.getRow();
                rs.beforeFirst();
            }   } catch (SQLException ex) {
            Logger.getLogger(GrafikValues.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
        
       public void Graph5() {    
        try {
            String SQL = "SELECT * FROM course WHERE code = '"+code+"' AND average LIKE '"+"5"+"%'";
            java.sql.Connection conn = Connections.getConnection();
            java.sql.Statement pst = conn.createStatement();
            java.sql.ResultSet rs = pst.executeQuery(SQL);
            
            rs.next();
            if(rs.last()){
                Totals5 = rs.getRow();
                rs.beforeFirst();
            }   } catch (SQLException ex) {
            Logger.getLogger(GrafikValues.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
        public void Graph6() {    
        try {
            String SQL = "SELECT * FROM course WHERE code = '"+code+"' AND average LIKE '"+"4"+"%'";
            java.sql.Connection conn = Connections.getConnection();
            java.sql.Statement pst = conn.createStatement();
            java.sql.ResultSet rs = pst.executeQuery(SQL);
            
            rs.next();
            if(rs.last()){
                Totals6 = rs.getRow();
                rs.beforeFirst();
            }   } catch (SQLException ex) {
            Logger.getLogger(GrafikValues.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
        
        public void Graph7() {    
        try {
            String SQL = "SELECT * FROM course WHERE code = '"+code+"' AND average LIKE '"+"3"+"%'";
            java.sql.Connection conn = Connections.getConnection();
            java.sql.Statement pst = conn.createStatement();
            java.sql.ResultSet rs = pst.executeQuery(SQL);
            
            rs.next();
            if(rs.last()){
                Totals7 = rs.getRow();
                rs.beforeFirst();
            }   } catch (SQLException ex) {
            Logger.getLogger(GrafikValues.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
        
        
        public void Graph8() {    
        try {
            String SQL = "SELECT * FROM course WHERE code = '"+code+"' AND average LIKE '"+"2"+"%'";
            java.sql.Connection conn = Connections.getConnection();
            java.sql.Statement pst = conn.createStatement();
            java.sql.ResultSet rs = pst.executeQuery(SQL);
            
            rs.next();
            if(rs.last()){
                Totals8 = rs.getRow();
                rs.beforeFirst();
            }   } catch (SQLException ex) {
            Logger.getLogger(GrafikValues.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
        
        public void Graph9() {    
        try {
            String SQL = "SELECT * FROM course WHERE code = '"+code+"' AND average LIKE '"+"1"+"%'";
            java.sql.Connection conn = Connections.getConnection();
            java.sql.Statement pst = conn.createStatement();
            java.sql.ResultSet rs = pst.executeQuery(SQL);
            
            rs.next();
            if(rs.last()){
                Totals9 = rs.getRow();
                rs.beforeFirst();
            }   } catch (SQLException ex) {
            Logger.getLogger(GrafikValues.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
        
        
//        End of Graph
        
        public void CH1() throws SQLException{
        local1 = Choose1.getText();
        String SQL = "SELECT * FROM course WHERE code = '"+code+"' AND average LIKE '"+local1+"'";
        java.sql.Connection conn = Connections.getConnection();
        java.sql.Statement pst = conn.createStatement();
        java.sql.ResultSet rs = pst.executeQuery(SQL);
        
            rs.next();
            if(rs.last()){
                total1 = rs.getRow();
                rs.beforeFirst();     
    }
 }  
        public void CH2() throws SQLException{
        local2 = Choose2.getText();
        String SQL = "SELECT * FROM course WHERE code = '"+code+"' AND average LIKE '"+local2+"'";
        java.sql.Connection conn = Connections.getConnection();
        java.sql.Statement pst = conn.createStatement();
        java.sql.ResultSet rs = pst.executeQuery(SQL);
        
            rs.next();
            if(rs.last()){
                total2 = rs.getRow();
                rs.beforeFirst();     
    }
 } 
        
        public void CH3() throws SQLException{
        local3 = Choose3.getText();
        String SQL = "SELECT * FROM course WHERE code = '"+code+"' AND average LIKE '"+local3+"'";
        java.sql.Connection conn = Connections.getConnection();
        java.sql.Statement pst = conn.createStatement();
        java.sql.ResultSet rs = pst.executeQuery(SQL);
        
            rs.next();
            if(rs.last()){
                total3 = rs.getRow();
                rs.beforeFirst();     
    }
 } 
       public void NewGraph(){
        
        DefaultPieDataset Pie = new DefaultPieDataset();
        Pie.setValue("Nilai 70 - 100", sum);
        Pie.setValue("Nilai 69 - 100", sum1);
        
        
        JFreeChart chart = ChartFactory.createPieChart("STUDENTS SCORE RECORD", Pie);
        chart.getPlot().setBackgroundPaint(Color.WHITE);
        chart.getPlot().setOutlineStroke(null);
        chart.getTitle().setPaint(Color.BLUE);
        
        ChartPanel chartPanel = new ChartPanel(chart);
        Grafik.removeAll();
        Grafik.add(chartPanel);
        Grafik.updateUI();
        
       }
       
       public void NewGraph1(){
           DefaultCategoryDataset dod = new DefaultCategoryDataset();
            dod.setValue(sum, "Banyak Data", "Nilai 70 - 100");
            dod.setValue(sum1, "Banyak Data", "Nilai 69 - 0");
               
            JFreeChart JChart = ChartFactory.createBarChart3D("STUDENTS SCORE RECORD", "", "", dod, PlotOrientation.VERTICAL,true,true,false);
            
            CategoryPlot plot = JChart.getCategoryPlot();
            plot.setRangeGridlinePaint(Color.BLUE);
            plot.setBackgroundPaint(Color.WHITE);
            
            
            JChart.getTitle().getFont().isBold();
            JChart.getTitle().setPaint(new Color(0,102,204));
            JChart.getTitle().getFont().isItalic();
            
            
            
            ChartPanel chartPanel = new ChartPanel(JChart);
            Grafik.removeAll();
            Grafik.add(chartPanel);
            Grafik.updateUI();
       }
        
        
        public void summ(){
            sum = Totals1 + Totals2 + Totals3 + Totals10;
            Students.setText(Integer.toString(sum));
        }
        
        public void summ1(){
            sum1 = Totals4 + Totals5 + Totals6 + Totals7 + Totals8 + Totals9;
            Teacher.setText(Integer.toString(sum1));
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
        jPanel2 = new javax.swing.JPanel();
        Students = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Teacher = new javax.swing.JLabel();
        Grafik = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Choose3 = new javax.swing.JTextField();
        Choose1 = new javax.swing.JTextField();
        Choose2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Grafik Siswa dan Guru");
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(855, 630));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel1MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 0));

        Students.setFont(new java.awt.Font("Cambria", 1, 48)); // NOI18N
        Students.setForeground(new java.awt.Color(255, 255, 255));
        Students.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Students.setText("20000");
        Students.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                StudentsMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(Students, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Students, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(0, 255, 0));

        Teacher.setFont(new java.awt.Font("Cambria", 1, 48)); // NOI18N
        Teacher.setForeground(new java.awt.Color(255, 255, 255));
        Teacher.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Teacher.setText("20000");
        Teacher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TeacherMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Teacher, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Teacher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        Grafik.setBackground(new java.awt.Color(0, 102, 204));
        Grafik.setLayout(new javax.swing.BoxLayout(Grafik, javax.swing.BoxLayout.LINE_AXIS));

        jLabel4.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Rata - Rata < 70");

        jLabel5.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 204));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Rata - Rata > 70");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Source/Images/icons8_close_window_30px_9.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Source/Images/icons8_news_20px.png"))); // NOI18N
        jLabel7.setText(" Grafik Siswa & Guru - SMI Version 1.0 BETA");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Source/Images/icons8_minimize_window_30px_1.png"))); // NOI18N
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel8MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 519, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jButton1.setBackground(new java.awt.Color(0, 0, 204));
        jButton1.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("TAMPILKAN BAR CHART");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Pilih dan Cari Nilai Siswa");

        jLabel2.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("TAMPILKAN KE DALAM PIE CHART ?");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        Choose3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Choose3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Choose3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));

        Choose1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Choose1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Choose1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));

        Choose2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Choose2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Choose2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(Choose2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Choose3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Grafik, javax.swing.GroupLayout.PREFERRED_SIZE, 855, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Choose1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Choose3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Choose1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Choose2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addComponent(jLabel2)
                .addGap(7, 7, 7)
                .addComponent(Grafik, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(855, 620));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        // TODO add your handling code here:
        ImageIcon A = new ImageIcon(getClass().getResource("Images/close_window_30px.png"));
        jLabel1.setIcon(A);
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
        // TODO add your handling code here:
        ImageIcon A = new ImageIcon(getClass().getResource("Images/icons8_minimize_window_30px_2.png"));
        jLabel8.setIcon(A);
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        // TODO add your handling code here:
        ImageIcon A = new ImageIcon(getClass().getResource("Images/icons8_close_window_30px_9.png"));
        jLabel1.setIcon(A);
    }//GEN-LAST:event_jLabel1MouseExited

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited
        // TODO add your handling code here:
        ImageIcon A = new ImageIcon(getClass().getResource("Images/icons8_minimize_window_30px_1.png"));
        jLabel8.setIcon(A);
    }//GEN-LAST:event_jLabel8MouseExited

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        this.setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        // TODO add your handling code here:
         mousexdrag = evt.getX();
         mouseydrag = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        System.out.println(x + "" + y);
        this.setLocation(x - mousexdrag, y - mouseydrag);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        if(Choose1.getText().equals("") || Choose2.getText().equals("") || Choose3.getText().equals("")){
            new Mistakes().show();
        }else{
             try {
                CH1();
                CH2();
                CH3();
            
            DefaultCategoryDataset dod = new DefaultCategoryDataset();
            dod.setValue(sum, "Banyak Data", "Nilai 70 - 100");
            dod.setValue(sum1, "Banyak Data", "Nilai 69 - 0");
            dod.setValue(total1, "Banyak Data", "Nilai " + local1);
            dod.setValue(total2, "Banyak Data", "Nilai " + local2);
            dod.setValue(total3, "Banyak Data", "Nilai " + local3);
               
            JFreeChart JChart = ChartFactory.createBarChart3D("STUDENTS SCORE RECORD", "", "", dod, PlotOrientation.VERTICAL,true,true,false);
            
            CategoryPlot plot = JChart.getCategoryPlot();
            plot.setRangeGridlinePaint(Color.BLUE);
            plot.setBackgroundPaint(Color.WHITE);
            
            
            JChart.getTitle().getFont().isBold();
            JChart.getTitle().setPaint(new Color(0,102,204));
            JChart.getTitle().getFont().isItalic();
            
            
            
            ChartPanel chartPanel = new ChartPanel(JChart);
            Grafik.removeAll();
            Grafik.add(chartPanel);
            Grafik.updateUI();
            
                  
        } catch (SQLException ex) {
            Logger.getLogger(Grafik.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      }     
    }//GEN-LAST:event_jButton1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        if(Choose1.getText().equals("") || Choose2.getText().equals("") || Choose3.getText().equals("")){
            new Mistakes().show();
        }else{
            try {
                CH1();
                CH2();
                CH3();

        DefaultPieDataset Pie = new DefaultPieDataset();
        Pie.setValue("Nilai 70 - 100", sum);
        Pie.setValue("Nilai 69 - 100", sum1);
        Pie.setValue(local1, total1);
        Pie.setValue(local2, total2);
        Pie.setValue(local3, total3);
        
        JFreeChart chart = ChartFactory.createPieChart("STUDENTS SCORE RECORD", Pie);
        chart.getPlot().setBackgroundPaint(Color.WHITE);
        chart.getPlot().setOutlineStroke(null);
        chart.getTitle().setPaint(Color.BLUE);
        
        ChartPanel chartPanel = new ChartPanel(chart);
        Grafik.removeAll();
        Grafik.add(chartPanel);
        Grafik.updateUI();
        
        } catch (SQLException ex) {
            Logger.getLogger(Grafik.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       } 
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseEntered
        // TODO add your handling code here:
        GraphF();
        Graph1();
        Graph2();
        Graph3();
        Graph4();
        Graph5();
        Graph6();
        Graph8();
        Graph9();
                
        summ();
        summ1();
    }//GEN-LAST:event_jPanel1MouseEntered

    private void StudentsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StudentsMouseEntered
        // TODO add your handling code here:
        NewGraph();
    }//GEN-LAST:event_StudentsMouseEntered

    private void TeacherMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TeacherMouseEntered
        // TODO add your handling code here:
        NewGraph1();
    }//GEN-LAST:event_TeacherMouseEntered

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
            java.util.logging.Logger.getLogger(GrafikValues.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GrafikValues.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GrafikValues.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GrafikValues.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GrafikValues().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Choose1;
    private javax.swing.JTextField Choose2;
    private javax.swing.JTextField Choose3;
    private javax.swing.JPanel Grafik;
    private javax.swing.JLabel Students;
    private javax.swing.JLabel Teacher;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
  
    public void setIcon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Images/icons8_news_10px.png")));
    }

}
