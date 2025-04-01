/*
 * Persoana.java
 *
 * Created on March 15, 2004, 2:54 PM
 */

package salarii;

/**
 *
 * @author  el011633
 */
public class Persoana {
    public String cnp;
        public String numePren;
        public String adresa;
    /** Creates a new instance of Persoana */
    public Persoana(String pCnp, String pNumePren, String pAdresa) {
        cnp=pCnp;
        numePren=pNumePren;
        adresa=pAdresa;
        System.out.println("Am initializat persoana"+numePren);
       
    }
    public String toString(){
        return numePren;
    }
    public boolean equals(Object obj){
        if(obj instanceof Persoana)
            return cnp==((Persoana)obj).cnp;
        else
            return false;
    }
}
