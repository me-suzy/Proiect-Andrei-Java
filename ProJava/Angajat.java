/*
 * Angajat.java
 *
 * Created on March 8, 2004, 2:22 PM
 */

/**
 *
 * @author  el011633
 */
import java.util.*;
public class Angajat {
     private int marca;
public String nume;
public int[] zileLucrate;
//public float[] salariuzi;
public List salariuzi;
private float salariuTotal;
    /** Creates a new instance of Angajat */
    public Angajat() {
   System.out.println("Initializez un Angajat...");
       
   }
 public Angajat(int pmarca, String pNume){
     marca=pmarca;
     nume=pNume;
     System.out.println("Initializez Angajatul"+nume);
    }
public Angajat(int pmarca, String pNume, int[] pZileLucrate){
    this(pmarca,pNume);
    zileLucrate=pZileLucrate;
    System.out.println("Initializez un angajat cu"+zileLucrate.length+"luni lucrate..");
}

public String getDateAngajat(){
    String dateAngajat="Marca:"+marca+"nume:"+nume;
    return dateAngajat;
}
public float getsalariuTotal(){
    for(int i=0; i<zileLucrate.length; i++){
       // salariuTotal+=zileLucrate[i]+ salariuzi[i];
       Float salariu=(Float)salariuzi.get(i);
       salariuTotal+=zileLucrate[i]*
       salariu.floatValue();
    }
    return salariuTotal;
}
}
