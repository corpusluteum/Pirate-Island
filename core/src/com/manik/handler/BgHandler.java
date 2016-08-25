package com.manik.handler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.manik.gameObject.GameWord;
import com.manik.gameObject.Player;
import com.manik.imageLoader.ImageLoader;



//Bu kısım arka plan geçişini saplar
public class BgHandler {

    private TextureRegion bg1,bg2,bg3;
    private float bg1Strt, bg1End, bg2Strt, bg2End, bg3Strt, bg3End;

    private float width, height;
    private SpriteBatch spriteBatch;
    private GameWord gameWord;

    public BgHandler(GameWord gameWord){
        this.gameWord=gameWord;
        width= Gdx.graphics.getWidth();
        height=Gdx.graphics.getHeight();
        bg1= ImageLoader.playBgRegion;
        bg2=ImageLoader.playBgRegion;
        bg3=ImageLoader.playBgRegion;
        bg1Strt=-width;
        bg1End=bg1Strt+width;
        bg2Strt=bg1End;
        bg2End=bg2Strt+width;
        bg3Strt=bg2End;
        bg3End=bg3Strt+width;

    }

    public void render(SpriteBatch spriteBatch){
        this.spriteBatch=spriteBatch;
        spriteBatch.begin();
        spriteBatch.draw(bg1, bg1Strt, 0, width, height);
        spriteBatch.draw(bg2, bg2Strt,0,width,height);
        spriteBatch.draw(bg3, bg3Strt,0,width,height);
        spriteBatch.end();

    }

    public void update(float delta){
        if(gameWord.getPlayer().getPosition().x>bg1Strt && gameWord.getController().isMoveRight()){
            updateCordRight();
        }
        if(gameWord.getPlayer().getPosition().x<bg2Strt && gameWord.getController().isMoveLeft()){
            updateCordLeft();
        }

    }

    public void updateCordRight(){
        bg3Strt=bg1Strt+width;
        bg1Strt=bg3Strt;
        bg2Strt=bg1Strt-width;
        bg3Strt=bg2Strt-width;
    }

    public void updateCordLeft(){
        bg1Strt=bg3Strt-width;
        bg3Strt=bg1Strt;
        bg2Strt=bg1Strt+width;
        bg1Strt=bg2Strt+width;
    }
}
