package org.example.snakeAndLadder.models;

public class Player {
    private String name;
    private PLayerType pLayerType;
    private int currentPosition;

    public Player(String name, PLayerType pLayerType) {
        this.name = name;
        this.pLayerType = pLayerType;
        currentPosition = 0;
    }

    public Move move(){
        return new Move();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PLayerType getpLayerType() {
        return pLayerType;
    }

    public void setpLayerType(PLayerType pLayerType) {
        this.pLayerType = pLayerType;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}
