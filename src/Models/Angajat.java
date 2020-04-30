package Models;

import java.util.Comparator;
import java.util.Random;

public abstract class Angajat {
    protected String nume;
    protected int varsta;
    protected int luna_angajare;
    protected int an_angajare;
    protected int zi_angajare;
    protected float salariu;
    protected float prima;
    protected int numar_zile_concediu;
    protected String tip_angajat;
    protected String punct_lucru;

    public Angajat(){
    }

    public Angajat(String nume, int varsta, int an_angajare, int luna_angajare, int zi_angajare , float salariu, float prima, int numar_zile_concediu, String punct_lucru) {
        this.nume = nume;
        this.varsta = varsta;
        this.salariu = salariu;
        this.an_angajare = an_angajare;
        this.luna_angajare = luna_angajare;
        this.zi_angajare = zi_angajare;
        this.prima = prima;
        this.numar_zile_concediu = numar_zile_concediu;
        this.punct_lucru = punct_lucru;
    }

    public Angajat(String nume, int varsta, float salariu){
        this.nume = nume;
        this.varsta = varsta;
        this.salariu = salariu;
        Random value = new Random();
        this.an_angajare = value.nextInt((2020 - 2016) + 1) + 2016;
        this.luna_angajare = value.nextInt(12) + 1;
        this.zi_angajare = value.nextInt(31) + 1;
        this.numar_zile_concediu = 30;
    }

    public String getTip_angajat() {
        return tip_angajat;
    }

    public void setTip_angajat(String tip_angajat) {
        this.tip_angajat = tip_angajat;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public void setSalariu(float salariu) {
        this.salariu = salariu;
    }

    public void setPrima(float prima) {
        this.prima = prima;
    }

    public void setNumar_zile_concediu(int numar_zile_concediu) {
        this.numar_zile_concediu = numar_zile_concediu;
    }

    public String getNume() {
        return nume;
    }

    public int getVarsta() {
        return varsta;
    }

    public int getLuna_angajare() {
        return luna_angajare;
    }

    public void setLuna_angajare(int luna_angajare) {
        this.luna_angajare = luna_angajare;
    }

    public int getAn_angajare() {
        return an_angajare;
    }

    public void setAn_angajare(int an_angajare) {
        this.an_angajare = an_angajare;
    }

    public int getZi_angajare() {
        return zi_angajare;
    }

    public void setZi_angajare(int zi_angajare) {
        this.zi_angajare = zi_angajare;
    }

    public String getPunct_lucru() {
        return punct_lucru;
    }

    public void setPunct_lucru(String punct_lucru) {
        this.punct_lucru = punct_lucru;
    }

    public float getSalariu() {
        return salariu;
    }

    public float getPrima() {
        return prima;
    }

    public void MarireSalariu(float x){
        this.salariu += x;
        System.out.println("Salariu marit cu succes!");
    }

    public void MicsorareSalariu(float x){
        this.salariu -= x;
        System.out.println("Salariu micsorat cu succes!");
    }



    public int getNumar_zile_concediu() {
        return numar_zile_concediu;
    }

    @Override
    public String toString() {
        return "Angajati{\n" +
                "nume=" + nume + "\n" +
                ", varsta=" + varsta + "\n" +
                ", data_angajare: " +  "an=" + an_angajare + " luna=" + luna_angajare + " zi=" + zi_angajare + "\n" +
                ", salariu=" + salariu + "\n" +
                ", prima=" + prima + "\n" +
                ", numar_zile_concediu=" + numar_zile_concediu +
                '}';
    }


    public static Comparator<Angajat> alfabetic = new Comparator<Angajat>() {
        public int compare(Angajat s1, Angajat s2) {
            String a = s1.getNume();
            String b = s2.getNume();
            return a.compareTo(b);
        }};
    public static Comparator<Angajat> crescator_salariu = new Comparator<Angajat>() {
        public int compare(Angajat s1, Angajat s2) {
            if(s1.getSalariu()==s2.getSalariu())
                return 0;
            else if(s1.getSalariu()>s2.getSalariu())
                return 1;
            else
                return -1;
        }};
    public static Comparator<Angajat> descrescator_salariu = new Comparator<Angajat>() {
        public int compare(Angajat s1, Angajat s2) {
            if(s1.getSalariu()==s2.getSalariu())
                return 0;
            else if(s1.getSalariu()>s2.getSalariu())
                return -1;
            else
                return 1;
        }};
    public static Comparator<Angajat> crescator_angajare = new Comparator<Angajat>() {
        public int compare(Angajat s1, Angajat s2) {
            if(s1.getAn_angajare()==s2.getAn_angajare())
                return 0;
            else if(s1.getAn_angajare()>s2.getAn_angajare())
                return 1;
            else
                return -1;
        }};
    public static Comparator<Angajat> descrescator_angajare = new Comparator<Angajat>() {
        public int compare(Angajat s1, Angajat s2) {
            if(s1.getAn_angajare()==s2.getAn_angajare())
                return 0;
            else if(s1.getAn_angajare()>s2.getAn_angajare())
                return -1;
            else
                return 1;
        }};

}
