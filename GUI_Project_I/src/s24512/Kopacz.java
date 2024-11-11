package s24512;


public class Kopacz extends Pracownik{

    String narzedzie;

    public Kopacz(String narzedzie , String imie , String nazwisko , String dataUrodzenia , String dzial){

        super(imie,nazwisko,dataUrodzenia,dzial);
        this.narzedzie = narzedzie;
    }

    public Kopacz(String narzedzie){
        this.narzedzie = narzedzie;
    }
    public Kopacz(){
        super();
        this.narzedzie = "lopata";
    }

    @Override
    public String toString() {
        return "Kopacz{" +
                "narzedzie='" + narzedzie + '\'' +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", dataUrodzenia='" + dataUrodzenia + '\'' +
                ", dzial='" + dzial + '\'' +
                '}';
    }

    @Override
    public int compareTo(Pracownik o) {
        return super.compareTo(o);
    }
}
