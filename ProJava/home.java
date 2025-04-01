public class home {
 public static void main(String[] arg) {
            String nume="Popescu";
        String prenume="Vasile";
        int[] zile_lucrate = new int[12];  //numarul de zile lucrate in fiecare luna a anului
        final float salariu_zilnic;
        float salariu_total, salariu_lunar;
        zile_lucrate[0]=20; //ianuarie
        zile_lucrate[1]=21;
        zile_lucrate[2]=23;
        zile_lucrate[3]=22;
        zile_lucrate[4]=24;
        zile_lucrate[5]=17;
        zile_lucrate[6]=21;
        zile_lucrate[7]=20;
        zile_lucrate[8]=20;
        zile_lucrate[9]=22;
        zile_lucrate[10]=21;
        zile_lucrate[11]=19;  //decembrie
        salariu_zilnic = 110000;  //stabilirea salariului zilnic
        //calculul salariilor lunare si a salariului anual total
        salariu_total = 0;
        for(int i=0;i<=11;i++) {
            salariu_lunar = salariu_zilnic * zile_lucrate[i];
            System.out.println("Salariul pe luna " + (i+1) + " este de " + (int)salariu_lunar);
            salariu_total = salariu_total + salariu_lunar;
        }
        System.out.println("Salariul anual total pentru " + nume +" " + prenume + " este de " + (int)salariu_total);
        //pe linia de mai sus se realizeaza conversia prin contractie
        //pentru a putea sa se afiseze valori inteligibile
    }
   }
