package com.gabriel.game.utils;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.utils.Disposable;
import com.gabriel.game.screens.PlayScreen;
import com.gabriel.game.screens.SplashScreen;


public class ScreenManager implements Disposable {
	
	
	Game game;
	
	public ScreenManager(Game _game) {
		game = _game;
	}
	
	public void setSplashScreen() {
		game.setScreen(new SplashScreen());
	}
	
	public void setPlayScreen(int _boxCount, int _level) {
		PlayScreen playScreen = new PlayScreen(_boxCount,_level);
		game.setScreen(playScreen);
	}

	@Override
	public void dispose() {}
	
}
