package logic_package;

import java.io.Serializable;
import java.util.List;

public class Brygada implements Serializable {

    private String nazwa;
    private Brygadzista brygadzista;
    private List<Pracownik> pracownikList;

    public Brygada(String nazwa, Brygadzista brygadzista) {
        this.nazwa = nazwa;
        this.brygadzista = brygadzista;
    }

    public Brygada() {

        if (checkNazwa("brygada")) {
            this.nazwa = "brygada";
        } else {
            for (int i = 0; i < 1000; i++) {
                if (checkNazwa("brygada" + i)) {
                    this.nazwa = "brygada" + i;
                }
            }
        }
        this.brygadzista = new Brygadzista();

    }

    public String getNazwa() {
        return nazwa;
    }

    public Brygadzista getBrygadzista() {
        return brygadzista;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setBrygadzista(Brygadzista brygadzista) {
        this.brygadzista = brygadzista;
    }

    @Override
    public String toString() {
        return "Brygada{" +
                "nazwa='" + nazwa + '\'' +
                ", brygadzista=" + brygadzista +
                '}';
    }

    public void dodajPracownika(Pracownik pracownik){
        pracownikList.add(pracownik);
    }

    public boolean checkNazwa(String nazwa){
        if(Listy.nazwyBrygad.contains(nazwa)) return false;
        return true;
    }

}
