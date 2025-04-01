/*
 * SalariatAcord.java
 *
 * Created on March 15, 2004, 3:37 PM
 */

package salarii;

/**
 *
 * @author  el011259
 */
public class SalariatAcord extends Salariat{
    public float pctRealizat;
    
    /** Creates a new instance of SalariatAcord */
    public SalariatAcord(String pCnp,String pNumePren,String pAdresa,String pMarca,float pPctVechime,float pSalTarifar,float pPctRealizat) {
        super(pCnp,pNumePren,pAdresa,pMarca,pPctVechime,pSalTarifar);
        pctRealizat=pPctRealizat;
        System.out.println("Am initializat salariatul "+marca);
    }
     public float calculSalariu(){
        System.out.println("Calculez pentru SalariatAcord "+marca);
        salariu= super.calculSalariu() * pctRealizat;
     return salariu;
}
}