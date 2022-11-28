package com.gabriel.game.game;

import com.badlogic.gdx.Gdx;

import net.mgsx.gltf.loaders.gltf.GLTFLoader;
import net.mgsx.gltf.scene3d.scene.Scene;
import net.mgsx.gltf.scene3d.scene.SceneAsset;
import net.mgsx.gltf.scene3d.scene.SceneManager;

public class Saber {
  //  private SceneManager sceneManager;
    private SceneAsset sceneAsset;
//    private Scene scene;

    public Saber(SceneManager sceneManager,Scene scene){
        sceneAsset = new GLTFLoader().load(Gdx.files.internal("models/saber-blue.gltf"));
        scene = new Scene(sceneAsset.scene);
        sceneManager = new SceneManager();
        sceneManager.addScene(scene);
    }
}
