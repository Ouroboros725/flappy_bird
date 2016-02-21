package com.ouroboros.flappybird.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.ouroboros.flappybird.FlappyBirdParameter;
import com.ouroboros.flappybird.sprite.Bird;
import com.ouroboros.flappybird.sprite.Ground;
import com.ouroboros.flappybird.sprite.Tube;

/**
 * Created by Sand on 2/17/2016.
 */
public class PlayState extends State {
    private Bird bird;
    private Array<Tube> tubes;
    private Array<Ground> grounds;
    private int score;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        bird = new Bird(50, 375);
        tubes = new Array<Tube>(FlappyBirdParameter.TUBE_COUNT);
        for (int i = 0; i < FlappyBirdParameter.TUBE_COUNT; i++) {
            tubes.add(new Tube((i + 1) * (FlappyBirdParameter.TUBE_SPACING + FlappyBirdParameter.TOP_TUBE.getWidth())));
        }
        grounds = new Array<Ground>(FlappyBirdParameter.GROUND_COUNT);
        for (int i = 0; i < FlappyBirdParameter.GROUND_COUNT; i++) {
            grounds.add(new Ground(camera.position.x - camera.viewportWidth / 2 + i * FlappyBirdParameter.GROUND.getWidth()));
        }

        camera.setToOrtho(false, FlappyBirdParameter.WIDTH >> 1, FlappyBirdParameter.HEIGHT >> 1);

        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()) {
            this.bird.flyUp();
        }
    }

    @Override
    public void update(float dt) {
        this.handleInput();
        this.bird.update(dt);

        score = (int) ((bird.getPosition().x - FlappyBirdParameter.TOP_TUBE.getWidth())
                / (FlappyBirdParameter.TUBE_SPACING + FlappyBirdParameter.TOP_TUBE.getWidth()));

        for (Tube tube : tubes) {
            if ((camera.position.x - camera.viewportWidth / 2) >
                    (tube.getPosTopTube().x + FlappyBirdParameter.TOP_TUBE.getWidth())) {
                tube.reposition(tube.getPosTopTube().x + (FlappyBirdParameter.TUBE_SPACING
                        + FlappyBirdParameter.TOP_TUBE.getWidth()) * FlappyBirdParameter.TUBE_COUNT);
            }

            if (tube.isColliding(this.bird.getBound())) {
                gsm.set(new OverState(gsm, score));
                return;
            }
        }

        for (Ground ground : grounds) {
            if ((camera.position.x - camera.viewportWidth / 2) >
                    (ground.getPosition().x + FlappyBirdParameter.GROUND.getWidth())) {
                ground.reposition(ground.getPosition().x
                        + FlappyBirdParameter.GROUND.getWidth() * FlappyBirdParameter.GROUND_COUNT);
            }

            if (ground.isColliding(this.bird.getBound())) {
                gsm.set(new OverState(gsm, score));
                return;
            }
        }

        camera.position.x = bird.getPosition().x + FlappyBirdParameter.CAMERA_OFFSET;
        camera.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);

        sb.begin();

        sb.draw(FlappyBirdParameter.BACKGROUND, camera.position.x - (camera.viewportWidth / 2), 0);
        sb.draw(this.bird.getBirdTexture(), this.bird.getPosition().x, this.bird.getPosition().y);

        for (Tube tube : tubes) {
            sb.draw(FlappyBirdParameter.TOP_TUBE, tube.getPosTopTube().x, tube.getPosTopTube().y);
            sb.draw(FlappyBirdParameter.BOTTOM_TUBE, tube.getPosBottomTube().x, tube.getPosBottomTube().y);
        }

        for (Ground ground : grounds) {
            sb.draw(FlappyBirdParameter.GROUND, ground.getPosition().x, ground.getPosition().y);
        }

        FlappyBirdParameter.FONT.draw(sb, String.valueOf(score),
                camera.position.x, camera.position.y + camera.viewportHeight / 4);

        sb.end();
    }

    @Override
    public void dispose() {

    }
}
