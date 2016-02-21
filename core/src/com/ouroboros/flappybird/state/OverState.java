package com.ouroboros.flappybird.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.ouroboros.flappybird.FlappyBirdParameter;

/**
 * Created by Sand on 2/20/2016.
 */
public class OverState extends State {
    private int score;

    public OverState(GameStateManager gsm, int score) {
        super(gsm);
        this.score = score;

        camera.setToOrtho(false, FlappyBirdParameter.WIDTH >> 1, FlappyBirdParameter.HEIGHT >> 1);

        final GameStateManager mng = this.gsm;
        Gdx.input.setInputProcessor(new GestureDetector(new GestureDetector.GestureListener() {
            @Override
            public boolean touchDown(float x, float y, int pointer, int button) {
                return false;
            }

            @Override
            public boolean tap(float x, float y, int count, int button) {
                if (count == 2) {
                    mng.set(new StartState(mng));
                }

                return false;
            }

            @Override
            public boolean longPress(float x, float y) {
                return false;
            }

            @Override
            public boolean fling(float velocityX, float velocityY, int button) {
                return false;
            }

            @Override
            public boolean pan(float x, float y, float deltaX, float deltaY) {
                return false;
            }

            @Override
            public boolean panStop(float x, float y, int pointer, int button) {
                return false;
            }

            @Override
            public boolean zoom(float initialDistance, float distance) {
                return false;
            }

            @Override
            public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
                return false;
            }
        }));
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {
        this.handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);

        sb.begin();

        sb.draw(FlappyBirdParameter.BACKGROUND, 0, 0);
        sb.draw(FlappyBirdParameter.GAME_OVER, camera.position.x - (FlappyBirdParameter.GAME_OVER.getWidth() >> 1),
                camera.position.y + camera.viewportHeight / 8);

        String s = "Score: " + String.valueOf(score);
        GlyphLayout layout = new GlyphLayout(FlappyBirdParameter.FONT, s);
        FlappyBirdParameter.FONT.draw(sb, s, camera.position.x - layout.width / 2, camera.position.y - camera.viewportHeight / 8);

        sb.end();
    }

    @Override
    public void dispose() {

    }
}
