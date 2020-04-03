package Models;

import java.util.Scanner;

public class Proiecte {
    private String nume_proiect;
    private int bani_alocati;
    private int nr_oameni;
    private int anul_inceperii;
    private int luna_inceperii;
    private int ziua_inceperii;
    private boolean terminat;


    public Proiecte() {
        this.nume_proiect = "Unknown";
        this.nr_oameni = 0;
        this.anul_inceperii = 2020;
        this.luna_inceperii = 1;
        this.ziua_inceperii = 1;
        this.bani_alocati = 0;
        this.terminat = false;
    }

    public Proiecte(String nume_proiect, int bani_alocati, int nr_oameni, int anul_inceperii, int luna_inceperii, int ziua_inceperii, boolean terminat) {
        this.nume_proiect = nume_proiect;
        this.bani_alocati = bani_alocati;
        this.nr_oameni = nr_oameni;
        this.anul_inceperii = anul_inceperii;
        this.luna_inceperii = luna_inceperii;
        this.ziua_inceperii = ziua_inceperii;
        this.terminat = terminat;
    }

    public boolean isTerminat() {
        return terminat;
    }

    public void setTerminat(boolean terminat) {
        this.terminat = terminat;
    }

    public String getNume_proiect() {
        return nume_proiect;
    }

    public void setNume_proiect(String nume_proiect) {
        this.nume_proiect = nume_proiect;
    }

    public int getBani_alocati() {
        return bani_alocati;
    }

    public void setBani_alocati(int bani_alocati) {
        this.bani_alocati = bani_alocati;
    }

    public int getNr_oameni() {
        return nr_oameni;
    }

    public void setNr_oameni(int nr_oameni) {
        this.nr_oameni = nr_oameni;
    }

    public int getAnul_inceperii() {
        return anul_inceperii;
    }

    public void setAnul_inceperii(int anul_inceperii) {
        this.anul_inceperii = anul_inceperii;
    }

    public int getLuna_inceperii() {
        return luna_inceperii;
    }

    public void setLuna_inceperii(int luna_inceperii) {
        this.luna_inceperii = luna_inceperii;
    }

    public int getZiua_inceperii() {
        return ziua_inceperii;
    }

    public void setZiua_inceperii(int ziua_inceperii) {
        this.ziua_inceperii = ziua_inceperii;
    }

    @Override
    public String toString() {
        return "Proiecte{" +
                "nume_proiect='" + nume_proiect + '\'' +
                ", bani_alocati=" + bani_alocati +
                ", nr_oameni=" + nr_oameni +
                ", anul_inceperii=" + anul_inceperii +
                ", luna_inceperii=" + luna_inceperii +
                ", ziua_inceperii=" + ziua_inceperii +
                ", terminat=" + terminat +
                '}';
    }
}
