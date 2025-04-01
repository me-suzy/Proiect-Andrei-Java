/*
 * Personal.java
 *
 * Created on April 26, 2004, 2:54 PM
 */

package persistenta;
//import tools.Utilitati;
import java.sql.*;
import java.util.ArrayList;
import java.math.BigDecimal;

/**
 *
 * @author  el010741
 */
public class Personal {
    public final static int NOU=1;
    public final static int MODIFICAT=2;
    public final static int STERS=3;
    public final static int SINCRONIZAT=4;
    
    protected BigDecimal marca;
    public String numepren;
    protected String compart;
    protected Timestamp datasv;
    protected BigDecimal salorar;
    protected BigDecimal salorarco;
    protected String colaborator;
    
    public oracle.sql.ROWID idLinieBD;
    protected int stare;
    
    public java.math.BigDecimal getMarca(){return this.marca;}
    public java.lang.String getNumepren(){return this.numepren;}
    public java.lang.String getCompart(){return this.compart;}
    public java.sql.Timestamp getDatasv(){return this.datasv;}
    public java.math.BigDecimal getSalorar(){return this.salorar;}
    public java.math.BigDecimal getSalorarco(){return this.salorarco;}
    public java.lang.String getColaborator(){return this.colaborator;}
    public oracle.sql.ROWID getIdLinieBD(){return this.idLinieBD;}
    
    //Metodele set
    public void setMarca(java.math.BigDecimal valNoua){
        if(valNoua==null ? marca!=valNoua : valNoua!=null&&!valNoua.equals(marca)){
            this.marca=valNoua;
            this.setStare(MODIFICAT);            
        }
    }
    public void setNumepren(java.lang.String valNoua){
        if (valNoua==null ? numepren!=valNoua : !valNoua.equals(numepren)){
            this.numepren=valNoua;
            this.setStare(MODIFICAT);            
        }
    }
    public void setCompart(java.lang.String valNoua){
        if(valNoua==null ? compart!=valNoua : !valNoua.equals(compart)){
            this.compart=valNoua;
            this.setStare(MODIFICAT);            
        }
    }
    public void setDatasv(java.sql.Timestamp valNoua){
        if(valNoua==null ? datasv!=valNoua : !valNoua.equals(datasv)){
            this.datasv=valNoua;
            this.setStare(MODIFICAT);
        }
    }
    public void setSalorar(java.math.BigDecimal valNoua){
        if(valNoua==null ? salorar!=valNoua : !valNoua.equals(salorar)){
            this.salorar=valNoua;
            this.setStare(MODIFICAT);
        }
    }
    public void setSalorarco(java.math.BigDecimal valNoua){
        if(valNoua==null ? salorarco!=valNoua : !valNoua.equals(salorarco)){
            this.salorarco=valNoua;
            this.setStare(MODIFICAT);
        }
    }
    public void setColaborator(java.lang.String valNoua){
        if(valNoua==null ? colaborator!=valNoua : !valNoua.equals(colaborator)){
            this.colaborator=valNoua;
            this.setStare(MODIFICAT);
        }
    }
    
    public Personal(){
        this.stare=NOU; 
        this.colaborator="N";
    }
    
    
    /** Creates a new instance of Personal */
    public Personal(oracle.sql.ROWID pIdlinieBD,BigDecimal pMarca, String pNumepren,String pCompart, Timestamp pDatasv,BigDecimal pSalorar, BigDecimal pSalorarco, String pColaborator){
        this.idLinieBD=pIdlinieBD;
        this.marca=pMarca;
        this.numepren=pNumepren;
        this.compart=pCompart;
        this.datasv=pDatasv;
        this.salorarco=pSalorarco;
        this.colaborator=pColaborator;
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
                stmt=conn.prepareStatement("insert into personal"+"(marca,numepren,compart,datasv,salorar,salorarco,colaborator)"+" values (?,?,?,?,?,?,?)");
                stmt.setBigDecimal(1, this.marca);
                stmt.setString(2, this.numepren);
                stmt.setString(3, this.compart);
                stmt.setTimestamp(4,this.datasv);
                stmt.setBigDecimal(5, this.salorar);
                stmt.setBigDecimal(6, this.salorarco);
                stmt.setString(7,this.colaborator);
                stmt.execute();
                //tre' sa se obtina rowid-ul noii inregistrari
                stmtRowid=conn.createStatement();
                oracle.jdbc.OracleResultSet rs=(oracle.jdbc.OracleResultSet)
                    stmtRowid.executeQuery("select rowid from personal where marca="+this.marca.toString());
                rs.next();
                this.idLinieBD=rs.getROWID(1);
                rs.close();
                this.stare=SINCRONIZAT;
            }
            else
                if(this.stare==MODIFICAT){
                    stmt=conn.prepareStatement("update personal set "+"marca=?,numepren=?,compart=?,datasv=?,salorar=?,salorarco=?,colaborator=? where rowid=?");
                    stmt.setBigDecimal(1, this.marca);
                    stmt.setString(2,this.numepren);
                    stmt.setString(3,this.compart);
                    stmt.setTimestamp(4,this.datasv);
                    stmt.setBigDecimal(5, this.salorar);
                    stmt.setBigDecimal(6, this.salorarco);
                    stmt.setString(7,this.colaborator);
                    
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
            stmt=conn.prepareStatement("select* from personal where rowid=?");
            ((oracle.jdbc.OraclePreparedStatement)stmt).setROWID(1, this.idLinieBD);
            ResultSet rs=stmt.executeQuery();
            if(rs.next()){
                this.marca=rs.getBigDecimal("marca");
                this.numepren=rs.getString("numepren");
                this.compart=rs.getString("compart");
                this.datasv=rs.getTimestamp("datasv");
                this.salorar=rs.getBigDecimal("salorar");
                this.salorarco=rs.getBigDecimal("salorarco");
                this.colaborator=rs.getString("colaborator");                
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
        String frazaSelect="Select rowid,personal.* from personal";
        if(whereFiltru!=null)
            frazaSelect +=" "+whereFiltru;
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery(frazaSelect);
        ArrayList listaObiecte=new ArrayList();
        try{
            Personal pers;
            while(rs.next()){
                pers=new Personal(
                    ((oracle.jdbc.OracleResultSet)rs).getROWID("rowid"), 
                    rs.getBigDecimal("marca"),
                    rs.getString("numepren"),
                    rs.getString("compart"),
                    rs.getTimestamp("datasv"),
                    rs.getBigDecimal("salorar"),
                    rs.getBigDecimal("salorarco"),
                    rs.getString("colaborator"));
                    pers.stare=SINCRONIZAT;
                    listaObiecte.add(pers);
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
        return this.getNumepren();
    }
}
    
