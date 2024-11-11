package s24512;


public class Specjalista extends Pracownik{

    String specjalizacja;

    public Specjalista(String specjalizacja , String imie , String nazwisko , String dataUrodzenia , String dzial){

        super(imie,nazwisko,dataUrodzenia,dzial);
        this.specjalizacja = specjalizacja;
    }

    public Specjalista(String specjalizacja){
        this.specjalizacja = specjalizacja;
    }
    public Specjalista(){
        super();
        this.specjalizacja = "lopata automatyczna";
    }

    @Override
    public String toString() {
        return "Specjalista{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", dataUrodzenia='" + dataUrodzenia + '\'' +
                ", dzial='" + dzial + '\'' +
                ", specjalizacja='" + specjalizacja + '\'' +
                '}';
    }

    @Override
    public int compareTo(Pracownik o) {
        return super.compareTo(o);
    }
}
