package logic_package;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class Zlecenie implements Serializable {

    private List<Praca> listaPrac;
    private Brygada brygada;
    private StanZlecenia stanZlecenia;
    private LocalDateTime dataUtworzenia , dataZakonczenia;

    public Zlecenie(Brygada brygada, StanZlecenia stanZlecenia, LocalDateTime dataZakonczenia) {
        this.brygada = brygada;
        this.stanZlecenia = stanZlecenia;
        this.dataUtworzenia = LocalDateTime.now();
        this.dataZakonczenia = dataZakonczenia;
    }

    public Zlecenie() {
        this.brygada = new Brygada();
        this.stanZlecenia = StanZlecenia.NIEPLANOWANE;
        this.dataUtworzenia = LocalDateTime.now();
        this.dataZakonczenia = null;
    }

    public Brygada getBrygada() {
        return brygada;
    }

    public StanZlecenia getStanZlecenia() {
        return stanZlecenia;
    }

    public LocalDateTime getDataUtworzenia() {
        return dataUtworzenia;
    }

    public LocalDateTime getDataZakonczenia() {
        return dataZakonczenia;
    }

    public void setBrygada(Brygada brygada) {
        this.brygada = brygada;
    }

    public void setStanZlecenia(StanZlecenia stanZlecenia) {
        this.stanZlecenia = stanZlecenia;
    }

    public void setDataZakonczenia(LocalDateTime dataZakonczenia) {
        this.dataZakonczenia = dataZakonczenia;
    }

    public List<Praca> getListaPrac() {
        return listaPrac;
    }

    public void addToList(Praca praca){
        listaPrac.add(praca);
    }

    public void removeFromList(Praca praca){
        listaPrac.remove(praca);
    }

    @Override
    public String toString() {
        return "Zlecenie{" +
                "listaPrac=" + listaPrac +
                ", brygada=" + brygada +
                ", stanZlecenia=" + stanZlecenia +
                ", dataUtworzenia=" + dataUtworzenia +
                ", dataZakonczenia=" + dataZakonczenia +
                '}';
    }
}
