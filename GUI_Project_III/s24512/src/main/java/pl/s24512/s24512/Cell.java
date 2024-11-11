package pl.s24512.s24512;

import javafx.scene.control.Button;

public class Cell {

    private CellState state;
    public Cell(int n , int c) {
        setCordinates(n,c);
        state = CellState.E;
        setButton(n,c);
    }
    private Button button;
    private Cordinates cordinates;

    public CellState getState() {
        return state;
    }

    public void setStateX() {
        this.state = CellState.X;
        button.setText(state.toString());
        button.setStyle("-fx-background-color: #2d7066");
    }
    public void setStateO() {
        this.state = CellState.O;
        button.setText(state.toString());
        button.setStyle("-fx-background-color: #4f756f");
    }
    public void setStateE() {
        this.state = CellState.E;
        button.setText(getState().toString());
        button.setStyle(null);
    }

    private void setButton(int n , int c){

        button = new Button(getState().toString());
        button.setPrefSize(50,50);
        button.setText( n + "|" + c);
        button.setFont(MyFont.getButtonFont());

        button.setOnAction(actionEvent -> {
            HelloApplication.addMove(cordinates);
            if(button.getText().equals(CellState.E.toString())){
                if(HelloApplication.whoMoves) setStateO();
                else setStateX();
            }
            HelloApplication.makeMove(cordinates);
            HelloApplication.setWhoMoves();
            button.setDisable(true);
        });

    }

    public Button getCellButton(){
        return button;
    }

    private void setCordinates(int n , int c){
        cordinates = new Cordinates();
        if(n==0) cordinates.setN(CordinatesState.NW);
        if(n==1) cordinates.setN(CordinatesState.N);
        if(n==2) cordinates.setN(CordinatesState.NE);
        if(n==3) cordinates.setN(CordinatesState.W);
        if(n==4) cordinates.setN(CordinatesState.C);
        if(n==5) cordinates.setN(CordinatesState.E);
        if(n==6) cordinates.setN(CordinatesState.SW);
        if(n==7) cordinates.setN(CordinatesState.S);
        if(n==8) cordinates.setN(CordinatesState.SE);

        if(c==0) cordinates.setC(CordinatesState.NW);
        if(c==1) cordinates.setC(CordinatesState.N);
        if(c==2) cordinates.setC(CordinatesState.NE);
        if(c==3) cordinates.setC(CordinatesState.W);
        if(c==4) cordinates.setC(CordinatesState.C);
        if(c==5) cordinates.setC(CordinatesState.E);
        if(c==6) cordinates.setC(CordinatesState.SW);
        if(c==7) cordinates.setC(CordinatesState.S);
        if(c==8) cordinates.setC(CordinatesState.SE);
    }

    public void symulateClick(){
        HelloApplication.setWhoMoves();
        HelloApplication.addMove(cordinates);
        HelloApplication.setWhoMoves();
        if(button.getText().equals(CellState.E.toString())){
            if(!HelloApplication.whoMoves){
                setStateO();
            }
            else {
                setStateX();
            }
            button.setDisable(true);
        }
        HelloApplication.setWhoMoves();
    }

    public Cordinates getCordinates(){
        return cordinates;
    }
}
