package com.gabriel.game.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.loader.ObjLoader;

import net.mgsx.gltf.loaders.gltf.GLTFLoader;
import net.mgsx.gltf.scene3d.scene.SceneAsset;

public class GameAssets {
    public static GameAssets i;
    //    public Model block;
    public Model leftSaber;
    public Model rightSaber;
    private ObjLoader objLoader = new ObjLoader();
    ;

    public GameAssets() {

//        leftSaber = load("models/saber-blue");
        leftSaber = objLoader.loadModel(Gdx.files.internal( "models/saber-blue.obj"));
        rightSaber = load("models/saber-blue");
    }

    private Model load(String path) {

        return objLoader.loadModel(Gdx.files.internal(path + ".obj"));


    }
}
