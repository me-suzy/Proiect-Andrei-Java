/*
 * DisciplinaNota.java
 *
 * Created on April 3, 2004, 10:46 PM
 */

package gestnote;

/**
 *
 * @author  Cezar
 */
public class DisciplinaNota {
    public Disciplina disciplina;
    private AbstractNota objNota;
    /** Creates a new instance of DisciplinaNota */
    public DisciplinaNota(Disciplina disc, AbstractNota nota){
        this.disciplina=disc;
        this.objNota=nota;               
    }
    public void setNota(AbstractNota nota){
        this.objNota=nota;        
    }
    public AbstractNota getNota(){
        return this.objNota;
    }
    public double getNrCredite(){
        return this.disciplina.nrCredite*this.objNota.getNotaFin();
    }
    public double getNotaFinala(){
        return this.objNota.getNotaFin();        
    }
    public String toString(){
        return this.disciplina.denumire+"("+this.getNotaFinala()+")";
    }
}
