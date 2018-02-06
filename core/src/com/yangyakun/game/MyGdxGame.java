package com.yangyakun.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import sun.font.TextRecord;

public class MyGdxGame extends ApplicationAdapter {
    public static final int FRAME_COLS = 5;
    public static final int FRAME_ROW = 6;

    Animation animation;
    Texture walkSheet;
    TextureRegion [] walkFram ;
    SpriteBatch batch;
    TextureRegion curremFram;

    @Override
    public void create() {
        walkSheet = new Texture("animation_sheet.png");

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);//设置背景色
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    }

    @Override
    public void dispose() {

    }
}
