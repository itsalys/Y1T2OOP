package com.mygdx.game.Scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapProperties;
import com.mygdx.game.Entities.Enemy;
import com.mygdx.game.Entities.Flag;
import com.mygdx.game.Entities.Ground;
import com.mygdx.game.Entities.Player;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.SceneManager;
import com.mygdx.game.TiledMapHelper;

public class PlayScene implements Scene {

    private TiledMapHelper tiledMapHelper;

    // game states
    private boolean gameInPlay = true;
    private boolean gameWin = false;


    @Override
    public void createScene() {

        // game states
        this.gameInPlay = true;
        this.gameWin = false;

        // map
        tiledMapHelper = new TiledMapHelper("map.tmx");

        // creating objects
        MapObject startPoint = tiledMapHelper.getMapObjectList("start").get(0);
        MapProperties startProps = startPoint.getProperties();

        MyGdxGame.getInstance().getEntityLifecycleManager().create(new Player( (float)startProps.get("x"), (float)startProps.get("y"), 100) );

        for (MapObject obj : tiledMapHelper.getMapObjectList("enemy") )
        {
            MapProperties props = obj.getProperties();
            MyGdxGame.getInstance().getEntityLifecycleManager().create( new Enemy( (float)props.get("x"), (float)props.get("y"), 100));
        }

        for (MapObject obj : tiledMapHelper.getMapObjectList("Flag") )
        {
            MapProperties props = obj.getProperties();
            MyGdxGame.getInstance().getEntityLifecycleManager().create( new Flag( (float)props.get("x"), (float)props.get("y"), (int)(float)props.get("height"),(int)(float)props.get("width")) );
        }

        for (MapObject obj : tiledMapHelper.getMapObjectList("Solid") )
        {
            MapProperties props = obj.getProperties();
            MyGdxGame.getInstance().getEntityLifecycleManager().create( new Ground( (float)props.get("x"), (float)props.get("y"), (int)(float)props.get("height"),(int)(float)props.get("width")) );
        }
    }

    @Override
    public void updateScene() {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        tiledMapHelper.getTiledMapRenderer().setView(tiledMapHelper.getTiledCamera());
        tiledMapHelper.getTiledMapRenderer().render();

        MyGdxGame.getInstance().getEntityLifecycleManager().updateAll();
        MyGdxGame.getInstance().getEntityLifecycleManager().render();

        if ( gameInPlay == false) {
            if ( gameWin ) MyGdxGame.getInstance().getSceneManager().SetNextScene(SceneManager.GameWinScene);
            else MyGdxGame.getInstance().getSceneManager().SetNextScene(SceneManager.GameLoseScene);
        }
    }

    @Override
    public void renderScene() {
    }

    @Override
    public void disposeScene() {
        tiledMapHelper.getTiledMap().dispose();
        MyGdxGame.getInstance().getEntityLifecycleManager().dispose();
    }

    public boolean isGameInPlay() {
        return gameInPlay;
    }

    public void setGameInPlay(boolean gameInPlay) {
        this.gameInPlay = gameInPlay;
    }

    public boolean isGameWin() {
        return gameWin;
    }

    public void setGameWin(boolean gameWin) {
        this.gameWin = gameWin;
    }
}
