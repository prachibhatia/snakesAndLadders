package org.example.snakeAndLadder;

import org.example.snakeAndLadder.controllers.GameController;
import org.example.snakeAndLadder.exceptions.NotAValidLadderPosition;
import org.example.snakeAndLadder.exceptions.NotAValidSnakePosition;
import org.example.snakeAndLadder.models.Game;
import org.example.snakeAndLadder.models.GameState;
import org.example.snakeAndLadder.models.Ladder;
import org.example.snakeAndLadder.models.Snake;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SnakeAndLadder {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        GameController gameController = new GameController();
        System.out.println("Enter board's dimension");
        int size = s.nextInt();
        System.out.println("Enter no of players");
        int playersCount = s.nextInt();

        System.out.println("How many snakes you want on the board");
        int snakesCount = s.nextInt();
        List<Snake> snakes= new ArrayList<>();
        for(int i=0;i<snakesCount;i++){
            int snake = i+1;
            System.out.println("Where you want the "+snake+" snake's head");

            int start = s.nextInt();

            System.out.println("Where you want the "+snake+" snake's tail");

            int tail = s.nextInt();

            try{
                if(start<=tail){
                    throw new NotAValidSnakePosition("Starting position should be more than end position");
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }

            Snake snakeOnBoard = new Snake();
            snakeOnBoard.setStartPoint(start);
            snakeOnBoard.setEndPoint(tail);
            snakes.add(snakeOnBoard);
        }

        System.out.println("How many ladders you want on the board");
        int laddersCount = s.nextInt();
        List<Ladder> ladders = new ArrayList<>();
        for(int i=0;i<laddersCount;i++){
            int ladder = i+1;
            System.out.println("Where you want the "+ladder+" ladder's head");
            int start = s.nextInt();

            System.out.println("Where you want the"+ ladder+" ladder's tail");
            int tail = s.nextInt();
            try{
                if(start<=tail){
                    throw new NotAValidLadderPosition("Starting position should be more than end position");
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            Ladder ladderOnBoard = new Ladder();
            ladderOnBoard.setStartPoint(start);
            ladderOnBoard.setEndPoint(tail);
            ladders.add(ladderOnBoard);
        }

        Game game = gameController.createGame(size,playersCount);
        game.getBoard().setSnakes(snakes);
        game.getBoard().setLadders(ladders);

        System.out.println("Let's start the game");

        while(gameController.getGameStatus(game) == GameState.IN_PROGRESS){
            gameController.makeMove(game);
        }
        System.out.println("Game Ended");
        System.out.println("Game winner is "+gameController.getGameWinner(game).getName());
    }
}
