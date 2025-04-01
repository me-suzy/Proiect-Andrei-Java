/*
 * NotaCompusa1.java
 *
 * Created on April 3, 2004, 11:45 PM
 */

package gestnote;

/**
 *
 * @author  Cezar
 */
public class NotaCompusa1 extends NotaSimpla1{
    protected double notaProiect;
    
    /** Creates a new instance of NotaCompusa1 */
    public NotaCompusa1(double notaEx, double notaPr) throws NotaInvalidaException {
        super(notaEx);
        if(notaPr>=0 && notaPr<=10)
            this.notaProiect=notaPr;
        else
            throw new NotaInvalidaException(notaPr);
    }
    public double getNotaFin(){
        return(this.notaProiect+this.notaExamen)/2;        
    }
    public void setNotaProiect(double nota) throws NotaInvalidaException{
        if(nota>=0 && nota<=10)
            this.notaProiect=nota;
        else
            throw new NotaInvalidaException(nota);
    }
    public double getNotaProiect(){return this.notaProiect;}
}
