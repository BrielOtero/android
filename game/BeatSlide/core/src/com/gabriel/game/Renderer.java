package com.gabriel.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Cubemap;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.FirstPersonCameraController;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.gabriel.game.game.GamePlay;
import com.gabriel.game.entities.Player;

import net.mgsx.gltf.loaders.gltf.GLTFLoader;
import net.mgsx.gltf.scene3d.attributes.PBRCubemapAttribute;
import net.mgsx.gltf.scene3d.attributes.PBRTextureAttribute;
import net.mgsx.gltf.scene3d.lights.DirectionalLightEx;
import net.mgsx.gltf.scene3d.scene.Scene;
import net.mgsx.gltf.scene3d.scene.SceneAsset;
import net.mgsx.gltf.scene3d.scene.SceneManager;
import net.mgsx.gltf.scene3d.scene.SceneSkybox;
import net.mgsx.gltf.scene3d.utils.IBLBuilder;

/**
 * This class receive a GamePlay and renders it
 *
 * @author gabriel
 */
public class Renderer {

    //Developer mode
    private Boolean debugMode;

    /**
     * sprite batch to draw text
     **/
    private SpriteBatch spriteBatch;

    /**
     * the directional light
     **/
    Environment lights;

    ModelBatch modelBatch;

    /**
     * the background texture
     **/
    private Texture backgroundTexture;

    private final Matrix4 viewMatrix = new Matrix4();

    final Vector3 tmpV = new Vector3();


    //Perspective camera
    private PerspectiveCamera camera;

    //First Person controller
    private FirstPersonCameraController firstPersonCameraController;


    public Renderer() {
        debugMode = true;


        lights = new Environment();
        lights.add(new DirectionalLight().set(Color.WHITE, new Vector3(-1, -0.5f, 0).nor()));

        spriteBatch = new SpriteBatch();
        modelBatch = new ModelBatch();

        backgroundTexture = new Texture(Gdx.files.classpath("net/mgsx/gltf/shaders/brdfLUT.png"));
        backgroundTexture.setFilter(Texture.TextureFilter.MipMap, Texture.TextureFilter.Linear);

//        font = new BitmapFont(Gdx.files.internal("data/font10.fnt"), Gdx.files.internal("data/font10.png"), false);

        camera = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        if (debugMode) {
            firstPersonCameraController = new FirstPersonCameraController(camera);
            Gdx.input.setInputProcessor(firstPersonCameraController);
        }


    }

    public void render(GamePlay gamePlay, float delta) {
        // We explicitly require GL10, otherwise we could've used the GLCommon
        // interface via Gdx.gl

        GL20 gl = Gdx.gl;
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        renderBackground();
        gl.glEnable(GL20.GL_DEPTH_TEST);
        gl.glEnable(GL20.GL_CULL_FACE);


        setProjectionAndCamera();

        modelBatch.begin(firstPersonCameraController);
//        modelBatch.render(simulation.explosions);
//        if (!simulation.ship.isExploding) modelBatch.render(simulation.ship, lights);
        modelBatch.render(gamePlay.player.leftS, lights);
//        modelBatch.render(simulation.blocks);
//        modelBatch.render(simulation.shots);
        modelBatch.end();

        gl.glDisable(GL20.GL_CULL_FACE);
        gl.glDisable(GL20.GL_DEPTH_TEST);

//        spriteBatch.setProjectionMatrix(viewMatrix);
//        spriteBatch.begin();
//        if (simulation.ship.lives != lastLives || simulation.score != lastScore || simulation.wave != lastWave) {
//            status = "lives: " + simulation.ship.lives + " wave: " + simulation.wave + " score: " + simulation.score;
//            lastLives = simulation.ship.lives;
//            lastScore = simulation.score;
//            lastWave = simulation.wave;
//        }
//        spriteBatch.enableBlending();
//        font.draw(spriteBatch, status, 0, 320);
//        spriteBatch.end();

//        invaderAngle += delta * 90;
//        if (invaderAngle > 360) invaderAngle -= 360;


    }

    private void renderBackground() {
        viewMatrix.setToOrtho2D(0, 0, 400, 320);
        spriteBatch.setProjectionMatrix(viewMatrix);
        spriteBatch.begin();
        spriteBatch.disableBlending();
        spriteBatch.setColor(Color.WHITE);
        spriteBatch.draw(backgroundTexture, 0, 0, 480, 320, 0, 0, 512, 512, false, false);
        spriteBatch.end();
    }

    private void setProjectionAndCamera() {

        if (debugMode) {
            firstPersonCameraController.update();
        } else {
        }
            camera.position.set(tmpV.x, 6, 2);
            camera.direction.set(tmpV.x, 0, -4).sub(camera.position).nor();
            camera.update();
    }

}
