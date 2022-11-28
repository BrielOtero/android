package com.gabriel.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.gabriel.game.assets.GameAssets;
import com.gabriel.game.screens.BeatSlideScreen;
import com.gabriel.game.screens.GameLoop;

import net.mgsx.gltf.scene3d.scene.SceneManager;

public class BeatSlide extends Game {
    //Scene Manager
    public static SceneManager sceneManager;

    @Override
    public void create() {
        GameAssets.i = new GameAssets();
        sceneManager = new SceneManager();

        setScreen(new GameLoop(this));
    }

    @Override
    public void render() {
        BeatSlideScreen screen = getScreen();

        //This update the screen
        screen.render(Gdx.graphics.getDeltaTime());

        if (screen.isDone()) {
            screen.dispose();

            setScreen(new GameLoop(this));
        }


    }

    @Override
    public void dispose() {
    }

    /**
     * Each of screens is an instance of BeatSlideScreen.
     *
     * @return the currently active {@link BeatSlideScreen}.
     */
    @Override
    public BeatSlideScreen getScreen() {
        return (BeatSlideScreen) super.getScreen();
    }
}
