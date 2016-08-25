package com.manik.handler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.manik.gameObject.Bullet;
import com.manik.gameObject.Player;
import com.manik.imageLoader.ImageLoader;
import com.manik.soundLoader.SoundLoader;
import com.manik.states.PlayState;

import java.util.ArrayList;

public class PlayerFireHandler {

    private boolean bang=false, dead=false;

    private ArrayList<Bullet> bulletList;
    private Player player;
    private PlayState playState;

    private boolean bullet=true;

    public PlayerFireHandler(Player player, PlayState playState)
    {
        this.playState=playState;
        this.player=player;
        bulletList=new ArrayList<Bullet>();
    }

    public void render(SpriteBatch spriteBatch)
    {
        for(int i=0; i<bulletList.size(); i++){
            bulletList.get(i).render(spriteBatch);
        }
    }

    public void update(float delta)
    {
        for(int i=0; i<bulletList.size(); i++){
            bulletList.get(i).update(delta);

            if(bulletList.get(i).getBulletPosition().x> player.getPosition().x+ Gdx.graphics.getWidth()){
                if(bulletList.size()>0) {
                    bulletList.remove(i);
                }
            }
            if(dead){
                if(bulletList.size()>0) {
                    bulletList.remove(i);
                }
                dead=false;
            }
        }
        if(bang && bullet) {
            bulletList.add(new Bullet(player.getPosition().x + (ImageLoader.playerRegion1.getRegionWidth() / 2), player.getPosition().y + (ImageLoader.playerRegion1.getRegionHeight() / 4)));
            bang=false;
            SoundLoader.bangSoundPlayer.play();
        }
    }

    public ArrayList<Bullet> getBulletList() {
        return bulletList;
    }

    public void setBulletList(ArrayList<Bullet> bulletList) {
        this.bulletList = bulletList;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public boolean isBang() {
        return bang;
    }

    public void setBang(boolean bang) {
        this.bang = bang;
    }

    public boolean isBullet() {
        return bullet;
    }

    public void setBullet(boolean bullet) {
        this.bullet = bullet;
    }

}
