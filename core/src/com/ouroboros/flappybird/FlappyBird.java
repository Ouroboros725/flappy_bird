package com.ouroboros.flappybird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ouroboros.flappybird.state.GameStateManager;
import com.ouroboros.flappybird.state.StartState;

public class FlappyBird extends ApplicationAdapter {
    private SpriteBatch batch;

    private GameStateManager gsm;

    @Override
    public void create() {
        batch = new SpriteBatch();

        this.gsm = new GameStateManager();
        this.gsm.push(new StartState(this.gsm));

        FlappyBirdParameter.MUSIC.play();

        Gdx.gl.glClearColor(1, 0, 0, 1);
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        this.gsm.update(Gdx.graphics.getDeltaTime());
        this.gsm.render(this.batch);
    }

    @Override
    public void dispose() {
        super.dispose();

        this.batch.dispose();
        FlappyBirdParameter.disposeResources();
    }
}
