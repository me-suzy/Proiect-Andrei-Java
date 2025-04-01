/*
 * Salariat.java
 *
 * Created on March 15, 2004, 3:18 PM
 */

package salarii;

/**
 *
 * @author  el011633
 */
public class Salariat extends Persoana {
    public String marca;
    public float pctVechime;
    public float pctPenalizare;
    public float salTarifar;
    protected float salariu;
    
    /** Creates a new instance of Salariat */
    public Salariat(String pCnp, String pNumePren, String pAdresa, String pMarca, float pPctVechime, float pSalTarifar) {
        super(pCnp, pNumePren, pAdresa);
        marca=pMarca;
        pctVechime=pPctVechime;
        salTarifar=pSalTarifar;
        System.out.println("Am initializat salariatul"+marca);
       
    }
 
     public float calculSalariu(){
            System.out.println("Calculez pentru Salariat"+marca);
            salariu=salTarifar*(1+pctVechime-pctPenalizare);
     return salariu;
     }
     public String toString(){
         return super.toString()+","+marca;
     }
     public boolean equals(Object obj){
         if(obj instanceof Salariat)
             return marca==((Salariat)obj).marca;
         else
             return false;
     }
     
}
