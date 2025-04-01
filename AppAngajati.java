/*
 * AppAngajati.java
 *
 * Created on March 8, 2004, 3:29 PM
 */

/**
 *
 * @author  el011259
 */
import java.util.*;
public class AppAngajati {
    
    /** Creates a new instance of AppAngajati */
    public AppAngajati() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        float[] salariu= {150000,125000,175000};
        int[]zile={19,17,16};
        Angajat angajat=new Angajat(1001,"Prim Angajat ",zile );
        angajat.zileLucrate=zile;
        //angajat.salariuZi= salariu;
        List salZi= new ArrayList(3);
        salZi.add(new Float(salariu[0]));
        salZi.add(new Float(salariu[1]));
         salZi.add(new Float(salariu[0]));
         angajat.salariuZi=salZi;
       System.out.println(angajat.getDataAngajat());
        System.out.println(angajat.getSalariuTotal());
       
        // TODO code application logic here
    }
    
}
