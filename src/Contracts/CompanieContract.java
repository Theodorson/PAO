package Contracts;

import Models.Proiecte;
import Models.Sediu;
import Models.Angajat;


public interface CompanieContract {

    void AdaugareSediu (Sediu x);
    void AngajareAngajat (Angajat x);
    void ConcediereAngajat (String x);
    void AdaugareProiect (Proiecte x);
    void StergereProiect (Proiecte x);
}
