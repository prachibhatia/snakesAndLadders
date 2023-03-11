package org.example.snakeAndLadder.models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Game {
    private Board board;
    private Queue<Player> playersList;
    private List<Move> moves;
    private Player winner;
    private GameState gameState;
    private Dice dice;

    public Game(int dimension,int noOfPlayers) {
        board = new Board(dimension);
        playersList = new LinkedList<>();
        for(int i=0;i<noOfPlayers;i++){
            String playerName = "player"+(i+1);
            Player player = new Player(playerName,PLayerType.HUMAN);
            playersList.add(player);
        }
        moves = new ArrayList<>();
        gameState = GameState.IN_PROGRESS;
        dice = new Dice();
    }
    public void undo(){
    }

    public Board getBoard() {
        return board;
    }

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Queue<Player> getPlayersList() {
        return playersList;
    }

    public void setPlayersList(Queue<Player> playersList) {
        this.playersList = playersList;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getPosition(int newPosition){
        List<Snake> snakes = board.getSnakes();
        for(int i=0;i<snakes.size();i++){
            if(snakes.get(i).getStartPoint()==newPosition){
                return snakes.get(i).getEndPoint();
            }
        }
        List<Ladder> ladders = board.getLadders();
        for(int i=0;i<ladders.size();i++){
            if(ladders.get(i).getEndPoint()==newPosition){
                return ladders.get(i).getStartPoint();
            }
        }
        return newPosition;
    }

    public void makeMove(){
        Player player = playersList.poll();
        System.out.println(player.getName() + " rolling the dice");
        int diceCount = dice.rollDice();
        int currPosition = player.getCurrentPosition();
        int newPosition = currPosition + diceCount;
        if(newPosition<=board.getSize()){
            player.setCurrentPosition(getPosition(newPosition));
        }
        if(player.getCurrentPosition()==board.getSize()){
            setGameState(GameState.END);
            setWinner(player);
        }
        playersList.add(player);
    }

}
