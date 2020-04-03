package Service;

import Models.*;

import java.util.ArrayList;
import java.util.List;

public class CreatorCompany {
    public Companie DefaultCompany(){

        /// creare angajati
        Patron Feitan = new Patron("Duta Teodor",20,2020,1,12,500000,0,30,"Antarctica",450.590f);
        Sef Dinu = new Sef("Dinescu Alexandru",21,2020,5,4,4000,20,15,"Bucuresti");
        Manager Sandru = new Manager("Sandru Marius", 20, 2020, 5, 5, 3000, 10, 10, "Timisoara");
        Muncitor Sevciuc = new Muncitor("Sevciuc Ionut", 20, 2020, 6, 5, 2000, 5, 10, "Pitesti");
        Muncitor Ilie = new Muncitor("Ilie Ionut", 20, 2020, 6, 10, 2000, 7, 11, "Pitesti");
        Muncitor Aurel = new Muncitor("Popescu Aurel", 30, 2020, 9, 4, 1990, 3, 9, "Timisoara");
        Muncitor Costel = new Muncitor("Dorohoi Costel", 35, 2020, 8, 20, 1500, 0, 5, "Bucuresti");


        /// creare sedii
        Sediu Antarctica = new Sediu("Antarctica", "30 decembrie 2019");
        Sediu Bucuresti = new Sediu("Bucuresti", "25 februarie 2020");
        Sediu Timisoara = new Sediu("Timisoara", "6 mai 2020");
        Sediu Pitesti = new Sediu("Pitesti", "12 iunie 2020");

        /// adaugarea angajatiilor in sedii
        Antarctica.AngajareAngajati(Feitan);
        Bucuresti.AngajareAngajati(Dinu);
        Bucuresti.AngajareAngajati(Costel);
        Timisoara.AngajareAngajati(Sandru);
        Timisoara.AngajareAngajati(Aurel);
        Pitesti.AngajareAngajati(Sevciuc);
        Pitesti.AngajareAngajati(Ilie);


        List <Sediu> sedii_companie = new ArrayList<Sediu>();
        sedii_companie.add(Antarctica);
        sedii_companie.add(Bucuresti);
        sedii_companie.add(Timisoara);
        sedii_companie.add(Pitesti);


        Venit venit = new Venit(90000,999999,495999);


        /// creare proiecte
        Proiecte Chatinatorul = new Proiecte("Chatinatorul", 5000, 2, 2020, 5, 9, false);
        Proiecte AutoChess = new Proiecte("Auto-Chess", 32000, 4, 2021, 2, 15, false);
        Proiecte Risk = new Proiecte("Risk", 48000, 8, 2022, 5, 5, false);

        List <Proiecte> proiecte_companie = new ArrayList<Proiecte>();
        proiecte_companie.add(Chatinatorul);
        proiecte_companie.add(AutoChess);
        proiecte_companie.add(Risk);


        Companie Default = new Companie("Default",2020,5,1,venit,sedii_companie,proiecte_companie);


        return Default;
    }




}
