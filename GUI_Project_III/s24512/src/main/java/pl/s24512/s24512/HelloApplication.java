package pl.s24512.s24512;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {



    private static UltimateTikTakToe uTTT;
    Scene scene;
    static GridPane leftPane;
    static int listCord = 15 , moveCount=0;
    static ListView<String> chooseList, difficultyList, whoGoesFirstList;
    static ListView<String> moveList;
    static ObservableList<String> moveItems;
    Button startButton;
    public static boolean whoMoves = false; //X -> false ; O -> true
    private static Label wonLabel;
    private static String withWho , firstMove , difficulty;

    @Override
    public void start(Stage stage) throws IOException {

        setLeftPane();
        scene = new Scene(leftPane, 940, 670);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("Ultimate Tic Tac Toe");
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }


    private void setLeftPane(){
        leftPane = new GridPane();

        //leftPane.setGridLinesVisible(true);
        leftPane.setStyle("-fx-background-color: #f5dddc");
        leftPane.setPrefSize(100, 0);
        leftPane.setHgap(2);
        leftPane.setVgap(2);

        setCells();
        chooseList = new ListView<>();
        setChoose();
        difficultyList = new ListView<>();
        setDifficulity();
        whoGoesFirstList = new ListView<>();
        setWhoGoesFirst();

        uTTT = new UltimateTikTakToe();

        setWonLabel();
        setMoves();
        setPlayButtons();
        setStartButton();

    }

    private Label getEmptyLabel(String n) {

        Label emptyLabel = new Label(" " + n + " ");
        emptyLabel.setMinSize(50, 50);
        emptyLabel.setMaxSize(50, 50);
        emptyLabel.setPrefSize(50, 50);
        return emptyLabel;
    }
    public void setPlayButtons() {

        setPlayButtons2(1, 1, 0);
        setPlayButtons2(5, 1, 1);
        setPlayButtons2(9, 1, 2);
        setPlayButtons2(1, 5, 3);
        setPlayButtons2(5, 5, 4);
        setPlayButtons2(9, 5, 5);
        setPlayButtons2(1, 9, 6);
        setPlayButtons2(5, 9, 7);
        setPlayButtons2(9, 9, 8);

        disableButtons();

    }
    public void setPlayButtons2(int x, int y, int index) {
        int count = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                leftPane.add(uTTT.getList().get(index).getList().get(count).getCellButton(), j + x, i + y);
                count++;
            }
        }
    }
    private void setChoose() {
        Label chooseLabel = new Label("With who: ");
        chooseLabel.setFont(MyFont.getLabelFont());
        chooseList.setMinSize(100, 50);
        chooseList.setMaxSize(100, 50);
        ObservableList<String> chooseItems = FXCollections.observableArrayList("Computer", "Player");
        chooseList.setItems(chooseItems);
        chooseList.setOnMouseClicked(e ->{
            leftPane.setStyle("-fx-background-color: #f5dddc");
            if(chooseList.getFocusModel().getFocusedItem().toString().equals("Player")){
                difficultyList.setDisable(true);
                whoGoesFirstList.setDisable(true);
                whoGoesFirstList.setDisable(true);
            }else{
                difficultyList.setDisable(false);
                whoGoesFirstList.setDisable(false);
            }
        });
        leftPane.add(chooseLabel, listCord, 1);
        leftPane.add(chooseList, listCord, 2);
    }
    private void setDifficulity() {
        Label difficultyLabel = new Label("Chose difficulty: ");
        difficultyLabel.setFont(MyFont.getLabelFont());
        difficultyList.setMinSize(100, 50);
        difficultyList.setMaxSize(100, 50);
        difficultyList.setOnMouseClicked(e -> {
           if(difficultyList.getFocusModel().getFocusedItem().toString().equals("easy")) leftPane.setStyle("-fx-background-color: #f5dddc");
           if(difficultyList.getFocusModel().getFocusedItem().toString().equals("medium")) leftPane.setStyle("-fx-background-color: #b5b281");
           if(difficultyList.getFocusModel().getFocusedItem().toString().equals("hard")) leftPane.setStyle("-fx-background-color: #6d506e");
           if(difficultyList.getFocusModel().getFocusedItem().toString().equals("extreme")) leftPane.setStyle("-fx-background-color: #a32626");
        });
        ObservableList<String> difficultyItems = FXCollections.observableArrayList("easy", "medium", "hard" , "extreme");
        difficultyList.setItems(difficultyItems);
        leftPane.add(difficultyLabel, listCord, 3);
        leftPane.add(difficultyList, listCord, 4);
    }
    private void setWhoGoesFirst() {
        Label whoGoesFirstLabel = new Label("Who goes first: ");
        whoGoesFirstLabel.setFont(MyFont.getLabelFont());
        whoGoesFirstList.setMinSize(100, 50);
        whoGoesFirstList.setMaxSize(100, 50);
        ObservableList<String> whoGoesFirstItems = FXCollections.observableArrayList("Computer", "Player");
        whoGoesFirstList.setItems(whoGoesFirstItems);
        leftPane.add(whoGoesFirstLabel, listCord, 5);
        leftPane.add(whoGoesFirstList, listCord, 6);
    }
    private void setCells() {

        for(int i=0 ; i< listCord-3 ; i++){
            leftPane.add(getEmptyLabel(" ") , 0 , i);
        }

        for (int i=0 ; i<listCord ; i++){
            leftPane.add(getEmptyLabel(" ") , i , 0);
        }

    }
    private void setStartButton() {
        startButton = new Button("New game");
        startButton.setPrefSize(100, 50);
        startButton.setStyle("-fx-background-color: #00ff00");
        startButton.setOnAction(actionEvent -> {

            if(startButton.getText().equals("New game")){
                startButton.setText("reset");
                startButton.setStyle("-fx-background-color: #c29082");
                clearPlay();
                enableButtons();
                whoGoesFirstList.setDisable(true);
                difficultyList.setDisable(true);
                chooseList.setDisable(true);
                //poprawione
                 if(whoGoesFirstList.getFocusModel().getFocusedItem().toString().equals("Computer") && chooseList.getFocusModel().getFocusedItem().toString().equals("Computer")) {
                        makeComputerGame(new Cordinates());
                    setWhoMoves();
                }
            }
            else{
                startButton.setText("New game");
                startButton.setStyle("-fx-background-color: #00ff00");
                wonLabel.setVisible(false);
                clearPlay();
                disableButtons();
                whoGoesFirstList.setDisable(false);
                difficultyList.setDisable(false);
                chooseList.setDisable(false);
                moveItems = FXCollections.observableArrayList();
                moveList.setItems(moveItems);
                whoMoves = false;
                moveCount = 80;
            }
        });
        leftPane.add(startButton, listCord, 10);
    }
    private void setMoves() {
        Label movesLabel = new Label("Moves: ");
        movesLabel.setFont(MyFont.getLabelFont());
        moveList = new ListView<>();
        moveList.setMinSize(100, 50);
        moveList.setMaxSize(100, 50);
        moveItems = FXCollections.observableArrayList();
        moveList.setItems(moveItems);
        leftPane.add(movesLabel, listCord, 7);
        leftPane.add(moveList, listCord, 8);
    }
    private void setWonLabel(){
        wonLabel = new Label();
        wonLabel.setFont(MyFont.getButtonFont(25));
        wonLabel.setTextFill(Color.web("#5d66c9" , 0.8));
        wonLabel.setVisible(false);
        leftPane.add(wonLabel , listCord , 11);
    }
    private static void setPlayAttributes(){
        withWho = chooseList.getFocusModel().getFocusedItem().toString();
        difficulty = difficultyList.getFocusModel().getFocusedItem().toString();
        if(withWho.equals("Player"))firstMove = "Player";
        else firstMove = whoGoesFirstList.getFocusModel().getFocusedItem().toString();
    }
    public static void setWhoMoves() {
        whoMoves = !whoMoves;
    }
    private void clearPlay(){
        for(int i=0 ; i<9 ; i++){
            for(int j=0 ; j<9 ; j++){
                uTTT.getList().get(i).getList().get(j).setStateE();
                if(uTTT.getList().get(i).getList().get(j).getCellButton().isDisable())uTTT.getList().get(i).getList().get(j).getCellButton().setDisable(false);
            }
            uTTT.getList().get(i).setStateNull();
        }
        uTTT.setStateNull();
    }
    private void disableButtons(){
        for (int i=0 ; i<9 ; i++){
            for (int j = 0; j < 9; j++) {
                uTTT.getList().get(i).getList().get(j).getCellButton().setDisable(true);
                uTTT.getList().get(i).getList().get(j).getCellButton().setStyle(null);
            }
        }
    }
    private void enableButtons(){
        for (int i =0 ; i<9 ; i++){
            for (int j = 0; j < 9; j++) {
                uTTT.getList().get(i).getList().get(j).getCellButton().setDisable(false);
                uTTT.getList().get(i).getList().get(j).getCellButton().setStyle(null);
            }
        }
    }
    public static void enableNotWonButtons(){
        for (int i =0 ; i<9 ; i++){
            if(uTTT.getList().get(i).getState() == DoneState.NULL){
                for (int j = 0; j < 9; j++) {
                    if(uTTT.getList().get(i).getList().get(j).getState() == CellState.E){
                        uTTT.getList().get(i).getList().get(j).getCellButton().setDisable(false);
                        uTTT.getList().get(i).getList().get(j).getCellButton().setStyle(null);
                    }
                }
            }
        }
    }

    public static void makeMove(Cordinates cordinates){

        setPlayAttributes();
        setWhereCanIMove(cordinates);
        makePlayerGame(cordinates);
    }
    public static void makePlayerGame(Cordinates cordinates){
        for (int i=0 ; i<9 ; i++){
            uTTT.getList().get(i).check();
        }

        //checking if sb won
        uTTT.check();
        if(uTTT.getDoneState() != DoneState.NULL) {
            if(uTTT.getDoneState() == DoneState.DRAW){
                wonLabel.setText("Nobody won");
            }else {
                if(uTTT.getDoneState() == DoneState.OWIN) wonLabel.setText("O WON");
                else wonLabel.setText("X WIN");
            }
            wonLabel.setVisible(true);
        }

        //poprawione
        if(chooseList.getFocusModel().getFocusedItem().toString().equals("Computer")) {
            makeComputerGame(cordinates);
        }
    }
    public static void makeComputerGame(Cordinates cordinates){
        symulatePlayerClick(cordinates);

        for (int i=0 ; i<9 ; i++){
            uTTT.getList().get(i).check();
        }

        //checking if sb won
        uTTT.check();

        for (int k=0 ; k<9 ; k++){
            uTTT.getList().get(k).check();
        }
        if(uTTT.getDoneState() != DoneState.NULL) {
            if(uTTT.getDoneState() == DoneState.DRAW){
                wonLabel.setText("Nobody won");
            }else {
                if(uTTT.getDoneState() == DoneState.OWIN) wonLabel.setText("O WON");
                else wonLabel.setText("X WON");
            }
            wonLabel.setVisible(true);
        }

    }

    private static void setWhereCanIMove(Cordinates c){
        enableNotWonButtons();
        setPlayAttributes();

        if (uTTT.getList().get(c.cToInteger()).getState() == DoneState.NULL) {
            for(int i=0 ; i<9 ; i++){

                if(i != c.cToInteger()){
                    for(int j=0 ; j<9 ; j++){
                        uTTT.getList().get(i).getList().get(j).getCellButton().setDisable(true);
                    }
                }
            }
        }else enableNotWonButtons();
    }
    private static void symulatePlayerClick(Cordinates cordinates){


        NormalTicTacToe nTTT;
        boolean allGood = true;
        int nTTTNumber = (int)(Math.random()*9);
        if(uTTT.getList().get(cordinates.cToInteger()).getState() == DoneState.NULL) nTTT = uTTT.getList().get(cordinates.cToInteger());
        else {
            allGood = false;
            nTTTNumber = (int)(Math.random()*9);
            boolean war = true;
            while (war){
                nTTTNumber = (int)(Math.random()*9);
                if(uTTT.getList().get(nTTTNumber).getState() == DoneState.NULL) war = false;
            }
            nTTT = uTTT.getList().get(nTTTNumber);
        }

        int war;
        if(difficultyList.getFocusModel().getFocusedItem().toString().equals("easy")) war=1;
        else if(difficultyList.getFocusModel().getFocusedItem().toString().equals("medium")) war=3;
        else if(difficultyList.getFocusModel().getFocusedItem().toString().equals("hard")) war=5;
        else war=9;


        for(int i=0 ; i<war ; i++){

            //picking a free random cell
            int randomCell = (int)(Math.random()*9);
            while (nTTT.getList().get(randomCell).getState() != CellState.E){
                randomCell = (int)(Math.random()*9);
            }

            if(nTTT.rawCheck() || i == (war-1)){
                if(allGood) uTTT.getList().get(cordinates.cToInteger()).getList().get(randomCell).symulateClick();
                else uTTT.getList().get(nTTTNumber).getList().get(randomCell).symulateClick();
                if(uTTT.getList().get(cordinates.cToInteger()).getList().get(randomCell).getCordinates().getC() == uTTT.getList().get(cordinates.cToInteger()).getList().get(randomCell).getCordinates().getN()) enableNotWonButtons();
                else setWhereCanIMove(uTTT.getList().get(cordinates.cToInteger()).getList().get(randomCell).getCordinates());
                i=war;
            } else {
                nTTT.getList().get(randomCell).setStateE();
            }
        }

    }

    public static void addMove(Cordinates cordinates){
        //adding to moveList
        String playerString;
        if(whoMoves) playerString="O";
        else playerString = "X";
        String moveString = playerString +": " + cordinates;
        moveItems.add(moveString);
        moveCount++;
        moveList.setItems(moveItems);
    }
}