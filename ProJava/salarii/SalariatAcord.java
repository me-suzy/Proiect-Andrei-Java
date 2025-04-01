/*
 * SalariatAcord.java
 *
 * Created on March 15, 2004, 3:38 PM
 */

package salarii;

/**
 *
 * @author  el011633
 */
public class SalariatAcord extends Salariat{
    public float pctRealizat;
    /** Creates a new instance of SalariatAcord */
    public SalariatAcord(String pCnp,String pNumePren,
    String pAdresa,String pMarca,float pPctVechime,float pSalTarifar, float pPctRealizat) {
    super(pCnp,pNumePren,pAdresa,pMarca,pPctVechime,pSalTarifar);
    pctRealizat=pPctRealizat;
    System.out.println("Am initializat SalariatAcord"+marca);
    
        
    }
    
    public float calculSlariu(){
        System.out.println("Calculez pt. SalariatAcord"+marca);
        salariu=super.calculSalariu()*pctRealizat;
        return salariu;
        
    }
}
