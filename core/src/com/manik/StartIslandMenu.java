package com.manik;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.manik.handler.MapStatusHandler;
import com.manik.imageLoader.ImageLoader;
import com.manik.soundLoader.SoundLoader;
import com.manik.states.MenuState;
import com.manik.states.SplashScreenState;
import com.manik.states.StateManager;



public class StartIslandMenu extends Game {

	public static String TITLE="PirateIsland";

	private static StateManager stateManager;
	private SpriteBatch spriteBatch;

	@Override
	public void create () {

		Gdx.gl.glClearColor(0.1f,0.1f,0.1f,1);

		SoundLoader.load();
		ImageLoader.load();
		MapStatusHandler.load();
		spriteBatch=new SpriteBatch();
		stateManager=new StateManager();
		stateManager.pushState(new SplashScreenState(stateManager));
	}

	public void render(){
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stateManager.render(spriteBatch);
		stateManager.update(Gdx.graphics.getDeltaTime());
	}

	public void dispose(){
		ImageLoader.dispose();
		SoundLoader.dispose();
	}
}
