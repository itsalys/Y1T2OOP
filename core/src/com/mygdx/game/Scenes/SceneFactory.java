package com.mygdx.game.Scenes;

public class SceneFactory {
    public Scene getScene(String Scene) {
        if ( Scene == null) return null;
        else if ( Scene.equalsIgnoreCase("MainMenuScene")) {
            return new MainMenuScene();
        }
        else if ( Scene.equalsIgnoreCase("InstructionScene")) {
            return new InstructionScene();
        }
        else if ( Scene.equalsIgnoreCase("PlayScene")) {
            return new PlayScene();
        }
        else if ( Scene.equalsIgnoreCase("GameLoseScene")) {
            return new GameLoseScene();
        }
        else if ( Scene.equalsIgnoreCase("GameWinScene")) {
            return new GameWinScene();
        }
        else return null;
    }
}
