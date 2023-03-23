package com.mygdx.game;

import com.mygdx.game.Scenes.Scene;
import com.mygdx.game.Scenes.SceneFactory;

import java.util.ArrayList;
import java.util.List;

public class SceneManager{

    public MyGdxGame game;
    public static final int MainMenu = 0;
    public static final int Instruction = 1;
    public static final int PlayScene = 2;
    public static final int GameLoseScene = 3;
    public static final int GameWinScene = 4;
    private Scene CurrentScene;
    SceneFactory sceneFactory;

    private List<Scene> scenes;

    public SceneManager()
    {
        game = MyGdxGame.getInstance();
        CurrentScene = null;
        scenes = new ArrayList<Scene>();

        sceneFactory = new SceneFactory();

        AddScene(sceneFactory.getScene("MainMenuScene"));       // 0
        AddScene(sceneFactory.getScene("InstructionScene"));    // 1
        AddScene(sceneFactory.getScene("PlayScene"));           // 2
        AddScene(sceneFactory.getScene("GameLoseScene"));       // 3
        AddScene(sceneFactory.getScene("GameWinScene"));        // 4
    }

    public void AddScene(Scene scene)
    {
        scenes.add(scene);
    }

    public void RunCurrentScene()
    {
        GetCurrentScene().updateScene();
        GetCurrentScene().renderScene();
    }

    public void SetNextScene(int index)
    {
        if(CurrentScene != null)
        {
            CurrentScene.disposeScene();
        }
        CurrentScene = scenes.get(index);
        CurrentScene.createScene();
    }

    public Scene GetCurrentScene()
    {
        return CurrentScene;
    }
}
