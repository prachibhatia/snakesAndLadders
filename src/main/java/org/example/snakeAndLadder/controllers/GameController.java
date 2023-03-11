package org.example.snakeAndLadder.controllers;

import org.example.snakeAndLadder.models.Game;
import org.example.snakeAndLadder.models.GameState;
import org.example.snakeAndLadder.models.Player;

public class GameController {
    public void undo(Game game) {
        game.undo();
    }

    public Game createGame(int dimension, int noOfPlayers) {
        return new Game(dimension,noOfPlayers);
    }

    public GameState getGameStatus(Game game) {
        return game.getGameState();
    }

    public Player getGameWinner(Game game){
        return game.getWinner();
    }

    public void makeMove(Game game){
        game.makeMove();
    }


}
