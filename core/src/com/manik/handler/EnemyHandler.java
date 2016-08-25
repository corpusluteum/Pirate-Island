package com.manik.handler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.manik.gameObject.Enemy;
import com.manik.gameObject.GameWord;
import com.manik.gameObject.Player;
import com.manik.soundLoader.SoundLoader;
import com.manik.states.PlayState;

import java.util.ArrayList;



//Bu kısım enmy yaratma ve sahneden çıktığında kaybolma işlerini yapıyor
public class EnemyHandler {

    private boolean dead=false;
    private int howManyDead=0;
    private ArrayList<Enemy> enemyList;
    private Player player;
    private PlayState playState;

    public EnemyHandler(Player player, PlayState playState)
    {
        this.player=player;
        this.playState=playState;
        enemyList=new ArrayList<Enemy>();
        enemyList.add(new Enemy(player.getPosition().x+Gdx.graphics.getWidth(),player.getPosition().y));
    }

    public void render(SpriteBatch spriteBatch)
    {
        for(int i=0; i<enemyList.size(); i++){
            enemyList.get(i).render(spriteBatch);
        }
    }

    public void update(float delta)
    {
        for(int i=0; i<enemyList.size(); i++){

            if(enemyList.get(i).getPosition().x>player.getPosition().x+Gdx.graphics.getWidth()/2) {
                enemyList.get(i).update(delta);
            }

            //ekrandan çıktığında da (arka taraftan) (sol) kaldır.
            if(enemyList.get(i).getPosition().x<player.getPosition().x-200){
                enemyList.remove(i);
                enemyList.add(new Enemy(player.getPosition().x+400, Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/3)-(Gdx.graphics.getHeight()/12)));
            }
            //vurulduğunda 'collision' öldür ve kaldır. onun yerine altın koy
            if(dead){
                SoundLoader.dead.play();
                enemyList.remove(i);
                if(playState.getLevelStatus()==2){
                    enemyList.add(new Enemy(player.getPosition().x + 2000, Gdx.graphics.getHeight() -
                            (Gdx.graphics.getHeight() / 3) - (Gdx.graphics.getHeight() / 12)));
                }
                else if(playState.getLevelStatus()==3){
                    enemyList.add(new Enemy(player.getPosition().x + 2000, Gdx.graphics.getHeight() -
                            (Gdx.graphics.getHeight() / 3) - (Gdx.graphics.getHeight() / 12)));
                }
                else if(playState.getLevelStatus()==4){
                    enemyList.add(new Enemy(player.getPosition().x + 1500, Gdx.graphics.getHeight() -
                            (Gdx.graphics.getHeight() / 3) - (Gdx.graphics.getHeight() / 12)));
                }
                else if(playState.getLevelStatus()==5){
                    enemyList.add(new Enemy(player.getPosition().x + 1500, Gdx.graphics.getHeight() -
                            (Gdx.graphics.getHeight() / 3) - (Gdx.graphics.getHeight() / 12)));
                }
                else if(playState.getLevelStatus()==6){
                    enemyList.add(new Enemy(player.getPosition().x + 1000, Gdx.graphics.getHeight() -
                            (Gdx.graphics.getHeight() / 3) - (Gdx.graphics.getHeight() / 12)));
                }
                else{
                    enemyList.add(new Enemy(player.getPosition().x + 2500, Gdx.graphics.getHeight() -
                            (Gdx.graphics.getHeight() / 3) - (Gdx.graphics.getHeight() / 12)));
                }
                howManyDead++;
                dead=false;
            }
        }
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public ArrayList<Enemy> getEnemyList() {
        return enemyList;
    }

    public void setEnemyList(ArrayList<Enemy> enemyList) {
        this.enemyList = enemyList;
    }

    public int getHowManyDead() {
        return howManyDead;
    }
}
