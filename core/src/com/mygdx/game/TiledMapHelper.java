package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthoCachedTiledMapRenderer;

import java.util.ArrayList;

public class TiledMapHelper {

    public static int windowWidth  = Gdx.graphics.getWidth();
    public static int windowHeight = Gdx.graphics.getHeight();

    private TiledMap tiledMap;
    private OrthographicCamera tiledCamera;
    private OrthoCachedTiledMapRenderer tiledMapRenderer;

    public TiledMapHelper(String filename) {
        tiledMap = new TmxMapLoader().load(filename);

        tiledMapRenderer = new OrthoCachedTiledMapRenderer(tiledMap);
        tiledMapRenderer.setBlending(true);

        tiledCamera = new OrthographicCamera();
        tiledCamera.setToOrtho(false, windowWidth, windowHeight);
        tiledCamera.update();
    }

    public ArrayList<MapObject> getMapObjectList(String propertyName)
    {
        ArrayList<MapObject> list = new ArrayList<MapObject>();

        for ( MapLayer layer : tiledMap.getLayers() ) {
            for ( MapObject obj : layer.getObjects() ) {

                MapProperties props = obj.getProperties();

                if ( props.containsKey("name") && props.get("name").equals(propertyName) )
                    list.add(obj);
            }
        }
        return list;
    }

    public TiledMap getTiledMap() {
        return tiledMap;
    }

    public void setTiledMap(TiledMap tiledMap) {
        this.tiledMap = tiledMap;
    }

    public OrthographicCamera getTiledCamera() {
        return tiledCamera;
    }

    public void setTiledCamera(OrthographicCamera tiledCamera) {
        this.tiledCamera = tiledCamera;
    }

    public OrthoCachedTiledMapRenderer getTiledMapRenderer() {
        return tiledMapRenderer;
    }

    public void setTiledMapRenderer(OrthoCachedTiledMapRenderer tiledMapRenderer) {
        this.tiledMapRenderer = tiledMapRenderer;
    }
}
