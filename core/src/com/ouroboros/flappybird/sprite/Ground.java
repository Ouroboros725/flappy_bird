package com.ouroboros.flappybird.sprite;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.ouroboros.flappybird.FlappyBirdParameter;

/**
 * Created by Sand on 2/18/2016.
 */
public class Ground {
    private Vector2 position;
    private Rectangle bound;

    public Ground(float x) {
        this.position = new Vector2();
        this.bound = new Rectangle(0, 0, FlappyBirdParameter.GROUND.getWidth(), FlappyBirdParameter.GROUND.getHeight());

        this.position(x);
    }

    public Vector2 getPosition() {
        return position;
    }

    private void position(float x) {
        this.position.set(x, FlappyBirdParameter.GROUND_OFFSET);
        this.bound.setPosition(x, FlappyBirdParameter.GROUND_OFFSET);
    }

    public void reposition(float x) {
        this.position(x);
    }

    public boolean isColliding(Rectangle obj) {
        return obj != null && this.bound.overlaps(obj);
    }
}
