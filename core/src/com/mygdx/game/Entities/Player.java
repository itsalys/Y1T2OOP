package com.mygdx.game.Entities;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Scenes.PlayScene;

public class Player extends Entity{
    private static Texture texture = new Texture("astronaut.png");

    public Player(float x, float y, int speed) {
        super(x, y, speed, texture);
        setControl(true);
    }

    @Override
    public void handleMovement() { // abstract in future
        applyGravity();
    }
    @Override
    public void reactToCollision(iCollidable other) {
        if (other instanceof Ground) {
            setPosition(getPrvPosition());
        }
        else if (other instanceof Enemy) {
            // player die
            ((PlayScene) MyGdxGame.getInstance().getSceneManager().GetCurrentScene()).setGameInPlay(false);
            ((PlayScene) MyGdxGame.getInstance().getSceneManager().GetCurrentScene()).setGameWin(false);
        }
        else if (other instanceof Flag) {
            // player win !
            ((PlayScene) MyGdxGame.getInstance().getSceneManager().GetCurrentScene()).setGameInPlay(false);
            ((PlayScene) MyGdxGame.getInstance().getSceneManager().GetCurrentScene()).setGameWin(true);
        }

    }
}
