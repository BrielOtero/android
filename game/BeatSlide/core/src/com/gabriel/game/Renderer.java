package com.gabriel.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Cubemap;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.utils.FirstPersonCameraController;
import com.gabriel.game.game.GamePlay;
import com.gabriel.game.game.Player;

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

    //Scene Manager
    private SceneManager sceneManager;

    //Scene Asset
    private SceneAsset sceneAsset;

    //Scene
    private Scene scene;

    //Perspective camera
    private PerspectiveCamera camera;

    //First Person controller
    private FirstPersonCameraController firstPersonCameraController;


    private Cubemap diffuseCubemap;
    private Cubemap environmentCubemap;
    private Cubemap specularCubemap;
    private Texture brdfLUT;
    private float time;
    private SceneSkybox skybox;
    private DirectionalLightEx light;


    public Renderer() {
        debugMode=true;

        sceneAsset = new GLTFLoader().load(Gdx.files.internal("models/saber-blue.gltf"));
        scene = new Scene(sceneAsset.scene);
        sceneManager = new SceneManager();
        sceneManager.addScene(scene);

        camera = new PerspectiveCamera(60f, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        float d = .02f;
        camera.near = d / 1000f;
        camera.far = 200;
        sceneManager.setCamera(camera);

        if (debugMode) {
            firstPersonCameraController = new FirstPersonCameraController(camera);
            Gdx.input.setInputProcessor(firstPersonCameraController);
        }

        // setup light
        light = new DirectionalLightEx();
        light.direction.set(1, -3, 1).nor();
        light.color.set(Color.WHITE);
        sceneManager.environment.add(light);

        // setup quick IBL (image based lighting)
        IBLBuilder iblBuilder = IBLBuilder.createOutdoor(light);
        environmentCubemap = iblBuilder.buildEnvMap(1024);
        diffuseCubemap = iblBuilder.buildIrradianceMap(256);
        specularCubemap = iblBuilder.buildRadianceMap(10);
        iblBuilder.dispose();

        // This texture is provided by the library, no need to have it in your assets.
        brdfLUT = new Texture(Gdx.files.classpath("net/mgsx/gltf/shaders/brdfLUT.png"));

        sceneManager.setAmbientLight(1f);
        sceneManager.environment.set(new PBRTextureAttribute(PBRTextureAttribute.BRDFLUTTexture, brdfLUT));
        sceneManager.environment.set(PBRCubemapAttribute.createSpecularEnv(specularCubemap));
        sceneManager.environment.set(PBRCubemapAttribute.createDiffuseEnv(diffuseCubemap));

        // setup skybox
        skybox = new SceneSkybox(environmentCubemap);
        sceneManager.setSkyBox(skybox);



    }

    public void render(GamePlay gamePlay, float delta){
//        GL20 gl = Gdx.gl;
//        gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
////        renderBackground();
//        gl.glEnable(GL20.GL_DEPTH_TEST);
//        gl.glEnable(GL20.GL_CULL_FACE);
////        setProjectionAndCamera(gamePlay.player);

        float deltaTime = Gdx.graphics.getDeltaTime();
        time += deltaTime;

        firstPersonCameraController.update();

        // animate camera
//        camera.position.setFromSpherical(MathUtils.PI / 4, time * .3f).scl(.02f);
//        camera.up.set(Vector3.Y);
//        camera.lookAt(Vector3.Zero);
//        camera.update();

        // render
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        sceneManager.update(deltaTime);
        sceneManager.render();
    }

    private void setProjectionAndCamera(Player player){

    }

}
