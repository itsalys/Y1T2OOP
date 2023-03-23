package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
public class InputManager {

    public MyGdxGame game;
    private int upKey;
    private int downKey;
    private int leftKey;
    private int rightKey;
    private int jumpKey;

    public InputManager() {
        this.game = MyGdxGame.getInstance();

        this.upKey = Keys.W;
        this.downKey = Keys.S;
        this.leftKey = Keys.A;
        this.rightKey = Keys.D;
        this.jumpKey = Keys.SPACE;
    }

    public boolean isKeyPressed(int key) {
        return Gdx.input.isKeyPressed(key);
    }

    public int getUpKey() {
        return upKey;
    }

    public void setUpKey(int upKey) {
        this.upKey = upKey;
    }

    public int getDownKey() {
        return downKey;
    }

    public void setDownKey(int downKey) {
        this.downKey = downKey;
    }

    public int getLeftKey() {
        return leftKey;
    }

    public void setLeftKey(int leftKey) {
        this.leftKey = leftKey;
    }

    public int getRightKey() {
        return rightKey;
    }

    public void setRightKey(int rightKey) {
        this.rightKey = rightKey;
    }

    public int getJumpKey() {
        return jumpKey;
    }

    public void setJumpKey(int jumpKey) {
        this.jumpKey = jumpKey;
    }
}
