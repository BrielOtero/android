package com.gabriel.game.screens;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.ControllerAdapter;
import com.badlogic.gdx.controllers.ControllerListener;
import com.gabriel.game.Invaders;
import com.gabriel.game.Renderer;
import com.gabriel.game.simulation.Simulation;
import com.gabriel.game.simulation.SimulationListener;

public class GameLoop extends InvadersScreen implements SimulationListener {
    /**
     * the simulation
     **/
    private final Simulation simulation;
    /**
     * the renderer
     **/
    private final Renderer renderer;
    /**
     * explosion sound
     **/
    private final Sound explosion;
    /**
     * shot sound
     **/
    private final Sound shot;

    /**
     * controller
     **/
    private int buttonsPressed = 0;
    private ControllerListener listener = new ControllerAdapter() {
        @Override
        public boolean buttonDown(Controller controller, int buttonIndex) {
            buttonsPressed++;
            return true;
        }

        @Override
        public boolean buttonUp(Controller controller, int buttonIndex) {
            buttonsPressed--;
            return true;
        }
    };

    public GameLoop(Invaders invaders) {
        super(invaders);
        simulation = new Simulation();
        simulation.listener = this;
        renderer = new Renderer();
        explosion = Gdx.audio.newSound(Gdx.files.internal("data/explosion.wav"));
        shot = Gdx.audio.newSound(Gdx.files.internal("data/shot.wav"));

        if (invaders.getController() != null) {
            invaders.getController().addListener(listener);
        }
    }

    @Override
    public void dispose() {
        renderer.dispose();
        shot.dispose();
        explosion.dispose();
        if (invaders.getController() != null) {
            invaders.getController().removeListener(listener);
        }
        simulation.dispose();
    }

    @Override
    public boolean isDone() {
        return simulation.ship.lives == 0;
    }

    @Override
    public void draw(float delta) {
        renderer.render(simulation, delta);
    }

    private static final String TAG = "INFO";

    @Override
    public void update(float delta) {
        simulation.update(delta);

//            float gyro = Gdx.input.getAccelerometerX();
//            Gdx.app.log(TAG, String.valueOf(gyro));
//
//            if (gyro < 0) {
//                simulation.moveShipRight(delta,  Math.abs(gyro) / 10);
//            } else {
//                simulation.moveShipLeft(delta,  Math.abs(gyro) / 10);
//            }

        if (invaders.getController() != null) {
            if (buttonsPressed > 0) {
                simulation.shot();
            }
        }

        if (Gdx.input.isKeyPressed(Keys.DPAD_LEFT) || Gdx.input.isKeyPressed(Keys.A))
            simulation.moveShipLeft(delta, 0.5f);
        if (Gdx.input.isKeyPressed(Keys.DPAD_RIGHT) || Gdx.input.isKeyPressed(Keys.D))
            simulation.moveShipRight(delta, 0.5f);
        if (Gdx.input.isTouched() || Gdx.input.isKeyPressed(Keys.SPACE)) simulation.shot();
    }

    @Override
    public void explosion() {
        explosion.play();
    }

    @Override
    public void shot() {
        shot.play();
    }
}
