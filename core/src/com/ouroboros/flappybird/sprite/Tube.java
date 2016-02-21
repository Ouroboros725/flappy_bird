package com.ouroboros.flappybird.sprite;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.ouroboros.flappybird.FlappyBirdParameter;

/**
 * Created by Sand on 2/18/2016.
 */
public final class Tube {
    private Vector2 posTopTube;
    private Vector2 posBottomTube;

    private Rectangle boundTopTube;
    private Rectangle boundBottomTube;

    public Tube(float x) {
        this.posTopTube = new Vector2();
        this.posBottomTube = new Vector2();

        this.boundTopTube = new Rectangle(0, 0, FlappyBirdParameter.TOP_TUBE.getWidth(), FlappyBirdParameter.TOP_TUBE.getHeight());
        this.boundBottomTube = new Rectangle(0, 0, FlappyBirdParameter.BOTTOM_TUBE.getWidth(), FlappyBirdParameter.BOTTOM_TUBE.getHeight());

        this.position(x);
    }

    public Vector2 getPosTopTube() {
        return this.posTopTube;
    }

    public Vector2 getPosBottomTube() {
        return this.posBottomTube;
    }

    private void position(float x) {
        this.posTopTube.set(x, FlappyBirdParameter.TUBE_RAND.nextInt(FlappyBirdParameter.TUBE_FLUCTUATION)
                + FlappyBirdParameter.TUBE_GAP + FlappyBirdParameter.TUBE_LOWEST_OPENING);
        this.posBottomTube.set(x, this.posTopTube.y - FlappyBirdParameter.TUBE_GAP - FlappyBirdParameter.BOTTOM_TUBE.getHeight());

        this.boundTopTube.setPosition(posTopTube.x, posTopTube.y);
        this.boundBottomTube.setPosition(posBottomTube.x, posBottomTube.y);
    }

    public void reposition(float x) {
        this.position(x);
    }

    public boolean isColliding(Rectangle obj) {
        return obj != null && (this.boundTopTube.overlaps(obj) || this.boundBottomTube.overlaps(obj));
    }
}
