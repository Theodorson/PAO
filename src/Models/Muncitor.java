package Models;

public class Muncitor extends Angajat {
    public Muncitor() {
        super();
        this.tip_angajat = "Muncitor";
    }

    public Muncitor(String nume, int varsta, float salariu) {
        super(nume, varsta, salariu);
        this.tip_angajat = "Muncitor";
    }

    public Muncitor(String nume, int varsta, int an_angajare, int luna_angajare, int zi_angajare , float salariu, float prima, int numar_zile_concediu , String punct_lucru) {
        super(nume, varsta,  an_angajare,  luna_angajare, zi_angajare , salariu, prima, numar_zile_concediu, punct_lucru);
        this.tip_angajat = "Muncitor";
    }
}
