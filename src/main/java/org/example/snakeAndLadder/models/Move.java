package org.example.snakeAndLadder.models;

public class Move {
    private Player player;
    private int old_pos;
    private int new_pos;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getOld_pos() {
        return old_pos;
    }

    public void setOld_pos(int old_pos) {
        this.old_pos = old_pos;
    }

    public int getNew_pos() {
        return new_pos;
    }

    public void setNew_pos(int new_pos) {
        this.new_pos = new_pos;
    }
}
