package com.vishalg.vishblaster;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class MyGdxGame extends ApplicationAdapter {

    private SpriteBatch batch;
    private TextureAtlas runnerAtlas;
    private Animation animation;
    private float timePassesd = 0;





    @Override
    public void create() {
        batch = new SpriteBatch();

        runnerAtlas = new TextureAtlas(Gdx.files.internal("runner.atlas"));
        animation = new Animation(1/10f, runnerAtlas.getRegions());



    }

    @Override
    public void dispose(){
        batch.dispose();
        runnerAtlas.dispose();

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        timePassesd += Gdx.graphics.getRawDeltaTime();
        batch.draw(animation.getKeyFrame(timePassesd, true),0, 0);
        batch.end();
    }
}
