/*
 * Angajat.java
 *
 * Created on March 8, 2004, 2:25 PM
 */

/**
 *
 * @author  el010741
 */
import java.util.*;
public class Angajat {
    private int marca;
    public String nume;
    public int[]zileLucrate;
    //public float[] salariuZi;
    public List salariuZi;
    private float salariuTotal;
    
    /** Creates a new instance of Angajat */
    public Angajat() {
        System.out.println("Initializez un angajat...");
        
    }
    public Angajat(int pMarca,String pNume){
        marca=pMarca;
        nume=pNume;
        System.out.println("Initializez angajatul "+nume);
    }
    public Angajat(int pMarca,String pNume,int[]pzileLucrate){
        this(pMarca,pNume);
        zileLucrate=pzileLucrate;
        System.out.println("Initializez un angajat cu "+zileLucrate.length+ "  luni lucrate...");
    }
public String getDataAngajat(){
    String dateAngajat="Marca: "+marca+", nume:"+nume;
    return dateAngajat;
}
public float getSalariuTotal(){
    for (int i=0; i<zileLucrate.length; i++){
    //salariuTotal+=zileLucrate[i]+salariuZi[i];
    Float salariu = (Float)salariuZi.get(i);  
    salariuTotal+=zileLucrate[i]*salariu.floatValue();}
   return salariuTotal; 
    

}
}
