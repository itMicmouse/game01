package com.yangyakun.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.yangyakun.game.MyGdxGame;
import com.yangyakun.game.handlers.GameStateManage;
import com.yangyakun.game.handlers.MyContactListener;
import com.yangyakun.game.handlers.MyInput;

import static com.yangyakun.game.handlers.B2DVars.PPM;

public class Play extends GameState {

    private World world;
    private Box2DDebugRenderer box2DDebugRenderer;

    /**
     * 创建box2D的相机
     */
    private OrthographicCamera b2dCamera;

    public Play(GameStateManage gsm) {
        super(gsm);
        /**
         * 创建世界
         */
        world = new World(new Vector2(0,-4.81f),true);
        /**
         * 渲染器
         */
        box2DDebugRenderer = new Box2DDebugRenderer();

        world.setContactListener(new MyContactListener());

        //region 创建地板
        //定义物体的属性
        BodyDef bodyDef = new BodyDef();
        //设置坐标
        bodyDef.position.set(160/ PPM,120/ PPM);
        //静态刚体
        bodyDef.type = BodyDef.BodyType.StaticBody;
        //创建刚体
        Body body = world.createBody(bodyDef);
        //创建一个多边形
        PolygonShape shape = new PolygonShape();
        //设置长方形
        shape.setAsBox(500/ PPM,5/ PPM);
        //夹具的属性
        FixtureDef fixtureDef = new FixtureDef();
        //在夹具重设置图形
        fixtureDef.shape = shape;
        //刚体设置夹具
        body.createFixture(fixtureDef).setUserData("full");
        //endregion

        //region 设置动态刚体  正方形
        bodyDef.position.set(160/ PPM,200/ PPM);
        //设置动态刚体
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        //创建刚体
        body = world.createBody(bodyDef);
        //设置多边形
        shape.setAsBox(5/ PPM,5/ PPM);
        fixtureDef.shape = shape;
        //设置反弹力
        fixtureDef.restitution=0.5f;
        body.createFixture(fixtureDef).setUserData("box");
        //endregion

        //region 创建动态刚体 圆
        bodyDef.position.set(153/PPM,225/PPM);
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(bodyDef);

        CircleShape circleShape = new CircleShape();
        circleShape.setRadius(5/PPM);
        fixtureDef.shape = circleShape;
        fixtureDef.restitution=0.4f;
        body.createFixture(fixtureDef).setUserData("circle");
        //endregion

        b2dCamera = new OrthographicCamera();
        //像素转换为米
        b2dCamera.setToOrtho(false, MyGdxGame.V_WIDTH/ PPM, MyGdxGame.V_HEIGHT/ PPM);


    }

    @Override
    public void handleInput() {
        if(MyInput.isPress(MyInput.BUTTON1)){
            System.out.println("z被按下");
        }

        if(MyInput.isPress(MyInput.BUTTON2)){
            System.out.println("x被按下");
        }
    }

    @Override
    public void update(float dt) {
        /**
         * 清屏操作
         */
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);

        handleInput();

        /**
         * 更新物理世界
         * dt 游戏渲染世界相同
         * 水平方向速度迭代只  6
         * 位置迭代   2
         */
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
