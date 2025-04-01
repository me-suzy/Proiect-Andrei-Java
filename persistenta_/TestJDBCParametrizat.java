/*
 * TestJDBCParametrizat.java
 *
 * Created on April 26, 2004, 2:30 PM
 */

package persistenta;
import java.sql.*;

/**
 *
 * @author  el010741
 */
public class TestJDBCParametrizat {
    
    /** Creates a new instance of TestJDBCParametrizat */
    public TestJDBCParametrizat() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException{
        Connection conn=Utilitati.getConexiune();
        conn.setAutoCommit(false);
        PreparedStatement pstm=conn.prepareStatement("update personal SET numepren=? "+"where marca=?");
        Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet cursor=stm.executeQuery("Select * from personal");
        while(cursor.next())
            System.out.println("marca:"+cursor.getString("marca")+" numepren:"+cursor.getString("numepren"));
        pstm.setString(1,"Salariat 1001 Modificat");
        pstm.setInt(2,1001);
        pstm.execute();
        cursor=stm.executeQuery("select * from personal");
        while(cursor.next())
            System.out.println("marca:"+cursor.getString("marca")+" numepren:"+cursor.getString("numepren"));
        conn.rollback();
        conn.close();

    }
    
}
