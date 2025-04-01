/*
 * Compartimente.java
 *
 * Created on May 1, 2004, 9:16 PM
 */

package persistenta;
import java.sql.*;
import java.util.ArrayList;
import java.math.BigDecimal;
/**
 *
 * @author  Admin
 */
public class Sucursale {
    
    public final static int NOU=1;
    public final static int MODIFICAT=2;
    public final static int STERS=3;
    public final static int SINCRONIZAT=4;
    

    protected String sucursala;
    public String den_scr;
    
    public oracle.sql.ROWID idLinieBD;
    protected int stare;
    
    
    public java.lang.String getSucursala(){return this.sucursala;}
    public java.lang.String getden_scr(){return this.den_scr;}
    
    
    
    
    public oracle.sql.ROWID getIdLinieBD(){return this.idLinieBD;
    }   
//Metodele set

    public void setCompid(java.lang.String valNoua){
        if(valNoua==null ? sucursala!=valNoua : !valNoua.equals(sucursala)){
            this.sucursala=valNoua;
            this.setStare(MODIFICAT);            
        }
    }

    public void setCompdenumire(java.lang.String valNoua) {
        if (valNoua==null ? den_scr!=valNoua : !valNoua.equals(den_scr)){
            this.den_scr=valNoua;
            this.setStare(MODIFICAT);            
        }
    }

    
    
   

    public Sucursale(){
        this.stare=NOU; 
    }
    
    
    /** Creates a new instance of Compartimente */
    public Sucursale(oracle.sql.ROWID pIdlinieBD, String psucursala, String pden_scr){
        this.idLinieBD=pIdlinieBD;
        this.sucursala=psucursala;
        this.den_scr=pden_scr;
        }
    public int getStare(){return this.stare;}
    public void setStare(int stareNoua){
        if(this.stare==NOU && stareNoua==MODIFICAT)
            return;
        else
            this.stare=stareNoua;        
    }
    public void salveaza(Connection conn) throws Exception{
        if(this.stare==SINCRONIZAT)
            return;
        boolean conexiuneNula=false;
        if(conn==null){
            conn=Utilitati.getConexiune();
            conexiuneNula=true;
        }
        PreparedStatement stmt=null;
        Statement stmtRowid=null;
        try{
            if(this.stare==NOU){
                stmt=conn.prepareStatement("insert into sucursale"+"(sucursala,den_scr)"+" values (?,?)");
                
                stmt.setString(2, this.sucursala);
                stmt.setString(3, this.den_scr);
                
                stmt.execute();
                //tre' sa se obtina rowid-ul noii inregistrari
                stmtRowid=conn.createStatement();
                oracle.jdbc.OracleResultSet rs=(oracle.jdbc.OracleResultSet)
                    stmtRowid.executeQuery("select rowid from sucursale where sucursala="+this.sucursala.toString());
                rs.next();
                this.idLinieBD=rs.getROWID(1);
                rs.close();
                this.stare=SINCRONIZAT;
            }
            else
                if(this.stare==MODIFICAT){
                    stmt=conn.prepareStatement("update sucursale set "+"sucursala=?,den_scr=? where sucursala=?");
                    
                    stmt.setString(2,this.sucursala);
                    stmt.setString(3,this.den_scr);
                    
                    //pentru setROWID trebuie downcasting
                    ((oracle.jdbc.OraclePreparedStatement)stmt).setROWID(8,this.idLinieBD);
                    stmt.execute();
                    if(stmt.getUpdateCount()==0)
                        throw new Exception("Inregistrarea nu mai exista in baza de date!!!");
                    this.stare=SINCRONIZAT;                    
                }
            stmt.close();
        }
        catch(Exception e){
            if(stmt!=null)
                stmt.close();
            if(conexiuneNula) //daca nu am primit conexiunea, o inchid
                conn.close();
            if(stmtRowid !=null)
                stmt.close();
            throw e;
        }
        if (conexiuneNula) //daca nu am primit conexiunea, o inchid
            conn.close();      
            
    }
    public void refresh(Connection conn) throws Exception{
        if(this.idLinieBD==null)
            return;
        boolean conexiuneNula=false;
        if(conn==null){
            conn=Utilitati.getConexiune();
            conexiuneNula=true;            
        }
        PreparedStatement stmt=null;
        try{
            stmt=conn.prepareStatement("select* from sucursale where rowid=?");
            ((oracle.jdbc.OraclePreparedStatement)stmt).setROWID(1, this.idLinieBD);
            ResultSet rs=stmt.executeQuery();
            if(rs.next()){
               
                this.sucursala=rs.getString("sucursala");
                this.den_scr=rs.getString("den_scr");                           
            }
            else // inregistrarea nu mai este in BD
                throw new Exception("Inregistrarea nu mai este in baza de date!!!");
            this.stare=SINCRONIZAT;
            stmt.close();
            if(conexiuneNula)//daca nu am primit conexiunea o inchid
                conn.close();            
        }
        catch(Exception e){
            if(stmt!=null)
                stmt.close();
            if(conexiuneNula)
                conn.close();
            throw e;//trimit eroarea mai departe bloului apelant
        }
    }
    public static ArrayList getObjects(Connection conn,String whereFiltru) throws Exception{
        boolean conexiuneNula=false;
        if(conn==null){
            conn=Utilitati.getConexiune();
            conexiuneNula=true;
        }
        String frazaSelect="Select rowid,sucursala.* from sucursale";
        if(whereFiltru!=null)
            frazaSelect +=" "+whereFiltru;
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery(frazaSelect);
        ArrayList listaObiecte=new ArrayList();
        try{
            Sucursale sucursala;
            while(rs.next()){
                //Sucursale=new Sucursala(
                   // ((oracle.jdbc.OracleResultSet)rs).getROWID("rowid"),     
                   // rs.getString("compid"),
                   // rs.getString("compid"));                    
                   // comp.stare=SINCRONIZAT;
                    //listaObiecte.add(comp);
            }
            stmt.close();
        }
        catch(Exception e){if(stmt!=null)
            stmt.close();
        throw e;
    }
        if(conexiuneNula)
            conn.close();
        return listaObiecte;
    }
    public String toString(){
        return this.getden_scr();
    }
}