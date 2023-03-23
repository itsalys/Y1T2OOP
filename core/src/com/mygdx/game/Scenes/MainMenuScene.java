package com.mygdx.game.Scenes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.SceneManager;

public class MainMenuScene implements Scene {


    private Stage stage;
    private Skin skin;
    private TextButton startButton;

    private TextButton optionButton;

    private Image background;


    @Override
    public void createScene() {
        stage = new Stage(new ScreenViewport());
        skin = new Skin(Gdx.files.internal("uiskin.json"));
        int row_height = Gdx.graphics.getWidth() / 10;
        int col_width = Gdx.graphics.getWidth() / 10;

        background = new Image(new Texture(Gdx.files.internal("MainMenuBackground.jpg")));
        background.setWidth(Gdx.graphics.getWidth());
        background.setHeight(Gdx.graphics.getHeight());
        stage.addActor(background);

        startButton = new TextButton("Start", skin);
        startButton.setSize(Gdx.graphics.getWidth()/2,row_height);
        startButton.setX(160);
        startButton.setY(250);
        stage.addActor(startButton);

        optionButton = new TextButton("Instruction", skin);
        optionButton.setSize(Gdx.graphics.getWidth()/2,row_height);
        optionButton.setX(160);
        optionButton.setY(150);
        stage.addActor(optionButton);

        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void renderScene() {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        stage.act();
        stage.draw();
    }

    @Override
    public void updateScene()
    {
        if(startButton.isPressed()) {
            MyGdxGame.getInstance().getSceneManager().SetNextScene(SceneManager.PlayScene);
        }

        if(optionButton.isPressed()) {
            MyGdxGame.getInstance().getSceneManager().SetNextScene(SceneManager.Instruction);
        }
    }

    @Override
    public void disposeScene() {

    }
}


