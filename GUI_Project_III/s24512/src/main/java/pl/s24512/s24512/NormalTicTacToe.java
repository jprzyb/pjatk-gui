package pl.s24512.s24512;

import java.util.ArrayList;
import java.util.List;

public class NormalTicTacToe {

    private List<Cell> list;
    private DoneState state;

    public NormalTicTacToe(int n) {
        this.state = DoneState.NULL;
        setList(n);
    }

    public DoneState getState() {
        return state;
    }

    public void setStateDraw() {

        for(int i=0 ; i<9 ; i++){
            list.get(i).getCellButton().setDisable(true);
            list.get(i).getCellButton().setText("D");
            list.get(i).getCellButton().setStyle("-fx-background-color: #00ffa0");
        }

        this.state = DoneState.DRAW;
    }
    public void setStateXWin(){
        for(int i=0 ; i<9 ; i++){
            list.get(i).getCellButton().setDisable(true);
            list.get(i).getCellButton().setText("X");
            list.get(i).getCellButton().setStyle("-fx-background-color: #00ff00");
        }
        this.state = DoneState.XWIN;
    }
    public void setStateOWin(){
        for(int i=0 ; i<9 ; i++){
            list.get(i).getCellButton().setDisable(true);
            list.get(i).getCellButton().setText("O");
            list.get(i).getCellButton().setStyle("-fx-background-color: #00ff00");
        }
        this.state = DoneState.OWIN;
    }
    public void setStateNull(){
        this.state = DoneState.NULL;
    }

    public List<Cell> getList() {
        return list;
    }

    private void setList(int n){
        list = new ArrayList<>();
        for(int i = 0 ; i<9 ; i++) list.add(new Cell( n , i));
    }
    public void check(){
        if(list.get(0).getState() == CellState.X && list.get(1).getState() == CellState.X && list.get(2).getState() == CellState.X) setStateXWin();
        if(list.get(3).getState() == CellState.X && list.get(4).getState() == CellState.X && list.get(5).getState() == CellState.X) setStateXWin();
        if(list.get(6).getState() == CellState.X && list.get(7).getState() == CellState.X && list.get(8).getState() == CellState.X) setStateXWin();
        if(list.get(0).getState() == CellState.X && list.get(3).getState() == CellState.X && list.get(6).getState() == CellState.X) setStateXWin();
        if(list.get(1).getState() == CellState.X && list.get(4).getState() == CellState.X && list.get(7).getState() == CellState.X) setStateXWin();
        if(list.get(2).getState() == CellState.X && list.get(5).getState() == CellState.X && list.get(8).getState() == CellState.X) setStateXWin();
        if(list.get(0).getState() == CellState.X && list.get(4).getState() == CellState.X && list.get(8).getState() == CellState.X) setStateXWin();
        if(list.get(2).getState() == CellState.X && list.get(4).getState() == CellState.X && list.get(6).getState() == CellState.X) setStateXWin();

        if(list.get(0).getState() == CellState.O && list.get(1).getState() == CellState.O && list.get(2).getState() == CellState.O) setStateOWin();
        if(list.get(3).getState() == CellState.O && list.get(4).getState() == CellState.O && list.get(5).getState() == CellState.O) setStateOWin();
        if(list.get(6).getState() == CellState.O && list.get(7).getState() == CellState.O && list.get(8).getState() == CellState.O) setStateOWin();
        if(list.get(0).getState() == CellState.O && list.get(3).getState() == CellState.O && list.get(6).getState() == CellState.O) setStateOWin();
        if(list.get(1).getState() == CellState.O && list.get(4).getState() == CellState.O && list.get(7).getState() == CellState.O) setStateOWin();
        if(list.get(2).getState() == CellState.O && list.get(5).getState() == CellState.O && list.get(8).getState() == CellState.O) setStateOWin();
        if(list.get(0).getState() == CellState.O && list.get(4).getState() == CellState.O && list.get(8).getState() == CellState.O) setStateOWin();
        if(list.get(2).getState() == CellState.O && list.get(4).getState() == CellState.O && list.get(6).getState() == CellState.O) setStateOWin();

        checkDraw();
    }
    public boolean rawCheck(){
        if(list.get(0).getState() == CellState.X && list.get(1).getState() == CellState.X && list.get(2).getState() == CellState.X) return true;
        if(list.get(3).getState() == CellState.X && list.get(4).getState() == CellState.X && list.get(5).getState() == CellState.X) return true;
        if(list.get(6).getState() == CellState.X && list.get(7).getState() == CellState.X && list.get(8).getState() == CellState.X) return true;
        if(list.get(0).getState() == CellState.X && list.get(3).getState() == CellState.X && list.get(6).getState() == CellState.X) return true;
        if(list.get(1).getState() == CellState.X && list.get(4).getState() == CellState.X && list.get(7).getState() == CellState.X) return true;
        if(list.get(2).getState() == CellState.X && list.get(5).getState() == CellState.X && list.get(8).getState() == CellState.X) return true;
        if(list.get(0).getState() == CellState.X && list.get(4).getState() == CellState.X && list.get(8).getState() == CellState.X) return true;
        if(list.get(2).getState() == CellState.X && list.get(4).getState() == CellState.X && list.get(6).getState() == CellState.X) return true;
        if(list.get(0).getState() == CellState.O && list.get(1).getState() == CellState.O && list.get(2).getState() == CellState.O) return true;
        if(list.get(3).getState() == CellState.O && list.get(4).getState() == CellState.O && list.get(5).getState() == CellState.O) return true;
        if(list.get(6).getState() == CellState.O && list.get(7).getState() == CellState.O && list.get(8).getState() == CellState.O) return true;
        if(list.get(0).getState() == CellState.O && list.get(3).getState() == CellState.O && list.get(6).getState() == CellState.O) return true;
        if(list.get(1).getState() == CellState.O && list.get(4).getState() == CellState.O && list.get(7).getState() == CellState.O) return true;
        if(list.get(2).getState() == CellState.O && list.get(5).getState() == CellState.O && list.get(8).getState() == CellState.O) return true;
        if(list.get(0).getState() == CellState.O && list.get(4).getState() == CellState.O && list.get(8).getState() == CellState.O) return true;
        if(list.get(2).getState() == CellState.O && list.get(4).getState() == CellState.O && list.get(6).getState() == CellState.O) return true;

        return false;
    }
    private void checkDraw(){
        int count = 0;

        for(int i=0 ; i<9 ; i++){
            if(list.get(i).getState() != CellState.E) count++;
        }
        if(count==9 && getState()==DoneState.NULL) setStateDraw();
    }

    public boolean checkIfAllAreEmpty(){
        int count=0;
        for(int i=0 ; i<9 ;i++){
            if(list.get(i).getState() == CellState.E) count++;
        }
        if(count==9)return true;
        return false;

    }
}
