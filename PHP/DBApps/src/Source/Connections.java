package Source;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Dwi Rifki Novianto
 */
public class Connections {
     static Connection conn;
     static String url, username, password;    
     public static Connection getConnection() {
         try{
             Class.forName("com.mysql.jdbc.Driver");
             url = "jdbc:mysql://localhost:3306/scmi";
             username = "root";
             password = "";
             conn = DriverManager.getConnection(url, username, password);
         }catch(SQLException e){
             System.out.println("Terjadi kesalahan : " + e);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(Connections.class.getName()).log(Level.SEVERE, null, ex);
         }
         return conn;
     }
     
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here     
        Splash A = new Splash();
        A.show(true);
        String Url = "com.mysql.jdbc.Driver";
        for (int i = 1; i <= 100; i++){
            Thread.sleep(i + 3);
            A.Value.setText(Integer.toString(i) + "%");
            A.ProgressBar.setValue(i);
        }
        for(int j = 1; j <= 1; j++){
            Thread.sleep(50);
            A.Values.setText("Turn On the Modules");
            Thread.sleep(300);
            A.Values.setText("Please Wait");
            Thread.sleep(300);
            A.Values.setText("Get Connection from : " + Url);
            Thread.sleep(300);
            A.Values.setText("Open the Apps");
        }
        Login B = new Login();
        B.show(true);
        A.show(false);
    }         
}
