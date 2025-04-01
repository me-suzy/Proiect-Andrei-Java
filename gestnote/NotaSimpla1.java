/*
 * NotaSimpla1.java
 *
 * Created on April 3, 2004, 11:21 PM
 */

package gestnote;

/**
 *
 * @author  Cezar
 */
public class NotaSimpla1 extends AbstractNota{
    protected double notaExamen;
    public NotaSimpla1(){}
    public NotaSimpla1(double nota)throws NotaInvalidaException{
        if(nota>=0 && nota<=10)
            this.notaExamen=nota;
        else
            throw new NotaInvalidaException(nota);
    }
    public double getNotaFin() {
        return this.notaExamen;
    }
    public void setNotaExamen(double nota) throws NotaInvalidaException{
        if(nota>=0 && nota<=10)
            this.notaExamen=nota;
        else
            throw new NotaInvalidaException(nota);        
    }
    public double getNotaExamen(){return this.notaExamen;}
    
}
