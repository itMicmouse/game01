package com.yangyakun.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.yangyakun.game.handlers.GameStateManage;

public class MyGdxGame extends ApplicationAdapter {


    public static final String TAG = "Bunny";
    public static final String TITLE = "Bunny";
    public static final int V_WIDTH = 320;
    public static final int V_HEIGHT = 240;
    public static final int Scale = 2;

    private SpriteBatch batch;
    private OrthographicCamera camera;
    private OrthographicCamera hubCamear;

    private GameStateManage gsm;

    public static final float STEP = 1/60f;

    private float accum;


    @Override
    public void create () {
        batch = new SpriteBatch();

        camera = new OrthographicCamera();
        camera.setToOrtho(false);
        hubCamear = new OrthographicCamera();
        hubCamear.setToOrtho(false);

        gsm = new GameStateManage(this);
    }

    @Override
    public void render () {
        accum+=Gdx.graphics.getDeltaTime();
        if(accum>STEP){
            accum-=STEP;
            gsm.update(STEP);
            gsm.render();
        }
    }

    @Override
    public void dispose () {

    }

    public SpriteBatch getSpriteBatch() {
        return batch;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public OrthographicCamera getHubCamear() {
        return hubCamear;
    }
}
