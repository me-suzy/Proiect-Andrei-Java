/*
 * NotaInvalidaException.java
 *
 * Created on April 4, 2004, 2:01 PM
 */

package gestnote;

/**
 *
 * @author  Cezar
 */
public class NotaInvalidaException extends Exception{
 
    /** Creates a new instance of NotaInvalidaException */
    public NotaInvalidaException(double nota) {
        super("NOTA"+nota+"Invalida:0<=nota<=10!!!");    
    }
    
}
