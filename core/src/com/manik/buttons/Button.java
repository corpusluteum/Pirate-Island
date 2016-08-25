package com.manik.buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.manik.gameObject.GameObject;
import com.manik.gameObject.Player;
import com.manik.imageLoader.ImageLoader;


public class Button implements GameObject {

    private TextureRegion btnImage;
    private float xKoor, yKoor, width, height;
    private float speedx=0;
    private Rectangle btnRect;

    public Button(float width, float height, float xKoor, float yKoor, TextureRegion btnImage){
        this.width=width;
        this.height=height;
        this.xKoor=xKoor;
        this.yKoor=yKoor;
        this.btnImage=btnImage;
        btnRect=new Rectangle(xKoor,yKoor,width,height);
    }
    //geri butonları
    public Button()
    {
        width=Gdx.graphics.getWidth()/3;
        height= (float) (width*0.3);
        this.xKoor=(Gdx.graphics.getWidth()-width)-10;
        this.yKoor=(Gdx.graphics.getHeight()-height)-10;
        btnRect=new Rectangle(xKoor,yKoor,width,height);
        this.btnImage=ImageLoader.backBtnRagion;
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(btnImage,xKoor,yKoor,width,height);
        sb.end();
    }

    @Override
    public void update(float delta) {
        xKoor += speedx;
    }

    public Rectangle getBtnRect(){
        return btnRect;
    }

    public void setSpeedx(float speedx) {
        this.speedx = speedx;
    }
}
