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
public class Compartimente {
    
    public final static int NOU=1;
    public final static int MODIFICAT=2;
    public final static int STERS=3;
    public final static int SINCRONIZAT=4;
    

    protected String compid;
    public String compdenumire;
    
    public oracle.sql.ROWID idLinieBD;
    protected int stare;
    
    
    public java.lang.String getCompid(){return this.compid;}
    public java.lang.String getCompdenumire(){return this.compdenumire;}
    
    
    
    
    public oracle.sql.ROWID getIdLinieBD(){return this.idLinieBD;
    }   
//Metodele set

    public void setCompid(java.lang.String valNoua){
        if(valNoua==null ? compid!=valNoua : !valNoua.equals(compid)){
            this.compid=valNoua;
            this.setStare(MODIFICAT);            
        }
    }

    public void setCompdenumire(java.lang.String valNoua) {
        if (valNoua==null ? compdenumire!=valNoua : !valNoua.equals(compdenumire)){
            this.compdenumire=valNoua;
            this.setStare(MODIFICAT);            
        }
    }

    
    
   

    public Compartimente(){
        this.stare=NOU; 
    }
    
    
    /** Creates a new instance of Compartimente */
    public Compartimente(oracle.sql.ROWID pIdlinieBD,String pCompid,String pCompdenumire){
        this.idLinieBD=pIdlinieBD;
        this.compid=pCompid;
        this.compdenumire=pCompdenumire;
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
                stmt=conn.prepareStatement("insert into compartimente"+"(compid,compdenumire)"+" values (?,?)");
                
                stmt.setString(2, this.compid);
                stmt.setString(3, this.compdenumire);
                
                stmt.execute();
                //tre' sa se obtina rowid-ul noii inregistrari
                stmtRowid=conn.createStatement();
                oracle.jdbc.OracleResultSet rs=(oracle.jdbc.OracleResultSet)
                    stmtRowid.executeQuery("select rowid from compartimente where compid="+this.compid.toString());
                rs.next();
                this.idLinieBD=rs.getROWID(1);
                rs.close();
                this.stare=SINCRONIZAT;
            }
            else
                if(this.stare==MODIFICAT){
                    stmt=conn.prepareStatement("update compartimente set "+"compid=?,compdenumire=? where rowid=?");
                    
                    stmt.setString(2,this.compid);
                    stmt.setString(3,this.compdenumire);
                    
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
            stmt=conn.prepareStatement("select* from compartimente where rowid=?");
            ((oracle.jdbc.OraclePreparedStatement)stmt).setROWID(1, this.idLinieBD);
            ResultSet rs=stmt.executeQuery();
            if(rs.next()){
               
                this.compid=rs.getString("compid");
                this.compdenumire=rs.getString("compdenumire");                           
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
        String frazaSelect="Select rowid,compartimente.* from compartimente";
        if(whereFiltru!=null)
            frazaSelect +=" "+whereFiltru;
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery(frazaSelect);
        ArrayList listaObiecte=new ArrayList();
        try{
            Compartimente comp;
            while(rs.next()){
                comp=new Compartimente(
                    ((oracle.jdbc.OracleResultSet)rs).getROWID("rowid"),     
                    rs.getString("compid"),
                    rs.getString("compid"));                    
                    comp.stare=SINCRONIZAT;
                    listaObiecte.add(comp);
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
        return this.getCompdenumire();
    }
}