/*
 * AppSalarii.java
 *
 * Created on March 22, 2004, 2:15 PM
 */

/**
 *
 * @author  el011259
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
        List lst=new ArrayList();
        try{
        lst.add(new Salariat("Cnp1","Salariat1",null,"1001",2F,4500000));
        lst.add(new SalariatAcord("Cnp1","Salariat2",null,"1002",0.2F,5500000,0.9F));
        }catch(Exception e){System.out.println("Eroare:"+e.getMessage());}
        Salariat s;
        for(int i=0;i<lst.size();i++){
            s=(Salariat)lst.get(i);
            System.out.println(s.calculSalariu());
        }
        
        // TODO code application logic here
    
    lst.add(new Persoana("Cnp3","Persoana1",null));
     System.out.println("Test toString()");
     for(int i=0;i<lst.size();i++)
      System.out.println(lst.get(i));
     System.out.println("test egalitate");
     Object o1=lst.get(0);
     Object o2=lst.get(1);
     System.out.println(o1.equals(o2));
     try{
     System.out.println(lst.get(3));
    }catch(IndexOutOfBoundsException e){System.out.println("dm.index:0-"+(lst.size()-1));}
    System.out.println("Intructiune dupa blocul Try");
    }
}

