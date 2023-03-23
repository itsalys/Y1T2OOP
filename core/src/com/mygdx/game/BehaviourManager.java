package com.mygdx.game;

import com.mygdx.game.Entities.Entity;
import com.mygdx.game.Entities.Player;

import java.util.ArrayList;

public class BehaviourManager {

    public MyGdxGame game;

    private ArrayList<Entity> list;

    public BehaviourManager() {
        this.game = MyGdxGame.getInstance();
        this.list = new ArrayList<Entity>();
    }

    public void updateAll()
    {
        for (Entity entity: list) {
            if(entity.isControl()) controlledMovement(entity);
            entity.handleMovement();
        }
    }

    public void updateOne(Entity entity)
    {
        entity.handleMovement();
    }

    public void addEntity(Entity entity)
    {
        list.add(entity);
    }

    private void controlledMovement(Entity entity) {

        if(entity instanceof Player)  entity.setPrvPosition(entity.getPosition()) ;

        if(game.getInputManager().isKeyPressed(game.getInputManager().getJumpKey())) entity.moveJump();
        if(game.getInputManager().isKeyPressed(game.getInputManager().getLeftKey())) entity.moveLeft();
        else if(game.getInputManager().isKeyPressed(game.getInputManager().getRightKey())) entity.moveRight();

    }

    public void dispose() {
        list.clear();
    }
}
