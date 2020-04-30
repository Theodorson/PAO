package Service;


import Models.*;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ReportService {

    private String filePath_reportData = "C:\\Users\\Duta Teodor\\Desktop\\Semestrul 2\\ProiectPAO\\repository\\ReportData.csv";


    public void initReportHeader_angajati() {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath_reportData))){
            bufferedWriter.append("NUME");
            bufferedWriter.append(",");
            bufferedWriter.append("VARSTA");
            bufferedWriter.append(",");
            bufferedWriter.append("DATA ANGAJARII");
            bufferedWriter.append(",");
            bufferedWriter.append("SALARIU");
            bufferedWriter.append(",");
            bufferedWriter.append("PRIMA SALARIU");
            bufferedWriter.append(",");
            bufferedWriter.append("NUMAR ZILE CONCEDIU");
            bufferedWriter.append(",");
            bufferedWriter.append("PUNCTUL DE LUCRU");
            bufferedWriter.append(",");
            bufferedWriter.append("TIP ANGAJAT");
            bufferedWriter.append(",");
            bufferedWriter.append("BANI INVESTITI");
            bufferedWriter.append("\n");
            bufferedWriter.close();
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void initReportHeader_proiecte() {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath_reportData))){
            bufferedWriter.append("NUME PROIECT");
            bufferedWriter.append(",");
            bufferedWriter.append("BANI ALOCATI");
            bufferedWriter.append(",");
            bufferedWriter.append("NUMAR ANGJATI ALOCATI");
            bufferedWriter.append(",");
            bufferedWriter.append("DATA INCEPERII");
            bufferedWriter.append(",");
            bufferedWriter.append("STAREA PROIECTULUI");
            bufferedWriter.append("\n");
            bufferedWriter.close();
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void initReportHeader_sedii() {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath_reportData))){
            bufferedWriter.append("LOCATIA ");
            bufferedWriter.append(",");
            bufferedWriter.append("DATA APARITIEI");
            bufferedWriter.append(",");
            bufferedWriter.append("NUMAR ANGAJATI GAZDUITI");
            bufferedWriter.append("\n");
            bufferedWriter.close();
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void writeDataToReport_Proiecte(Companie companie) {
        List <Proiecte> tempSedii = companie.getProiecte();
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath_reportData, true))){
            for (Proiecte i: tempSedii) {
                bufferedWriter.append("" + i.getNume_proiect());
                bufferedWriter.append(",");
                bufferedWriter.append("" + i.getBani_alocati() + "$");
                bufferedWriter.append(",");
                bufferedWriter.append("" + i.getNr_oameni());
                bufferedWriter.append(",");
                bufferedWriter.append(i.getLuna_inceperii() + "/" + i.getZiua_inceperii() + "/" + i.getAnul_inceperii());
                bufferedWriter.append(",");
                if (!i.isTerminat())
                bufferedWriter.append("IN DERULARE");
                else bufferedWriter.append("TERMINAT");
                bufferedWriter.append("\n");
            }
            bufferedWriter.close();
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void writeDataToReport_Sedii(Companie companie) {
        List <Sediu> tempSedii = companie.getSedii();
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath_reportData, true))){
            for (Sediu i: tempSedii) {
                bufferedWriter.append("" + i.getLocatia());
                bufferedWriter.append(",");
                bufferedWriter.append("" + i.getData_aparitiei());
                bufferedWriter.append(",");
                bufferedWriter.append("" + i.getNrAngajati());
                bufferedWriter.append("\n");
            }
            bufferedWriter.close();
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void writeDataToReport_Angajati(Companie companie, int ordine){
        List <Sediu> tempSedii = companie.getSedii();
        List <Angajat> tempAngajati = new ArrayList<>();

        for (Sediu i: tempSedii){
            tempAngajati.addAll(i.getAngajati());
        }

        if (ordine == 1){
            Collections.sort(tempAngajati, Comparator.comparing(Angajat::getNume));
        }
        else if (ordine == 2) {
            Collections.sort(tempAngajati, Comparator.comparing(Angajat::getSalariu).reversed());
        }


        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath_reportData,true))){
            for (Angajat i: tempAngajati) {
                bufferedWriter.append("" + i.getNume());
                bufferedWriter.append(",");
                bufferedWriter.append("" + i.getVarsta());
                bufferedWriter.append(",");
                bufferedWriter.append(i.getLuna_angajare() + "/" + i.getZi_angajare() + "/" + i.getAn_angajare());
                bufferedWriter.append(",");
                bufferedWriter.append("" + i.getSalariu() + "$");
                bufferedWriter.append(",");
                bufferedWriter.append("" + i.getPrima() + "$");
                bufferedWriter.append(",");
                bufferedWriter.append("" + i.getNumar_zile_concediu());
                bufferedWriter.append(",");
                bufferedWriter.append(i.getPunct_lucru());
                bufferedWriter.append(",");
                bufferedWriter.append("" + i.getTip_angajat());
                bufferedWriter.append(",");
                if (i.getTip_angajat() == "Patron"){
                    Patron x = (Patron) i;
                    bufferedWriter.append("" + x.getBani_investiti() + "$");
                }
                else bufferedWriter.append("-");
                bufferedWriter.append("\n");
            }
            bufferedWriter.close();
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public void readDataFromCsv() {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath_reportData))){
            String record;
            while((record = bufferedReader.readLine()) != null) {
                String [] recordData = record.split(",");
                for (int i = 0; i < recordData.length; i++)
                    System.out.print("|" +recordData[i] + "| ");
                System.out.println();
            }
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
