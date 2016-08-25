package com.manik.imageLoader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.manik.StartIslandMenu;



public class ImageLoader {


    public static BitmapFont font;
    public static Texture textFont;

    public static Texture textPlayer1, textPlayer2, textPlayer3, textPlayer4;
    public static TextureRegion playerRegion1 ,playerRegion2, playerRegion3, playerRegion4;

    public static Texture textOnePiece;
    public static TextureRegion onePieceRegion;

    public static Texture textMenu, textPlayBg, textEnemy, textBullet, textBooty, textBigBooty, textSplashScreen, textAboutBg;
    public static TextureRegion menuBgRegion, playBgRegion, bulletRegion, enemyRegion, bootyRegion, bigBootyRegion, splashScreenRegion, aboutBgRegion;

    public static Texture textStartBtn, textAboutBtn, textBackBtn, textLevelBtn, textJumpBtn, textFireBtn , textMoveLeftBtn, textMoveRightBtn, textExitPlayBtn;
    public static TextureRegion startBtnRegion, aboutBtnRegion, levelBtnRegion, backBtnRagion, jumpBtnRegion, fireBtnRegion, moveLeftBtnRegion, moveRightBtnRegion, exitPlayBtnRegion;

    public static Texture textMap, textOptionsBg, textOptionsIsland, textRock;
    public static TextureRegion mapRegion, optionsBgRegion, optionsIslandRegion, rockRegion;

    public static void load(){

        textPlayer1=new Texture(Gdx.files.internal("gameObject/bir.png"));
        textPlayer2=new Texture(Gdx.files.internal("gameObject/iki.png"));
        textPlayer3=new Texture(Gdx.files.internal("gameObject/uc.png"));
        textPlayer4=new Texture(Gdx.files.internal("gameObject/dort.png"));

        font=new BitmapFont(Gdx.files.internal("fonts/gameFont.fnt"),true);
        textFont=new Texture(Gdx.files.internal("fonts/gameFont.png"));
        textFont.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        textMenu=new Texture(Gdx.files.internal("gameObject/menuBackground.jpg"));
        textPlayBg=new Texture(Gdx.files.internal("gameObject/arkaplanTam.jpg"));
        textEnemy=new Texture(Gdx.files.internal("gameObject/enemy1.png"));
        textBullet=new Texture(Gdx.files.internal("gameObject/bullet.png"));
        textBooty=new Texture(Gdx.files.internal("gameObject/booty.png"));
        textBigBooty=new Texture(Gdx.files.internal("gameObject/bootyBig.png"));

        textSplashScreen=new Texture(Gdx.files.internal("gameObject/splashScreen.jpg"));

        textStartBtn=new Texture(Gdx.files.internal("butons/startButton.png"));
        textAboutBtn=new Texture(Gdx.files.internal("butons/aboutButton.png"));
        textLevelBtn=new Texture(Gdx.files.internal("butons/optionsButton.png"));
        textBackBtn=new Texture(Gdx.files.internal("butons/backButton.png"));
        textJumpBtn=new Texture(Gdx.files.internal("butons/jumpButton.png"));
        textFireBtn=new Texture(Gdx.files.internal("butons/fireButton.png"));
        textMoveRightBtn= new Texture(Gdx.files.internal("butons/moveRightButton.png"));
        textMoveLeftBtn= new Texture(Gdx.files.internal("butons/moveLeftButton.png"));
        textExitPlayBtn=new Texture(Gdx.files.internal("butons/exitGame.png"));

        textAboutBg=new Texture(Gdx.files.internal("gameObject/about.jpg"));

        textMap=new Texture(Gdx.files.internal("gameObject/harita.png"));
        textOptionsBg=new Texture(Gdx.files.internal("gameObject/optionsBg.jpg"));
        textOptionsIsland=new Texture(Gdx.files.internal("gameObject/optionsPrite.png"));
        textRock=new Texture(Gdx.files.internal("gameObject/kaya1.png"));

        textOnePiece=new Texture(Gdx.files.internal("gameObject/onePiece.jpg"));
        onePieceRegion= new TextureRegion(textOnePiece,0,0,textOnePiece.getWidth(),textOnePiece.getHeight());
        onePieceRegion.flip(false,true);

        playerRegion1=new TextureRegion(textPlayer1,0,0, textPlayer1.getWidth(), textPlayer1.getHeight());
        playerRegion1.flip(false,true);

        playerRegion2=new TextureRegion(textPlayer2,0,0, textPlayer2.getWidth(), textPlayer2.getHeight());
        playerRegion2.flip(false,true);

        playerRegion3=new TextureRegion(textPlayer3,0,0, textPlayer3.getWidth(), textPlayer3.getHeight());
        playerRegion3.flip(false,true);

        playerRegion4=new TextureRegion(textPlayer4,0,0, textPlayer4.getWidth(), textPlayer4.getHeight());
        playerRegion4.flip(false,true);


        menuBgRegion=new TextureRegion(textMenu,0,0, textMenu.getWidth(),textMenu.getHeight());
        menuBgRegion.flip(false,true);

        playBgRegion=new TextureRegion(textPlayBg,0,0, textPlayBg.getWidth(), textPlayBg.getHeight());
        playBgRegion.flip(false,true);

        bulletRegion=new TextureRegion(textBullet,0,0, textBullet.getWidth(), textBullet.getHeight());
        bulletRegion.flip(false,true);

        enemyRegion=new TextureRegion(textEnemy,0,0, textEnemy.getWidth(), textEnemy.getHeight());
        enemyRegion.flip(false,true);

        startBtnRegion=new TextureRegion(textStartBtn,0,0,textStartBtn.getWidth(),textStartBtn.getHeight());
        startBtnRegion.flip(false,true);

        aboutBtnRegion=new TextureRegion(textAboutBtn,0,0,textAboutBtn.getWidth(),textAboutBtn.getHeight());
        aboutBtnRegion.flip(false,true);

        levelBtnRegion=new TextureRegion(textLevelBtn,0,0,textLevelBtn.getWidth(),textLevelBtn.getHeight());
        levelBtnRegion.flip(false,true);

        backBtnRagion=new TextureRegion(textBackBtn,0,0,textBackBtn.getWidth(),textBackBtn.getHeight());
        backBtnRagion.flip(false,true);

        jumpBtnRegion=new TextureRegion(textJumpBtn,0,0,textJumpBtn.getWidth(),textJumpBtn.getHeight());
        jumpBtnRegion.flip(false,true);

        fireBtnRegion=new TextureRegion(textFireBtn,0,0,textFireBtn.getWidth(),textFireBtn.getHeight());
        fireBtnRegion.flip(false,true);

        moveRightBtnRegion=new TextureRegion(textMoveRightBtn,0,0,textMoveRightBtn.getWidth(),textMoveRightBtn.getHeight());
        moveRightBtnRegion.flip(false,true);

        moveLeftBtnRegion=new TextureRegion(textMoveLeftBtn,0,0,textMoveLeftBtn.getWidth(), textMoveLeftBtn.getHeight());
        moveLeftBtnRegion.flip(false,true);

        exitPlayBtnRegion=new TextureRegion(textExitPlayBtn,0,0,textExitPlayBtn.getWidth(), textExitPlayBtn.getHeight());
        exitPlayBtnRegion.flip(false,true);

        bootyRegion=new TextureRegion(textBooty,0,0,textBooty.getWidth(),textBooty.getHeight());
        bootyRegion.flip(false,true);

        bigBootyRegion=new TextureRegion(textBigBooty,0,0,textBigBooty.getWidth(),textBigBooty.getHeight());
        bigBootyRegion.flip(false,true);

        splashScreenRegion=new TextureRegion(textSplashScreen,0,0, textSplashScreen.getWidth(), textSplashScreen.getHeight());

        aboutBgRegion=new TextureRegion(textAboutBg,0,0, textAboutBg.getWidth(), textAboutBg.getHeight());
        aboutBgRegion.flip(false,true);

        mapRegion=new TextureRegion(textMap,0,0,textMap.getWidth(),textMap.getHeight());
        mapRegion.flip(false,true);

        optionsBgRegion=new TextureRegion(textOptionsBg,0,0,textOptionsBg.getWidth(),textOptionsBg.getHeight());
        optionsBgRegion.flip(false,true);

        optionsIslandRegion=new TextureRegion(textOptionsIsland,0,0,textOptionsIsland.getWidth(), textOptionsBg.getHeight());
        optionsIslandRegion.flip(false,true);

        rockRegion=new TextureRegion(textRock,0,0,textRock.getWidth(),textRock.getHeight());
        rockRegion.flip(false,true);

    }
    public static void dispose(){

        textPlayer1.dispose();
        textPlayer2.dispose();
        textPlayer3.dispose();
        textPlayer4.dispose();

        font.dispose();
        textFont.dispose();
        textMenu.dispose();
        textPlayBg.dispose();
        textEnemy.dispose();
        textBullet.dispose();
        textBooty.dispose();
        textBigBooty.dispose();
        textStartBtn.dispose();
        textAboutBtn.dispose();
        textLevelBtn.dispose();
        textBackBtn.dispose();
        textJumpBtn.dispose();
        textFireBtn.dispose();
        textMoveRightBtn.dispose();
        textMoveLeftBtn.dispose();
        textExitPlayBtn.dispose();
        textMap.dispose();
        textOptionsBg.dispose();
        textOptionsIsland.dispose();
        textRock.dispose();
        textSplashScreen.dispose();
    }
}
