package com.gabriel.game.gameobjects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gabriel.game.WorldManager;
/**
 * 
 * @author Jake
 *
 */
public class Platform extends StaticCharacter {
	
	/**
	 * 
	 * @param sprite
	 */
	public Platform(Sprite sprite, float x, float y) {
		super(sprite, x, y);
		getSprite().setX(x);
		getSprite().setY(y);
	}

	@Override
	public void draw(SpriteBatch batch) {
		batch.draw(getSprite(), getKinematicBody().getPosition().x - getWidth()/2, getKinematicBody().getPosition().y - getHeight()/2, getWidth(), getHeight());
		
		if (!WorldManager.GAME_OVER) {
			getSprite().setPosition(getKinematicBody().getPosition().x, getKinematicBody().getPosition().y);
			getKinematicBody().setLinearVelocity(-3.15f, 0f);
		} else {
			getKinematicBody().setActive(false);
		}
	}
}
