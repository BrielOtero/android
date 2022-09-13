package com.gabriel.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.ModelLoader;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.RenderableProvider;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.loader.ObjLoader;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

public class Test extends ApplicationAdapter {

	private PerspectiveCamera camera;
	public AssetManager assets;
	public ModelBatch modelBatch;
	public Environment environment;
	Model ship;

	@Override
	public void create () {
		modelBatch = new ModelBatch();
		environment = new Environment();
		environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
		environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));

		camera= new PerspectiveCamera(67, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		camera.position.set(7f,7f,7f);
		camera.lookAt(0,0,0);
		camera.near=1f;
		camera.far=300f;
		camera.update();

		assets = new AssetManager();
		assets.load("craft.obj", Model.class);
		ship = assets.get("craft.obj", Model.class);
		//ship.transform.rotate(0,1,0,180);
		//ship.transform.trn(0,0,-2);
	}

	@Override
	public void render () {




		modelBatch.begin(camera);
		modelBatch.render((RenderableProvider) ship, environment);
		modelBatch.end();

	}
	
	@Override
	public void dispose () {

	}

	//private void setProjectionAndCamera(Ship ship){
	//	camera.update();
	//}
}
