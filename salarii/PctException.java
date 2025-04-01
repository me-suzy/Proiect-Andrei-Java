/*
 * PctException.java
 *
 * Created on March 29, 2004, 2:46 PM
 */

package salarii;

/**
 *
 * @author  el011355
 */
public class PctException extends Exception{
    
    /** Creates a new instance of PctException */
    public PctException(float pct) {
        super(pct+"nu se afla in intervalul 0:1");
    }
    
}
