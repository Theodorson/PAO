package Models;

import java.util.ArrayList;
import java.util.List;

public class Venit {

    private long salarii_angajati;
    private long costuri_proiecte;
    private long buget_anual;
    private long incasari;
    private long buget_special;



    public Venit() {
        this.salarii_angajati = 0;
        this.buget_anual = 0;
        this.incasari = 0;
        this.buget_special = 0;
        this.costuri_proiecte = 0;
    }

    public Venit(long buget_anual, long incasari, long buget_special) {
        this.salarii_angajati = 0;
        this.buget_anual = buget_anual;
        this.incasari = incasari;
        this.buget_special = buget_special;
        this.costuri_proiecte = 0;
    }

    public void calculSalariiAngajati(List <Angajat> v){
        for (Angajat i: v)
            this.salarii_angajati += i.getSalariu();
    }

    public void calculCosturiProiecte(List <Proiecte> v){
        for (Proiecte i: v)
            this.costuri_proiecte += i.getBani_alocati();
    }

    public void setSalarii_angajati(long salarii_angajati) {
        this.salarii_angajati = salarii_angajati;
    }

    public void setCosturi_proiecte(long costuri_proiecte) {
        this.costuri_proiecte = costuri_proiecte;
    }

    public long getSalarii_angajati() {
        return salarii_angajati;
    }

    public long getBuget_anual() {
        return buget_anual;
    }

    public void setBuget_anual(long buget_anual) {
        this.buget_anual = buget_anual;
    }

    public long getIncasari() {
        return incasari;
    }

    public long getBuget_special() {
        return buget_special;
    }

    public void setBuget_special(long buget_special) {
        this.buget_special = buget_special;
    }

    @Override
    public String toString() {
        return "Venit{" +
                "salarii_angajati=" + salarii_angajati +
                ", buget_anual=" + buget_anual +
                ", incasari=" + incasari +
                ", buget_special=" + buget_special +
                '}';
    }
}
