package com.gabriel.game.screens;

import com.gabriel.game.BeatSlide;
import com.gabriel.game.Renderer;
import com.gabriel.game.game.GamePlay;

public class GameLoop extends BeatSlideScreen  {
    //GamePlay
    private final GamePlay gamePlay;

    //Renderer
    private final Renderer renderer;

    public GameLoop(BeatSlide beatSlide) {
        super(beatSlide);

        gamePlay = new GamePlay();

        renderer = new Renderer();
    }

    @Override
    public void update(float delta) {
        gamePlay.update(delta);

    }

    @Override
    public void draw(float delta) {
        renderer.render(gamePlay,delta);

    }

    @Override
    public boolean isDone() {
        return false;
    }
}
