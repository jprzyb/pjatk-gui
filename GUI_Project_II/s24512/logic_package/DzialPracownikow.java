package logic_package;

import java.io.Serializable;

public class DzialPracownikow implements Serializable {

    String nazwa;

    public DzialPracownikow(){
        setNazwa("ogolny");
    }

    public DzialPracownikow(String nazwa){
        setNazwa(nazwa);
    }

    public void setNazwa(String nazwa){
        if(Listy.nazwyDzialow.contains(nazwa)){
        nadajNazwe(nazwa);
        }else this.nazwa = nazwa;
        Listy.nazwyDzialow.add(this.nazwa);
    }

    public String getNazwa() {
        return nazwa;
    }

    @Override
    public String toString() {
        return "DzialPracownikow{" +
                "nazwa='" + nazwa + '\'' +
                '}';
    }

    private void nadajNazwe(String nazwa){
        boolean war = true;
        for(int i = 0 ; war ; i++){
            String temp = nazwa+i;
            if(!Listy.nazwyDzialow.contains(temp)){
                this.nazwa = nazwa+i;
                war=false;
            }
            temp = nazwa;
        }
    }

}
