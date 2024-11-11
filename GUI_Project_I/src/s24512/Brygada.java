package s24512;

import java.util.ArrayList;
import java.util.List;

public class Brygada {

    String nazwa;
    Brygadzista brygadzista;
    public static List<Pracownik> listaPracownikowBrygady = new ArrayList<>();

    public Brygada(String nazwa , Brygadzista brygadzista){
        this.nazwa = nazwa;
        this.brygadzista = brygadzista;
    }

    public void dodajPracownika(Pracownik a){
        listaPracownikowBrygady.add(a);
    }
    public void dodajPracownika(List<Pracownik> list){
        listaPracownikowBrygady.addAll(list);
    }

    @Override
    public String toString() {
        return "-> Brygada{" +
                "nazwa='" + nazwa + '\'' +
                ", brygadzista=" + brygadzista +
                "'\n-> listaPracownikowBrygady=[" + listaPracownikowBrygady +
                "]}";
    }
}
