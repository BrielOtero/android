package com.gabriel.game.entities;

import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.gabriel.game.BeatSlide;
import com.gabriel.game.assets.GameAssets;
import com.sun.org.apache.xpath.internal.operations.Mod;

import net.mgsx.gltf.scene3d.scene.Scene;

public class Player {
    public int lives = 3;


    public Saber leftS;
    public Saber rightS;


    public Player (){

        leftS = new Saber(GameAssets.i.leftSaber,0,0,0);
//        rightS = new ModelInstance(GameAssets.i.rightSaber);


    }

    public void rigtKick (){

    }

    public void update(float delta){
    }
}
