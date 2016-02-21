package com.ouroboros.flappybird.sprite;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.ouroboros.flappybird.FlappyBirdParameter;

/**
 * Created by Sand on 2/17/2016.
 */
public final class Bird {
    private Vector2 position;
    private Vector2 velocity;

    private Rectangle bound;

    private BirdAnimation animation;

    public Bird(int x, int y) {
        this.position = new Vector2(x, y);
        this.velocity = new Vector2(0, 0);

        this.animation = new BirdAnimation(FlappyBirdParameter.BIRD_ANIMATION, 3, 0.5f);

        this.bound = new Rectangle(x, y, this.animation.getFrame().getRegionWidth(), this.animation.getFrame().getRegionHeight());
    }

    public Vector2 getPosition() {
        return this.position;
    }

    public Rectangle getBound() {
        return bound;
    }

    public void update(float dt) {
        if (this.position.y > 0) {
            this.velocity.add(0, FlappyBirdParameter.GRAVITY);
            this.position.add(FlappyBirdParameter.FLY_SPEED * dt, new Vector2(this.velocity).scl(dt).y);
            this.bound.setPosition(this.position.x, this.position.y);
            this.animation.update(dt);
        }
    }

    public void flyUp() {
        this.velocity.y = FlappyBirdParameter.FLY_HEIGHT;
        FlappyBirdParameter.FLAP.play(0.25f);
    }

    public TextureRegion getBirdTexture() {
        return this.animation.getFrame();
    }
}
