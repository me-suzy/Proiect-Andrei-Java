/*
 * Utilitati.java
 *
 * Created on April 26, 2004, 2:15 PM
 */
package persistenta;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author  el010741
 */
public class Utilitati {
    public static String user="el010741";
    public static String password=JOptionPane.showInputDialog(null, "Parola:");
    public static String service="127.0.0.1";
    public static Connection conexiune;
    public static Connection getConexiune() throws SQLException{
        if (conexiune==null){
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            conexiune=DriverManager.getConnection("jdbc:oracle:thin:@"+service,user,password);            
        }
        return conexiune;
    }

    public Utilitati() {
    }
    
}
