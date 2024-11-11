package s24512;

public class NotUniqueNameException extends Exception{

    public NotUniqueNameException(String nazwa_nie_jest_unikalna) {
    }

    public void showException(){
        System.out.println("Dzial nie jest unikalny");
    }
}
