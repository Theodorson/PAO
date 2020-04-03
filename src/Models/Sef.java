package Models;

public class Sef extends Angajat {

     public Sef() {
         super();
         this.tip_angajat = "Sef sediu";
     }

    public Sef(String nume, int varsta, float salariu) {
        super(nume, varsta, salariu);
        this.tip_angajat = "Sef sediu";
    }

    public Sef(String nume, int varsta, int an_angajare, int luna_angajare, int zi_angajare , float salariu, float prima, int numar_zile_concediu, String punct_lucru) {
        super(nume, varsta, an_angajare, luna_angajare, zi_angajare, salariu, prima, numar_zile_concediu, punct_lucru);
        this.tip_angajat = "Sef sediu";
    }
}
