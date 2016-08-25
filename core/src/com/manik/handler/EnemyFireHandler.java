package com.manik.handler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.manik.gameObject.EnemyFire;
import com.manik.gameObject.Player;
import com.manik.imageLoader.ImageLoader;
import com.manik.soundLoader.SoundLoader;
import com.manik.states.PlayState;

import java.util.ArrayList;




public class EnemyFireHandler {

    private boolean stopABullet=false, approach=false;

    private PlayState playState;

    private ArrayList<EnemyFire> fireList;
    private Player player;

    public EnemyFireHandler(Player player,PlayState playState)
    {
        this.playState=playState;
        this.player=player;
        fireList=new ArrayList<EnemyFire>();
    }

    public void render(SpriteBatch spriteBatch)
    {
        for(int i=0; i<fireList.size(); i++){
            fireList.get(i).render(spriteBatch);
        }
    }

    public void update(float delta)
    {
        for(int i=0; i<fireList.size(); i++){
            fireList.get(i).update(delta);

            if(fireList.get(i).getFirePosition().x<player.getPosition().x-400){
                fireList.remove(i);
            }
            if(stopABullet){
                fireList.remove(i);
                stopABullet=false;
            }
        }
        for(int i=0; i<playState.getGameWord().getEnemyHandler().getEnemyList().size(); i++){
            if(playState.getGameWord().getEnemyHandler().getEnemyList().get(i).getPosition().x<player.getPosition().x+(Gdx.graphics.getWidth()-50) && fireList.size()==0) {
                fireList.add(new EnemyFire((playState.getGameWord().getEnemyHandler().getEnemyList().get(0).getPosition().x) -10, (playState.getGameWord().getEnemyHandler().getEnemyList().get(0).getPosition().y) + 40 ));
                SoundLoader.bangSoundPlayer.play();
            }
        }

    }

    public ArrayList<EnemyFire> getFireList() {
        return fireList;
    }

    public void setFireList(ArrayList<EnemyFire> fireList) {
        this.fireList = fireList;
    }

    public boolean isApproach() {
        return approach;
    }

    public void setApproach(boolean approach) {
        this.approach = approach;
    }

    public boolean isStopABullet() {
        return stopABullet;
    }

    public void setStopABullet(boolean stopABullet) {
        this.stopABullet = stopABullet;
    }
}
