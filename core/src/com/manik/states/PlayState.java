package com.manik.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.manik.collision.Collision;
import com.manik.drawer.BulletScoreDrawer;
import com.manik.drawer.PowerDrawer;
import com.manik.gameObject.GameWord;
import com.manik.drawer.GoldScoreDrawer;
import com.manik.gameObject.Player;
import com.manik.handler.MapStatusHandler;
import com.manik.inputHandler.PlayInputHandler;
import com.manik.soundLoader.SoundLoader;

import java.util.Random;

/**
 * Created by manik on 2016.
 */

public class PlayState extends State {

    private GameWord gameWord;
    private StateManager sm;

    private OrthographicCamera cam;

    private int goldScore=0;
    private GoldScoreDrawer goldScoreDrawer;

    private int bulletScore=10;
    private BulletScoreDrawer bulletScoreDrawer;

    private int power=100;
    private PowerDrawer powerDrawer;

    private int levelStatus;

    private boolean enemyForce=true;
    private boolean enemyCollision=false;
    private boolean playerBulletCollision=false;
    private boolean gameOver=false;

    public PlayState(StateManager sm, float level, boolean map)
    {
        super(sm);
        cam=camera;
        goldScoreDrawer=new GoldScoreDrawer(this);
        bulletScoreDrawer=new BulletScoreDrawer(this);
        powerDrawer=new PowerDrawer(this);
        gameWord=new GameWord(this);
        Gdx.input.setInputProcessor(new PlayInputHandler(this));
        //SoundLoader.playSound.setLooping(0,true);
        SoundLoader.playSound.loop();
        SoundLoader.playSound.play();
        if(!map){
            if(!MapStatusHandler.getLevelOne()){
                levelStatus=1;
            }
            else if(!MapStatusHandler.getLevelTwo()){
                levelStatus=2;
            }
            else if(!MapStatusHandler.getLevelThree()){
                levelStatus=3;
            }
            else if(!MapStatusHandler.getLevelFour()){
                levelStatus=4;
            }
            else if(!MapStatusHandler.getLevelFive()){
                levelStatus=5;
            }
            else if(!MapStatusHandler.getLevelSix()){
                levelStatus=6;
            }
        }
        else{
            levelStatus=(int)level;
        }

        this.sm=sm;
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);

        sb.begin();
        sb.end();
        gameWord.render(sb);
        goldScoreDrawer.render(sb);
        bulletScoreDrawer.render(sb);
        powerDrawer.render(sb);
    }

    @Override
    public void update(float delta) {
        gameWord.update(delta);
        updateCamera();

        //player ile düşmanın çarpışması
        if(Collision.isThereCollision(gameWord.getPlayer(),gameWord.getEnemyHandler()))
        {
            sm.pushState(new GameOverState(sm));
            SoundLoader.playSound.stop();
        }

        //mermi ile düşmanın çarpışması
        if(Collision.isThereCollision(gameWord.getPlayerFireHandler(),gameWord.getEnemyHandler()))
        {
            enemyCollision=true;
            if(enemyForce){
                gameWord.getPlayerFireHandler().setDead(true);
                gameWord.getEnemyHandler().setDead(true);
                gameWord.getGoldHandler().setEnemyDead(true);
                enemyForce=false;
            }
            else{
                gameWord.getPlayerFireHandler().setDead(true);
                SoundLoader.bisey.play();
            }
        }

        //mermi ile playerın çarpışması
        if(Collision.isThereCollision(gameWord.getEnemyFireHandler(),gameWord.getPlayer())){
            playerBulletCollision=true;
            gameWord.getEnemyFireHandler().setStopABullet(true);
            SoundLoader.hitBullet.play();
        }

        //altın ile playerın çarpışması
        if(Collision.isThereCollision(gameWord.getGoldHandler(),gameWord.getPlayer())){
            gameWord.getGoldHandler().setPlayerCollision(true);
        }
        //player yılanın üztüne bastı
        if(Collision.isThereCollision(gameWord.getRockHandler(), gameWord.getPlayer())){
            gameWord.getController().setCollisionRock(true);
        }

        //toplanan harita kontrolü
        if(Collision.isThereCollision(gameWord.getTreasureMap(),gameWord.getPlayer())){
            MapStatusHandler.setStatus(levelStatus);
            sm.pushState(new MenuState(sm));
            SoundLoader.playSound.stop();
        }

        if(gameOver){
            sm.pushState(new GameOverState(sm));
            SoundLoader.playSound.stop();
        }
        if(MapStatusHandler.getLevelOne() && MapStatusHandler.getLevelTwo() && MapStatusHandler.getLevelThree() && MapStatusHandler.getLevelFour()
                && MapStatusHandler.getLevelFive() && MapStatusHandler.getLevelSix()){
            SoundLoader.playSound.stop();
            MapStatusHandler.levelRestart();
            sm.pushState(new OnePiece(sm));
        }
    }

    public void updateCamera(){

        //player hareket halindeyken kameranın onu takip etmesi. Butonların hareketi.
        if(getGameWord().getController().isMoveLeft() || getGameWord().getController().isMoveRight()){

            //ileriye doğru hareket
            if(gameWord.getPlayer().getPosition().x<camera.position.x-Gdx.graphics.getWidth()/5){
                camera.position.x+=gameWord.getPlayer().getSpeed().x;

                getGameWord().getBangButton().setSpeedx(gameWord.getPlayer().getSpeed().x);
                getGameWord().getJumpButton().setSpeedx(gameWord.getPlayer().getSpeed().x);
                getGameWord().getMoveRightBtn().setSpeedx(gameWord.getPlayer().getSpeed().x);
                getGameWord().getMoveLeftBtn().setSpeedx(gameWord.getPlayer().getSpeed().x);
                getGameWord().getExitPlayBtn().setSpeedx(gameWord.getPlayer().getSpeed().x);
            }
            //geriye doğru hareket
            if(gameWord.getPlayer().getPosition().x>camera.position.x+Gdx.graphics.getWidth()/5){
                camera.position.x+=gameWord.getPlayer().getSpeed().x;

                getGameWord().getBangButton().setSpeedx(gameWord.getPlayer().getSpeed().x);
                getGameWord().getJumpButton().setSpeedx(gameWord.getPlayer().getSpeed().x);
                getGameWord().getMoveRightBtn().setSpeedx(gameWord.getPlayer().getSpeed().x);
                getGameWord().getMoveLeftBtn().setSpeedx(gameWord.getPlayer().getSpeed().x);
                getGameWord().getExitPlayBtn().setSpeedx(gameWord.getPlayer().getSpeed().x);
            }
        }
        camera.update();
    }

    @Override
    public void HandleInput() {
    }

    public GameWord getGameWord(){
        return gameWord;
    }

    public StateManager getSm(){
        return sm;
    }

    public int getGoldScore() {
        return goldScore;
    }

    public void setGoldScore(int goldScore) {
        this.goldScore = goldScore;
    }

    public OrthographicCamera getCam() {
        return cam;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getBulletScore() {
        return bulletScore;
    }

    public void setBulletScore(int bulletScore) {
        this.bulletScore = bulletScore;
    }

    public boolean isEnemyCollision() {
        return enemyCollision;
    }

    public void setEnemyCollision(boolean enemyCollision) {
        this.enemyCollision = enemyCollision;
    }

    public boolean isEnemyForce() {
        return enemyForce;
    }

    public void setEnemyForce(boolean enemyForce) {
        this.enemyForce = enemyForce;
    }

    public boolean isPlayerBulletCollision() {
        return playerBulletCollision;
    }

    public void setPlayerBulletCollision(boolean playerBulletCollision) {
        this.playerBulletCollision = playerBulletCollision;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public int getLevelStatus() {
        return levelStatus;
    }
}
