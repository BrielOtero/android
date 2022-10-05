package com.gabriel.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.gabriel.game.GameManager;
import com.gabriel.game.mvc.controller.Controller;
import com.gabriel.game.mvc.render.Render;
import com.gabriel.game.mvc.world.World;


public class PlayScreen implements Screen {

	GameManager gameManager;
	World world;
	Render render;
	Controller controller;
	
	public PlayScreen(int _boxCount, int _level) {}
	
	@Override
	public void show() {
		Gdx.app.log(this.getClass().toString(), "show()");
		gameManager = (GameManager) Gdx.app.getApplicationListener();
		
		world = new World();
		render = new Render(world);
		controller = new Controller(world, render);
	}

	@Override
	public void render(float delta) {
		
		world.update(delta);
        
        render.render(delta);
        
        controller.update(delta);
        
	}

	@Override
	public void resize(int width, int height) {}

	@Override
	public void pause() {}

	@Override
	public void resume() {}

	@Override
	public void hide() {}

	@Override
	public void dispose() {
		world.dispose();
		render.dispose();
		controller.dispose();
	}

}
