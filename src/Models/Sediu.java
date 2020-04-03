package Models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.*;
import java.util.Scanner;

public class Sediu {
    private String locatia;
    private String data_aparitiei;
    private List<Angajat> angajati = new ArrayList<Angajat>();

    public Sediu(){
        this.locatia = "Unknown";
        this.data_aparitiei = "1 ianuarie 2020";
    }

    public Sediu(String locatia, String data_aparitiei) {
        this.locatia = locatia;
        this.data_aparitiei = data_aparitiei;
    }

    public Sediu(String locatia, String data_aparitiei, List <Angajat> data) {
        this.locatia = locatia;
        this.data_aparitiei = data_aparitiei;
        this.angajati = data;
    }

    public void AngajareAngajati(Angajat x){
        angajati.add(x);
        System.out.println("Angajatul " + x.getNume() + " a fost angajat cu succes!");
    }

    public void ConcediereAngajati(Angajat x){
        for (Angajat i: angajati) {
            if (i == x) {
                angajati.remove(x);
                System.out.println("Angajatul " + x.getNume() + " a fost concediat cu succes!");
                return;
            }
        }
    }

    public boolean ConcediereAngajatNume (String nume){
        for (Angajat i: angajati){
            if (i.getNume().equals(nume)) {
                this.ConcediereAngajati(i);
                return true;
            }
        }
        return false;
    }

    public int getNrAngajati (){
        return angajati.size();
    }

    public void AfisareAngajati(){

        if (this.getNrAngajati() == 0){
            System.out.println("Nu exista niciun angajat in acest sediu.");
            return;
        }
        Scanner input = new Scanner(System.in);
        int alegere = 0;
        do {
        System.out.println("Introduceti o valoare pentru a decide afisarea angajatilor: \n" +
                        "\t 1 - afisare angajati sortati alfabetic." + "\n" +
                        "\t 2 - afisare angajati sortati crescator dupa salariu." + "\n" +
                        "\t 3 - afisare angajati sortati descrescator dupa salariu." + "\n" +
                        "\t 4 - afisare angajati sortati crescator dupa anul angajarii." + "\n" +
                        "\t 5 - afisare angajati sortati descrescator dupa anul angajarii." + "\n" +
                        "\t 6 - afisare angajati default." + "\n" +
                        "\t 0 - terminati afisarea angajatilor."
                );

        alegere = input.nextInt();
        switch (alegere) {
            case 1:
                Collections.sort(angajati, Angajat.alfabetic);
                for (Angajat i : angajati)
                    System.out.println(i.toString());
                break;
            case 2:
                Collections.sort(angajati, Angajat.crescator_salariu);
                for (Angajat i : angajati)
                    System.out.println(i.toString());
                break;
            case 3:
                Collections.sort(angajati, Angajat.descrescator_salariu);
                for (Angajat i : angajati)
                    System.out.println(i.toString());
                break;
            case 4:
                Collections.sort(angajati, Angajat.crescator_angajare);
                for (Angajat i : angajati)
                    System.out.println(i.toString());
                break;
            case 5:
                Collections.sort(angajati, Angajat.descrescator_angajare);
                for (Angajat i : angajati)
                    System.out.println(i.toString());
                break;
            case 6:
                for (Angajat i : angajati)
                    System.out.println(i.toString());
                break;
            default:
                if (alegere!=0)
                System.out.println("Ati introdus o valoare eronata!!!\n");
        }
        }
        while (alegere!=0);


    }

    public List<Angajat> getAngajati() {
        return angajati;
    }

    public String getLocatia() {
        return locatia;
    }

    public void setLocatia(String locatia) {
        this.locatia = locatia;
    }

    public String getData_aparitiei() {
        return data_aparitiei;
    }

    public void setData_aparitiei(String data_aparitiei) {
        this.data_aparitiei = data_aparitiei;
    }


}
