/*
 * AppAngajat.java
 *
 * Created on March 8, 2004, 3:29 PM
 */

/**
 *
 * @author  el011633
 */
import java.util.*;
public class AppAngajat {
    
    /** Creates a new instance of AppAngajat */
    public AppAngajat() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        float[] salariu={150000,125000,175000};
        int[] zile= {19,17,16};
        Angajat angajat=new Angajat(1001, "Primul Angajat",zile);
    //angajat.zileLucrate=zile;
 //   angajat.salariuzi=salariu;
        List salZi=new ArrayList(3);
        salZi.add(new Float(salariu[0]));
        salZi.add(new Float(salariu[1]));
        salZi.add(new Float(salariu[0]));
        angajat.salariuzi=salZi;
        System.out.println(angajat.getDateAngajat());
        System.out.println(angajat.getsalariuTotal());
    }
    
    }
    
