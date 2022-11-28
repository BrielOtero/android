package com.gabriel.game.game;

import com.badlogic.gdx.utils.Disposable;
import com.gabriel.game.entities.Player;

import net.mgsx.gltf.scene3d.scene.SceneManager;

public class GamePlay implements Disposable {
    public Player player;

    public GamePlay() {
        populate();
    }

    private void populate() {
        player = new Player();


    }

    @Override
    public void dispose() {

    }

    public void update(float delta) {
        player.update(delta);
    }
}
