package Models;

import Contracts.CompanieContract;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Companie implements CompanieContract {
    private String nume_org;
    private int anul_infiintarii;
    private int ziua_infiintarii;
    private int luna_infiintarii;
    private Venit venit;
    private List<Sediu> sedii = new ArrayList<Sediu>();
    private List<Proiecte> proiecte = new ArrayList<>();

    public Companie() {
        this.nume_org = "Unknown";
        this.anul_infiintarii = 2020;
        this.luna_infiintarii = 1;
        this.ziua_infiintarii = 1;
    }

    public Companie(String nume_org, int anul_infiintarii, int ziua_infiintarii, int luna_infiintarii, Venit venit, List<Sediu> sedii, List<Proiecte> proiecte) {
        this.nume_org = nume_org;
        this.anul_infiintarii = anul_infiintarii;
        this.ziua_infiintarii = ziua_infiintarii;
        this.luna_infiintarii = luna_infiintarii;
        this.venit = venit;
        this.sedii = sedii;
        this.proiecte = proiecte;
        for (Sediu i: sedii) {
            venit.calculSalariiAngajati(i.getAngajati());
            venit.calculCosturiProiecte(this.proiecte);
        }
    }

    public void AfisareProiecte(){
        for (Proiecte i: proiecte){
            System.out.println(i.toString());
        }
    }

    public void AfisareAngajati (){

        Scanner input = new Scanner(System.in);
        int alegere;
        System.out.println("Doriti sa afisati toti angajatii companiei fara o anumita ordine?");
        do {
            System.out.println("\t 1 - Da");
            System.out.println("\t 0 - Nu");
            alegere = input.nextInt();
        }while( (alegere != 0)  &&  (alegere !=1) );

            if (alegere == 1){
                for (Sediu i: sedii) {
                    List<Angajat> temp = i.getAngajati();
                    for (Angajat j : temp) {
                        System.out.println(j.toString());
                    }
                }
            } else{
                System.out.println("Ati ales optiunea de a afisa angajatii trecand pe rand prin fiecare sediu.");
            for (Sediu i : sedii) {
                System.out.println("Angajatii sediului aflat in " + i.getLocatia());
                i.AfisareAngajati();
            }
        }
    }

    public void AfisareSedii (){
        for (Sediu i: sedii){
            System.out.println(i.getLocatia());
        }
    }

    public Sediu CreazaSediu (){
        Sediu new_sediu = new Sediu();
        Scanner input = new Scanner(System.in);
        String locatie, data_aparitie;
        System.out.println("Introduceti locatia sediului:");
        System.out.println("Spre exemplu 'Bucuresti' ");
        locatie = input.nextLine();
        System.out.println("Introduceti data aparitiei");
        System.out.println("Spre exemplu '1 mai 2020' ");
        data_aparitie = input.nextLine();

        new_sediu.setLocatia(locatie);
        new_sediu.setData_aparitiei(data_aparitie);

        return new_sediu;
    }

    public Proiecte CreazaProiect(){
        Proiecte new_project = new Proiecte();
        Scanner input = new Scanner(System.in);
        String nume;
        int bani, nr_p, an, zi, luna;
        System.out.println("Introduceti numele proiectului:");
        nume = input.nextLine();
        System.out.println("Introduceti cati bani sa fie alocati proiectului: ");
        bani = input.nextInt();
        System.out.println("Introduceti numarul de oameni care trebuie sa lucreze la proiect: ");
        nr_p = input.nextInt();
        System.out.println("Setati anul de incepere al proiectului: ");
        an = input.nextInt();
        System.out.println("Setati luna de incepere al proiectului: ");
        luna = input.nextInt();
        System.out.println("Setati ziua de incepere al proiectului: ");
        zi = input.nextInt();

        new_project.setNume_proiect(nume);
        new_project.setBani_alocati(bani);
        new_project.setNr_oameni(nr_p);
        new_project.setAnul_inceperii(an);
        new_project.setLuna_inceperii(luna);
        new_project.setZiua_inceperii(zi);

        return new_project;
    }

    @Override
    public void AdaugareProiect(Proiecte x) {
        proiecte.add(x);
        System.out.println("Proiectul " +x.getNume_proiect()+ " a fost adaugat cu succes!");
        this.ActualizeazaBaniProiecte();
    }

    @Override
    public void StergereProiect(Proiecte x) {
        if (proiecte.contains(x) == true) {
            proiecte.remove(x);
            this.ActualizeazaBaniProiecte();
        }
        else System.out.println("Proiectul " +x.getNume_proiect() + " nu a fost gasit!");
    }

    @Override
    public void AdaugareSediu (Sediu x){
        this.sedii.add(x);
        System.out.println("Sediul cu locatia " + x.getLocatia() + " a fost adaugat cu succes!");
    }


    public void ActualizeazaBaniProiecte (){
        venit.setCosturi_proiecte(0);
        venit.calculCosturiProiecte(this.proiecte);
    }

    private void ActualizeazaSalarii() {
        venit.setSalarii_angajati(0);
        for (Sediu i: sedii){
            venit.calculSalariiAngajati(i.getAngajati());
        }
    }

    @Override
    public void AngajareAngajat(Angajat x){
        if (sedii.size() == 0){
            System.out.println("Nu exista niciun sediu al acestei organizatii.");
            return;
        }

        if (x.getTip_angajat() == "Patron"){
            x.setPunct_lucru(sedii.get(0).getLocatia());
            sedii.get(0).AngajareAngajati(x);
            this.ActualizeazaSalarii();
            System.out.println("Patronul a fost adaugat cu succes!");
            return;
        }

        System.out.println("Sedii disponibile:");

        for (Sediu i: sedii){
            System.out.println(i.getLocatia());
        }


        System.out.println("Introduceti locatia unui sediu din cele prezentate mai sus.");
        Scanner input = new Scanner(System.in);
        String alegere = input.nextLine();
        int ok = 0;

        while (ok==0) {

            for (int i = 0; i < sedii.size(); i++) {
                if (sedii.get(i).getLocatia().equals(alegere)) {
                    sedii.get(i).AngajareAngajati(x);
                    this.ActualizeazaSalarii();
                    System.out.println("Angajatul " + x.getNume() + " a fost angajat cu succes!");
                    ok=1;
                    break;
                }
            }
            if (ok==0){
                System.out.println("Introduceti locatia unui sediu din cele prezentate mai sus va rog!");
                System.out.println("Pentru afisarea tuturor sediilor scrieti cuvantul 'sedii'. ");
                alegere = input.nextLine();
                if (alegere.equals("sedii")){
                    System.out.println("Sedii disponibile:");

                    for (Sediu i: sedii){
                        System.out.println(i.getLocatia());
                    }
                }
            }
        }
    }



    public void AfisarePatroni (){
        List <Angajat> temp = sedii.get(0).getAngajati();
        for (Angajat i: temp){
            if (i.getTip_angajat() == "Patron")
                System.out.println(i.toString());
        }
    }

    @Override
    public void ConcediereAngajat (String nume_angajat) {
        boolean ok = false;
        for (int i = 0; i<sedii.size(); i++) {
            ok = sedii.get(i).ConcediereAngajatNume(nume_angajat);
            if (ok == true){
                this.ActualizeazaSalarii();
                return;
            }
        }

        if (ok == false){
            System.out.println("Persoana " + nume_angajat + " nu a fost gasita!");
        }

    }

    public String getNume_org() {
        return nume_org;
    }

    public void setNume_org(String nume_org) {
        this.nume_org = nume_org;
    }

    public int getAnul_infiintarii() {
        return anul_infiintarii;
    }

    public void setAnul_infiintarii(int anul_infiintarii) {
        this.anul_infiintarii = anul_infiintarii;
    }

    public int getZiua_infiintarii() {
        return ziua_infiintarii;
    }

    public void setZiua_infiintarii(int ziua_infiintarii) {
        this.ziua_infiintarii = ziua_infiintarii;
    }

    public int getLuna_infiintarii() {
        return luna_infiintarii;
    }

    public void setLuna_infiintarii(int luna_infiintarii) {
        this.luna_infiintarii = luna_infiintarii;
    }

    public Venit getVenit() {
        return venit;
    }

    public void setVenit(Venit venit) {
        this.venit = venit;
    }

    public List<Sediu> getSedii() {
        return sedii;
    }

    public void setSedii(List<Sediu> sedii) {
        this.sedii = sedii;
    }

    public List<Proiecte> getProiecte() {
        return proiecte;
    }

    public void setProiecte(List<Proiecte> proiecte) {
        this.proiecte = proiecte;
    }
}
