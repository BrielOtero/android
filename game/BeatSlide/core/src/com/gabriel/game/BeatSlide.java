package com.gabriel.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.gabriel.game.screens.BeatSlideScreen;
import com.gabriel.game.screens.GameLoop;

public class BeatSlide extends Game {

    @Override
    public void create() {
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
