package com.yangyakun.game.handlers;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;

/**
 * 监听dox2d 的碰撞检测
 */
public class MyContactListener implements ContactListener {

    /**
     * 开始碰撞
     * @param contact
     */
    @Override
    public void beginContact(Contact contact) {
        Fixture fixtureA = contact.getFixtureA();
        Fixture fixtureB = contact.getFixtureB();
        System.out.println(fixtureA.getUserData()+"---beginContact--->"+fixtureB.getUserData()+System.currentTimeMillis());
    }

    /**
     * 结束碰撞
     * @param contact
     */
    @Override
    public void endContact(Contact contact) {
        String userDataA = (String) contact.getFixtureA().getUserData();
        String userDataB = (String) contact.getFixtureB().getUserData();
        System.out.println(userDataA+"---endContact--->"+userDataB+System.currentTimeMillis());

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {
        //System.out.println("preSolve");

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {
        //System.out.println("postSolve");

    }
}
