package com.manik.gameObject;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.manik.imageLoader.ImageLoader;


public class TreasureMap implements GameObject{

    private Vector2 mapPosition;
    private Vector2 size;
    private Rectangle collisionRect;

    private boolean current=true;
    private GameWord gameWord;
    private SpriteBatch sb;


    public TreasureMap(GameWord gameWord){
        sb= new SpriteBatch();
        this.gameWord=gameWord;
        size=new Vector2(60,60);
        mapPosition=new Vector2();
        mapPosition.x = (-100);
        mapPosition.y = 0;
        collisionRect = new Rectangle(mapPosition.x,mapPosition.y,size.x,size.y);
    }

    @Override
    public void render(SpriteBatch sb) {

        this.sb=sb;
    }

    @Override
    public void update(float delta) {

        if(gameWord.getEnemyHandler().getHowManyDead()>10 && current){
            mapPosition.x = gameWord.getPlayer().getPosition().x+1000;
            mapPosition.y = gameWord.getPlayer().getPosition().y;
            current=false;
        }
        sb.begin();
        sb.draw(ImageLoader.mapRegion,mapPosition.x,mapPosition.y,size.x,size.y);
        sb.end();
        collisionRect.x=mapPosition.x;
        collisionRect.y=mapPosition.y;
    }

    public Rectangle getCollisionRect() {
        return collisionRect;
    }

    public void setCollisionRect(Rectangle collisionRect) {
        this.collisionRect = collisionRect;
    }
}
