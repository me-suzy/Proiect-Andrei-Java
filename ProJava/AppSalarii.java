/*
 * AppSalarii.java
 *
 * Created on March 22, 2004, 2:16 PM
 */

/**
 *
 * @author  el010394
 */
import java.util.*;
import salarii.*;
public class AppSalarii {
    
    /** Creates a new instance of AppSalarii */
    public AppSalarii() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List lst=new ArrayList();
        lst.add(new Salariat("CNP1","Salariat1",null,"1001",0.15F,4500000));
        lst.add(new SalariatAcord("CNP1","Salariat2",null,"1002",0.2F,5500000,0.9F));
        
        Salariat s;
        for(int i=0; i<lst.size();i++){
            s=(Salariat) lst.get(i);
            
            System.out.println(s.calculSalariu());
        }
        
        lst.add(new Persoana("CNP3","Persoana1",null));
        System.out.println("test toString");
        for(int i=0;i<lst.size();i++)
            System.out.println(lst.get(i));
        
        System.out.println("test egalitate");
        Object o1=lst.get(0);
        Object o2=lst.get(1);
        System.out.println(o1.equals(o2));
           
    }
    
}
