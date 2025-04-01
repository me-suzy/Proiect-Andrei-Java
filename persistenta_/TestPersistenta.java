/*
 * TestPersistenta.java
 *
 * Created on April 30, 2004, 10:26 AM
 */

package persistenta;
import java.sql.*;
import java.util.*;
/**
 *
 * @author  el010741
 */
public class TestPersistenta {
    
    /** Creates a new instance of TestPersistenta */
    public TestPersistenta() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Connection conn=Utilitati.getConexiune();
        List angajati=Personal.getObjects(conn,null);
        Iterator itr=angajati.iterator();
        while (itr.hasNext())
            System.out.println(itr.next());
        angajati=Personal.getObjects(conn,"where marca=100011");          
        Personal angajat=(Personal)angajati.get(0);
        angajat.setCompart("it");
        angajat.salveaza(conn);
        angajat=new Personal();
        angajat.setMarca(new java.math.BigDecimal(100013));
        angajat.setNumepren("Salariat 100013");
        angajat.setCompart("it");
        java.text.SimpleDateFormat format= new java.text.SimpleDateFormat("dd/mm/yyyy");
        java.util.Date data= format.parse("30/04/2004");
        angajat.setDatasv(new java.sql.Timestamp(data.getTime()));
        angajat.salveaza(conn);
       conn.close();
            // TODO code application logic here
    }
    
}
