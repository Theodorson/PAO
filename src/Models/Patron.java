package Models;

public class Patron extends Angajat {
    private float bani_investiti;

    public Patron() {
        super();
        this.tip_angajat = "Patron";
    }

    public Patron(String nume, int varsta, float salariu,float bani_investiti) {
        super(nume, varsta, salariu);
        this.bani_investiti = bani_investiti;
        this.tip_angajat = "Patron";
    }

    public Patron(String nume, int varsta, int an_angajare, int luna_angajare, int zi_angajare, float salariu, float prima, int numar_zile_concediu, String punct_lucru, float bani_investiti) {
        super(nume, varsta, an_angajare, luna_angajare, zi_angajare, salariu, prima, numar_zile_concediu, punct_lucru);
        this.bani_investiti = bani_investiti;
        this.tip_angajat = "Patron";
    }

    public float getBani_investiti() {
        return bani_investiti;
    }

    public void setBani_investiti(float bani_investiti) {
        this.bani_investiti = bani_investiti;
    }

    @Override
    public String toString() {
        return "Angajati{\n" +
                "nume=" + nume + "\n" +
                ", varsta=" + varsta + "\n" +
                ", data_angajare: " +  "an=" + an_angajare + " luna=" + luna_angajare + " zi=" + zi_angajare + "\n" +
                ", salariu=" + salariu + "\n" +
                ", prima=" + prima + "\n" +
                ", numar_zile_concediu=" + numar_zile_concediu + "\n" +
                ", bani_investiti=" + bani_investiti + "\n" +
                '}';
    }
}
