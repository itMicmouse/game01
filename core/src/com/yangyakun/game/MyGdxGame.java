package com.yangyakun.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import sun.font.TextRecord;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;

	TextureRegion textureRegion;

	Sprite sprite;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		textureRegion = new TextureRegion(img,0,0,24,24);
		sprite = new Sprite();
		sprite.setRegion(img);
		sprite.setSize(120,120);
		sprite.setOrigin(100,100);
		sprite.setRotation(20);
		sprite.setPosition(110,110);
		sprite.setColor(1,0,1,1);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);//设置背景色
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(textureRegion,0,0);
		batch.draw(img,24,24);
		sprite.draw(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
