/*
 * TestJDBC.java
 *
 * Created on April 5, 2004, 3:39 PM
 */

package persistenta;
import java.sql.*;
/**
 *
 * @author  el010741
 */
public class TestJDBC {
    
    /** Creates a new instance of TestJDBC */
    public TestJDBC() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1","el010741", "majestic");
        conn.setAutoCommit(false);
        Statement stm=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet cursor=stm.executeQuery("SELECT p.* FROM Personal p");
       /* cursor.beforeFirst();
        System.out.println("Marca: "+"numepren: "+"compart: ");
        while(cursor.next())
                System.out.println(cursor.getString("marca")+ " "+
                cursor.getString("numepren")+" "+
                cursor.getString("compart"));*/ 
        afiseazaCursor(cursor);
	/*cursor.first();
        String nume=cursor.getString("numepren")+" Mmdf";
        cursor.updateString("numepren",nume);
        cursor.updateRow();      
        afiseazaCursor(cursor);*/
        Statement stm2=conn.createStatement();
        System.out.println(stm2.executeUpdate("update personal set numepren=numepren||' Mdf'"));
        afiseazaCursor(cursor);       
        conn.rollback();
        //conn.commit();
        afiseazaCursor(cursor);
       //cursor.close();
       stm2.close();
       //conn.close();         
       
    }
    static void afiseazaCursor(ResultSet cursor)throws SQLException{
        cursor.beforeFirst();
        System.out.println("Marca: "+"numepren: "+"compart: ");
        while(cursor.next())
                System.out.println(cursor.getString("marca")+ " "+
                cursor.getString("numepren")+" "+
                cursor.getString("compart"));
    
    }
}
