package com.manik.gameObject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.manik.buttons.Button;
import com.manik.controller.Controller;
import com.manik.controller.Scoring;
import com.manik.handler.BgHandler;
import com.manik.handler.EnemyFireHandler;
import com.manik.handler.EnemyHandler;
import com.manik.handler.GoldHandler;
import com.manik.handler.PlayerFireHandler;
import com.manik.handler.RockHandler;
import com.manik.imageLoader.ImageLoader;
import com.manik.states.PlayState;


public class GameWord implements GameObject {

    private Player player;
    private Controller controller;
    private Scoring scoring;
    private BgHandler bgHandler;
    private EnemyHandler enemyHandler;
    private PlayerFireHandler playerFireHandler;
    private GoldHandler goldHandler;
    private RockHandler rockHandler;
    private EnemyFireHandler enemyFireHandler;
    private Button bangButton,jumpButton, moveRightBtn, moveLeftBtn, exitPlayBtn;
    private TreasureMap treasureMap;

    private PlayState playState;

    public GameWord(PlayState playState){
        this.playState=playState;

        controller=new Controller(this,playState);
        scoring=new Scoring(playState);
        player=new Player(50,Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/3)-(Gdx.graphics.getHeight()/13),Gdx.graphics.getHeight()/6,Gdx.graphics.getHeight()/5,controller);
        bgHandler=new BgHandler(this);
        enemyFireHandler=new EnemyFireHandler(player,playState);
        enemyHandler=new EnemyHandler(player, playState);
        playerFireHandler=new PlayerFireHandler(player, playState);
        goldHandler=new GoldHandler(playState);
        rockHandler=new RockHandler(playState);
        treasureMap=new TreasureMap(this);
        jumpButton=new Button(100,70,20,(float) (Gdx.graphics.getHeight()-(90)),ImageLoader.jumpBtnRegion);
        bangButton=new Button(100,70,140, (float) (Gdx.graphics.getHeight()-(90)), ImageLoader.fireBtnRegion);
        moveRightBtn=new Button(100,70,Gdx.graphics.getWidth()- 90, (float) (Gdx.graphics.getHeight()-(90)), ImageLoader.moveRightBtnRegion);
        moveLeftBtn=new Button(100,70, Gdx.graphics.getWidth()- 200,(float) (Gdx.graphics.getHeight()-(90)), ImageLoader.moveLeftBtnRegion );
        exitPlayBtn=new Button(70,50, Gdx.graphics.getWidth()- 90, 50, ImageLoader.exitPlayBtnRegion);
    }

    @Override
    public void render(SpriteBatch sb) {
        bgHandler.render(sb);
        player.render(sb);
        controller.render();
        scoring.render();
        enemyHandler.render(sb);
        bangButton.render(sb);
        jumpButton.render(sb);
        moveRightBtn.render(sb);
        moveLeftBtn.render(sb);
        exitPlayBtn.render(sb);
        playerFireHandler.render(sb);
        goldHandler.render(sb);
        rockHandler.render(sb);
        enemyFireHandler.render(sb);
        treasureMap.render(sb);
    }

    @Override
    public void update(float delta) {
        bgHandler.update(delta);
        player.update(delta);
        controller.update(delta);
        scoring.update(delta);
        enemyHandler.update(delta);
        bangButton.update(delta);
        jumpButton.update(delta);
        moveRightBtn.update(delta);
        moveLeftBtn.update(delta);
        exitPlayBtn.update(delta);
        playerFireHandler.update(delta);
        goldHandler.update(delta);
        rockHandler.update(delta);
        enemyFireHandler.update(delta);
        treasureMap.update(delta);
    }

    public Player getPlayer(){
        return player;
    }

    public Controller getController() {
        return controller;
    }

    public Scoring getScoring(){ return scoring; }

    public EnemyHandler getEnemyHandler() {
        return enemyHandler;
    }

    public Button getBangButton(){ return bangButton; }

    public Button getJumpButton(){return jumpButton; }

    public Button getMoveRightBtn() {
        return moveRightBtn;
    }

    public Button getMoveLeftBtn() {
        return moveLeftBtn;
    }

    public Button getExitPlayBtn() {
        return exitPlayBtn;
    }

    public PlayerFireHandler getPlayerFireHandler(){ return playerFireHandler; }

    public GoldHandler getGoldHandler(){ return goldHandler; }

    public EnemyFireHandler getEnemyFireHandler(){ return  enemyFireHandler; }

    public TreasureMap getTreasureMap(){ return treasureMap; }

    public RockHandler getRockHandler() {
        return rockHandler;
    }
}
