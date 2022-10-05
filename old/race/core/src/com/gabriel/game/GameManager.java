package com.gabriel.game;

import com.badlogic.gdx.Game;
import com.gabriel.game.utils.AudioManager;
import com.gabriel.game.utils.PreferenceManager;
import com.gabriel.game.utils.ResourceManager;
import com.gabriel.game.utils.ScreenManager;




public class GameManager extends Game {

	
	public ScreenManager screenMngr;
	public ResourceManager resMngr;
	public AudioManager audioMnger;
	public PreferenceManager prefManager;
	
	@Override
	public void create () {
		initMngrs();
		screenMngr.setSplashScreen();
	}


	private void initMngrs() {
		screenMngr = new ScreenManager(this);
		resMngr = new ResourceManager();
		audioMnger = new AudioManager();
		prefManager = new PreferenceManager();
	}
	
	@Override
	public void dispose() {
		resMngr.dispose();
		screenMngr.dispose();
		super.dispose();
		
	}
}
