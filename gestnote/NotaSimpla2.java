/*
 * NotaSimpla2.java
 *
 * Created on April 3, 2004, 11:34 PM
 */

package gestnote;

/**
 *
 * @author  Cezar
 */
public class NotaSimpla2 extends AbstractNota{
    public boolean admis;
    public NotaSimpla2(boolean rezultat){
        this.admis=rezultat;
    }
       
    public double getNotaFin() {
        if(admis)
            return 10;
        else
            return 4;
    }
    
}
