/*
 * AppAngajati.java
 *
 * Created on March 8, 2004, 3:30 PM
 */

/**
 *
 * @author  el010394
 */
public class AppAngajati {
    
    
    /** Creates a new instance of AppAngajati */
    public AppAngajati() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        float[] salariu={150000,125000,175000};
        int[] zile={19,17,16};
        Angajat angajat= new Angajat(1001,"Prim Angajat",zile);
        //angajat.zilelucrate=zile;
        angajat.salariuzi=salariu;
        System.out.println(angajat.getDateAngajat());
        System.out.println(angajat.getSalariuTotal());
        // TODO code application logic here
    }
    
}
