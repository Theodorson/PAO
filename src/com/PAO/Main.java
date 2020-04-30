package com.PAO;


import Models.*;
import Service.CreatorCompany;
import Service.ReportService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Companie SoftBIN = new CreatorCompany().DefaultCompany(); ///Cu aceasta functie imi creez o companie initiala
        SoftBIN.setNume_org("SoftBIN");
        System.out.println("====================================================================================================================\n");

        ///Primele mesaje sunt din cauza functiei de creere a companiei initiale unde folosesc functiile de adaugare.


        Scanner input = new Scanner(System.in);

//        System.out.println(
//                "Bun venit! Ce doriti sa faceti in interiorul acestei companii?\n"+
//                        "\t Alegeti una dintre urmatoarele optiuni, tastand numarul potrivit.\n" +
//                        "\t 1 - afisarea tuturor angajatilor.\n" +
//                        "\t 2 - afisarea tuturor proiectelor.\n" +
//                        "\t 3 - afisarea locatiilor tuturor sediilor.\n" +
//                        "\t 4 - concedierea unui angajat.\n" +
//                        "\t 5 - angajarea unei persoane.\n" +
//                        "\t 6 - afisarea patronilor companiei.\n" +
//                        "\t 7 - afisarea bugetului alocat salariilor angajatilor.\n" +
//                        "\t 8 - crearea unui nou proiect.\n" +
//                        "\t 9 - crearea unui nou sediu.\n" +
//                        "\t orice valoare pentru a iesi din meniu."
//        );
//        boolean ok = true;
//        int alegere = input.nextInt();
//        do {
//            switch (alegere) {
//                case 1:
//                    SoftBIN.AfisareAngajati();
//                    break;
//                case 2:
//                    SoftBIN.AfisareProiecte();
//                    break;
//                case 3:
//                    SoftBIN.AfisareSedii();
//                    break;
//                case 4:
//                    System.out.println(" Ati ales optiunea de a concedia un angajat.");
//                    System.out.println(" Introduceti numele angajatului: ");
//                    String nume, prenume, Nume;
//                    nume = input.next();
//                    System.out.println(" Introduceti prenumele angajatului: ");
//                    prenume = input.next();
//                    Nume = nume + " " + prenume;
//                    SoftBIN.ConcediereAngajat(Nume);
//                    break;
//                case 5:
//                    System.out.println(" Ati ales optiunea de a angaja o noua persoana.");
//                    System.out.println(" Introduceti numele angajatului: ");
//                    nume = input.next();
//                    System.out.println(" Introduceti prenumele angajatului: ");
//                    prenume = input.next();
//                    Nume = nume + " " + prenume;
//                    System.out.println(" Introduceti varsta angajatului.");
//                    int varsta = input.nextInt();
//                    System.out.println(" Introduceti salariul angajatului.");
//                    float salariu = input.nextFloat();
//                    System.out.println(" Alegeti o valoare pentru a stabili pozitia angajatului: ");
//                    System.out.println("\t 1 - Patron. ");
//                    System.out.println("\t 2 - Sef. ");
//                    System.out.println("\t 3 - Manager. ");
//                    System.out.println("\t 4 - Muncitor. ");
//                    int tip_angajat = input.nextInt();
//                    switch (tip_angajat) {
//                        case 1:
//                            System.out.println("Introduceti o suma pe care patronul sa o investeasca in companie: ");
//                            float suma = input.nextFloat();
//                            Patron patron = new Patron(Nume, varsta, salariu, suma);
//                            SoftBIN.AngajareAngajat(patron);
//                            break;
//                        case 2:
//                            Sef sef = new Sef(Nume, varsta, salariu);
//                            SoftBIN.AngajareAngajat(sef);
//                            break;
//                        case 3:
//                            Manager manager = new Manager(Nume, varsta, salariu);
//                            SoftBIN.AngajareAngajat(manager);
//                            break;
//                        case 4:
//                            Muncitor muncitor = new Muncitor(Nume, varsta, salariu);
//                            SoftBIN.AngajareAngajat(muncitor);
//                            break;
//                    }
//                    break;
//                case 6:
//                    SoftBIN.AfisarePatroni();
//                    break;
//                case 7:
//                    System.out.println("Bugetul alocat salariilor angajatilor: " + SoftBIN.getVenit().getSalarii_angajati());
//                    break;
//                case 8:
//                    SoftBIN.AdaugareProiect(SoftBIN.CreazaProiect());
//                    break;
//                case 9:
//                    SoftBIN.AdaugareSediu(SoftBIN.CreazaSediu());
//                    break;
//                default:
//                    ok = false;
//
//            }
//            if (alegere == 0)
//                break;
//            System.out.println("\n");
//            System.out.println("===============================================");
//            System.out.println("Alegeti alta optiune: ");
//            System.out.println( "\t 1 - afisarea tuturor angajatilor.\n" +
//                                "\t 2 - afisarea tuturor proiectelor.\n" +
//                                "\t 3 - afisarea locatiilor tuturor sediilor.\n" +
//                                "\t 4 - concedierea unui angajat.\n" +
//                                "\t 5 - angajarea unei persoane.\n" +
//                                "\t 6 - afisarea patronilor companiei.\n" +
//                                "\t 7 - afisarea bugetului alocat salariilor angajatilor.\n" +
//                                "\t 8 - crearea unui nou proiect.\n" +
//                                "\t 9 - crearea unui nou sediu.\n" +
//                                "\t orice valoare pentru a iesi din meniu.");
//            alegere = input.nextInt();
//            System.out.println("===============================================");
//        }while (ok);

        ReportService rpservice = new ReportService();

        int alegere;
        System.out.println( "\t 1 - raportul angajatilor in ordine alfabetica.\n" +
                                "\t 2 - raportul angajatilor in ordine crescatoare dupa salariu.\n" +
                                "\t 3 - raportul angajatilor normala.\n" +
                                "\t 4 - raportul sediilor companiei.\n" +
                                "\t 5 - raportul proiectelor companiei.\n" +
                                "\t 5 - afisarea raportului curent pe ecran.\n" +
                                "\t 0 - pentru a iesi din meniu.");
        alegere = input.nextInt();
        while (alegere!=0){
            switch (alegere) {
                case 1:
                    try{
                    rpservice.initReportHeader_angajati();
                    rpservice.writeDataToReport_Angajati(SoftBIN, 1);
                    System.out.println("\n Raportul angajatilor a fost realizat cu succes.");
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        rpservice.initReportHeader_angajati();
                        rpservice.writeDataToReport_Angajati(SoftBIN, 2);
                        System.out.println("\n Raportul angajatilor a fost realizat cu succes.");
                    }
                    catch (Exception e){
                        e.printStackTrace();
                        }
                    break;
                case 3:
                    try {
                        rpservice.initReportHeader_angajati();
                        rpservice.writeDataToReport_Angajati(SoftBIN, 0);
                        System.out.println("\n Raportul angajatilor a fost realizat cu succes.");
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    try {
                        rpservice.initReportHeader_sedii();
                        rpservice.writeDataToReport_Sedii(SoftBIN);
                        System.out.println("\n Raportul sediilor a fost realizat cu succes.");
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    try {
                        rpservice.initReportHeader_proiecte();
                        rpservice.writeDataToReport_Proiecte(SoftBIN);
                        System.out.println("\n Raportul proiectelor a fost realizat cu succes.");
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    try {
                        rpservice.readDataFromCsv();
                        System.out.println("\n Citirea din raport a fost realizata cu succes.");
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("\n Ati introdus un alt numar decat cel cerut.");
                    break;
            }
       try {
           alegere = input.nextInt();
       }
       catch (Exception e){
           e.printStackTrace();
           break;
       }
        }

    }
}
