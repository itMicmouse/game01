package com.yangyakun.game.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.yangyakun.game.MyGdxGame;
import com.yangyakun.game.handlers.GameStateManage;

public abstract class GameState {
    protected SpriteBatch batch;
    protected OrthographicCamera camera;
    protected OrthographicCamera hubCamear;
    protected GameStateManage gsm;
    protected MyGdxGame myGdxGame;

    public GameState(GameStateManage gsm) {
        this.gsm = gsm;
        this.myGdxGame = gsm.getMyGdxGame();
        batch = myGdxGame.getSpriteBatch();
        camera = myGdxGame.getCamera();
        hubCamear = myGdxGame.getHubCamear();
    }

    public abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render();
    public abstract void dispose();



}
