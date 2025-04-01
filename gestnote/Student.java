/*
 * Student.java
 *
 * Created on April 3, 2004, 10:33 PM
 */

package gestnote;

/**
 *
 * @author  Cezar
 */
public class Student {
    public String nume;
    public String grupa;
    public DisciplinaNota[]note;
    
    public Student(String name, String gr) {
        this.nume=name;
        this.grupa=gr;
    }
    public double calculMedia(){
        double media=0;
        boolean restante=false;
        for(int i=0;i<note.length;i++)
            if (note[i].getNotaFinala()<5)
            {restante=true;
             break;
            }
            else
                media=media+note[i].getNotaFinala();
        if(!restante)
            return media/note.length;
        else
            return 4;
        }
    public String toString(){
        String text=this.nume+"->note;";
        for(int i=0;i<note.length;i++)
            text=text+note[i].toString()+",";
        return text;
    }
 }
    
