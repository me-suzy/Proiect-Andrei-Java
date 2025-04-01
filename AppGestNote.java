/*
 * AppGestNote.java
 *
 * Created on April 5, 2004, 2:27 PM
 */
import gestnote.*;
import java.util.*;
/**
 *
 * @author  el011355
 */
public class AppGestNote {
    
    /** Creates a new instance of AppGestNote */
    public AppGestNote() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception{
        Student s1=new Student("Student 1","1");
        Student s2=new Student("Student 2","2");
        List Studenti=new ArrayList();
        Studenti.add(s1);
        Studenti.add(s2);
        
        Disciplina[] disc={new Disciplina("Disc1",4),new Disciplina("Disc2",7), new Disciplina("disc3",5)};
        
        DisciplinaNota[] discnota1={new DisciplinaNota(disc[0],new NotaSimpla2(true)), new DisciplinaNota(disc[1], new NotaCompusa1(7,10)),new DisciplinaNota(disc[2], new NotaSimpla1(8))};
        DisciplinaNota[] discnota2={new DisciplinaNota(disc[0],new NotaSimpla2(true)), new DisciplinaNota(disc[1], new NotaCompusa1(7,10)),new DisciplinaNota(disc[2], new NotaSimpla1(8))};
        s1.note=discnota1;
        s2.note=discnota2;
        for(int i=0;i<Studenti.size();i++){
            Student stud=(Student)Studenti.get(i);
        System.out.println(stud+"media"+stud.calculMedia());
        }
        
        
        // TODO code application logic here
    }
    
}
