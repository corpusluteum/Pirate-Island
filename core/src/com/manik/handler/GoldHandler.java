package com.manik.handler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.manik.gameObject.Bullet;
import com.manik.gameObject.Gold;
import com.manik.gameObject.Player;
import com.manik.soundLoader.SoundLoader;
import com.manik.states.PlayState;

import java.util.ArrayList;




public class GoldHandler {

    private boolean enemyDead=false;
    private boolean playerCollision;
    private ArrayList<Gold> goldList;
    private boolean wichgold=false;
    private PlayState playState;

    public GoldHandler(PlayState playState)
    {
        this.playState=playState;
        goldList=new ArrayList<Gold>();
        goldList.add(new Gold(wichgold, Gdx.graphics.getWidth(), 100));
    }

    public void render(SpriteBatch spriteBatch)
    {
        for(int i=0; i<goldList.size(); i++){
            goldList.get(i).render(spriteBatch);
        }
    }

    public void update(float delta)
    {
        for(int i=0; i<goldList.size(); i++){
            goldList.get(i).update(delta);

            if(playerCollision){
                goldList.remove(i);
                playerCollision=false;
            }
        }
        if(enemyDead) {
            goldList.add(new Gold(wichgold, (playState.getGameWord().getEnemyHandler().getEnemyList().get(0).getPosition().x), (playState.getGameWord().getEnemyHandler().getEnemyList().get(0).getPosition().y) -100));
            enemyDead=false;
        }
    }
    public boolean isEnemyDead() {
        return enemyDead;
    }

    public void setEnemyDead(boolean enemyDead) {
        this.enemyDead = enemyDead;
    }

    public ArrayList<Gold> getGoldList() {
        return goldList;
    }

    public void setGoldList(ArrayList<Gold> goldList) {
        this.goldList = goldList;
    }

    public boolean isPlayerCollision() {
        return playerCollision;
    }

    public void setPlayerCollision(boolean playerCollision) {
        this.playerCollision = playerCollision;
    }

    public boolean isWichgold() {
        return wichgold;
    }

    public void setWichgold(boolean wichgold) {
        this.wichgold = wichgold;
    }
}
