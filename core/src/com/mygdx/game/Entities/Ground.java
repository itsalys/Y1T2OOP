package com.mygdx.game.Entities;

public class Ground extends GameObject {
    public Ground(float x, float y, int height, int width) {
        super(x, y, height, width);
    }

    @Override
    public void reactToCollision(iCollidable other) {

    }
}
