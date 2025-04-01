/*
 * FirstJava.java
 *
 * Created on March 1, 2004, 2:39 PM
 */

/**
 *
 * @author  el011633
 */
public class FirstJava {
    
    /** Creates a new instance of FirstJava */
    public FirstJava() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     //   int v1=11;
      //  int v2=11;
     //   System.out.println("v1=v2"+(v1==v2));
     //   Integer i1=new Integer(11);
    //    Integer i2=new Integer(11);
        //i2=i1;
   //     System.out.println("i1==i2"+(i1==i2));
  //     System.out.println("1i.equals(i2)"+i1.equals(i2));
        // TODO code application logic here
        
        //ARRAY
  int[] tablou=new int[10];       
  int k=0;
  while(k<tablou.length){
      tablou[k]=k*2;
      k=k+1;
  }
  for(int i=0; i<tablou.length; i++){
      System.out.println("tablou["+i+"]="+tablou[i]);
  }
    }
    
}
