package com.yangyakun.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.yangyakun.game.MyGdxGame;
import com.yangyakun.game.handlers.GameStateManage;

import static com.yangyakun.game.handlers.B2DVars.PPM;

public class Play extends GameState {

    private World world;
    private Box2DDebugRenderer box2DDebugRenderer;

    private OrthographicCamera b2dCamera;

    public Play(GameStateManage gsm) {
        super(gsm);

        world = new World(new Vector2(0,-9.81f),true);
        box2DDebugRenderer = new Box2DDebugRenderer();

        //region 创建地板
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(160/ PPM,120/ PPM);
        bodyDef.type = BodyDef.BodyType.StaticBody;
        Body body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(50/ PPM,5/ PPM);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        body.createFixture(fixtureDef);
        //endregion
        bodyDef.position.set(160/ PPM,200/ PPM);
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(bodyDef);

        shape.setAsBox(5/ PPM,5/ PPM);
        fixtureDef.shape = shape;
        fixtureDef.restitution=0.99f;
        body.createFixture(fixtureDef);

        b2dCamera = new OrthographicCamera();
        b2dCamera.setToOrtho(false, MyGdxGame.V_WIDTH/ PPM, MyGdxGame.V_HEIGHT/ PPM);


    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        world.step(dt,6,2);
    }

    @Override
    public void render() {
        box2DDebugRenderer.render(world,b2dCamera.combined);
    }

    @Override
    public void dispose() {

    }
}
