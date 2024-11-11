package pl.s24512.s24512;

import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;

public class UltimateTikTakToe {

    private List<NormalTicTacToe> list;
    private DoneState doneState;
    private static Label whoWonLabel;

    public UltimateTikTakToe(){
        doneState = DoneState.NULL;
        setList();
        whoWonLabel = new Label();

    }

    private void setList(){
        list = new ArrayList<>();
        for(int i=0 ; i<9 ; i++ ){
            list.add(new NormalTicTacToe(i));
        }
    }

    public DoneState getDoneState() {
        return doneState;
    }

    public void setStateXWin() {
        this.doneState = DoneState.XWIN;

        for(int i=0 ; i<9 ; i++){
            for(int j=0 ; j<9 ; j++){
                list.get(i).getList().get(j).getCellButton().setDisable(true);
            }
        }
        whoWonLabel.setDisable(false);
    }

    public void setStateOWin() {
        this.doneState = DoneState.OWIN;

        for(int i=0 ; i<9 ; i++){
            for(int j=0 ; j<9 ; j++){
                list.get(i).getList().get(j).getCellButton().setDisable(true);
            }
        }
        whoWonLabel.setVisible(true);
    }

    public void setStateDraw() {
        this.doneState = DoneState.DRAW;

        for(int i=0 ; i<9 ; i++){
            for(int j=0 ; j<9 ; j++){
                list.get(i).getList().get(j).getCellButton().setDisable(true);
            }
        }
        whoWonLabel.setVisible(true);
    }

    public void setStateNull() {
        this.doneState = DoneState.NULL;

        for(int i=0 ; i<9 ; i++){
            for(int j=0 ; j<9 ; j++){
                list.get(i).getList().get(j).getCellButton().setDisable(true);
            }
        }
        whoWonLabel.setVisible(false);
    }

    public void check(){

        /*
        list visualization
        0|1|2
        3|4|5
        6|7|8
         */

        //for X
        /*L->R*/if(list.get(0).getState() == DoneState.XWIN && list.get(1).getState() == DoneState.XWIN && list.get(2).getState() == DoneState.XWIN) setStateXWin();
        /*L->R*/if(list.get(3).getState() == DoneState.XWIN && list.get(4).getState() == DoneState.XWIN && list.get(5).getState() == DoneState.XWIN) setStateXWin();
        /*L->R*/if(list.get(6).getState() == DoneState.XWIN && list.get(7).getState() == DoneState.XWIN && list.get(8).getState() == DoneState.XWIN) setStateXWin();
        /*U->D*/if(list.get(0).getState() == DoneState.XWIN && list.get(3).getState() == DoneState.XWIN && list.get(6).getState() == DoneState.XWIN) setStateXWin();
        /*U->D*/if(list.get(1).getState() == DoneState.XWIN && list.get(4).getState() == DoneState.XWIN && list.get(7).getState() == DoneState.XWIN) setStateXWin();
        /*U->D*/if(list.get(2).getState() == DoneState.XWIN && list.get(5).getState() == DoneState.XWIN && list.get(8).getState() == DoneState.XWIN) setStateXWin();
        /*Diagonal L->R*/if(list.get(0).getState() == DoneState.XWIN && list.get(4).getState() == DoneState.XWIN && list.get(8).getState() == DoneState.XWIN) setStateXWin();
        /*Diagonal R->L*/if(list.get(2).getState() == DoneState.XWIN && list.get(4).getState() == DoneState.XWIN && list.get(6).getState() == DoneState.XWIN) setStateXWin();

        //for O
        /*L->R*/if(list.get(0).getState() == DoneState.OWIN && list.get(1).getState() == DoneState.OWIN && list.get(2).getState() == DoneState.OWIN) setStateOWin();
        /*L->R*/if(list.get(3).getState() == DoneState.OWIN && list.get(4).getState() == DoneState.OWIN && list.get(5).getState() == DoneState.OWIN) setStateOWin();
        /*L->R*/if(list.get(6).getState() == DoneState.OWIN && list.get(7).getState() == DoneState.OWIN && list.get(8).getState() == DoneState.OWIN) setStateOWin();
        /*U->D*/if(list.get(0).getState() == DoneState.OWIN && list.get(3).getState() == DoneState.OWIN && list.get(6).getState() == DoneState.OWIN) setStateOWin();
        /*U->D*/if(list.get(1).getState() == DoneState.OWIN && list.get(4).getState() == DoneState.OWIN && list.get(7).getState() == DoneState.OWIN) setStateOWin();
        /*U->D*/if(list.get(2).getState() == DoneState.OWIN && list.get(5).getState() == DoneState.OWIN && list.get(8).getState() == DoneState.OWIN) setStateOWin();
        /*Diagonal L->R*/if(list.get(0).getState() == DoneState.OWIN && list.get(4).getState() == DoneState.OWIN && list.get(8).getState() == DoneState.OWIN) setStateOWin();
        /*Diagonal R->L*/if(list.get(2).getState() == DoneState.OWIN && list.get(4).getState() == DoneState.OWIN && list.get(6).getState() == DoneState.OWIN) setStateOWin();
        //checking draw
        checkDraw();
    }

    private void checkDraw(){
        int count = 0;

        for(int i=0 ; i<9 ; i++){
            if(list.get(i).getState() != DoneState.NULL) count++;
        }
        if(count == 9 && doneState != DoneState.DRAW) setStateDraw();
    }

    public List<NormalTicTacToe> getList() {
        return list;
    }

}
