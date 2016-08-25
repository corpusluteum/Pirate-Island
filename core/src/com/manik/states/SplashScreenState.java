package com.manik.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.manik.imageLoader.ImageLoader;



/**
 * Created by manik on 2016.
 */

public class SplashScreenState extends State{

    private StateManager sm;

    private float sayac;

    public SplashScreenState(StateManager sm) {
        super(sm);
        this.sm=sm;

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(ImageLoader.splashScreenRegion, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        sb.end();
    }

    @Override
    public void update(float delta) {
        sayac+=delta;
        if(sayac>5){
            sm.pushState(new MenuState(sm));
        }
    }

    @Override
    public void HandleInput() {
    }

    public StateManager getSm(){
        return sm;
    }


}
