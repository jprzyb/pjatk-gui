package pl.s24512.s24512;

public class Cordinates {

    CordinatesState n,c;

    public CordinatesState getN() {
        return n;
    }

    public void setN(CordinatesState n) {
        this.n = n;
    }

    public CordinatesState getC() {
        return c;
    }

    public void setC(CordinatesState c) {
        this.c = c;
    }

    public int toInteger(){
        if(n== CordinatesState.NW) return 0;
        else if(n== CordinatesState.N ) return 1;
        else if(n== CordinatesState.NE) return 2;
        else if(n== CordinatesState.W ) return 3;
        else if(n== CordinatesState.C ) return 4;
        else if(n== CordinatesState.E ) return 5;
        else if(n== CordinatesState.SW) return 6;
        else if(n== CordinatesState.S ) return 7;
        else return 8;
    }

    public int cToInteger(){
        if(c== CordinatesState.NW) return 0;
        else if(c== CordinatesState.N ) return 1;
        else if(c== CordinatesState.NE) return 2;
        else if(c== CordinatesState.W ) return 3;
        else if(c== CordinatesState.C ) return 4;
        else if(c== CordinatesState.E ) return 5;
        else if(c== CordinatesState.SW) return 6;
        else if(c== CordinatesState.S ) return 7;
        else return 8;
    }

    public Cordinates(){
        n = CordinatesState.C;
        c = CordinatesState.C;
    }

    @Override
    public String toString() {
        return n.toString() + "/" + c.toString();
    }
}
