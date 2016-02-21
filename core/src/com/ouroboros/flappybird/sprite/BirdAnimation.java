package com.ouroboros.flappybird.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Sand on 2/19/2016.
 */
public class BirdAnimation {
    private Array<TextureRegion> frames;
    private float maxFrameTime;
    private float currentFrameTime;
    private int frameCount;
    private int currentFrameIndex;

    public BirdAnimation(Texture texture, int frameCount, float cycleTime) {
        this.frameCount = frameCount;
        this.maxFrameTime = cycleTime / this.frameCount;

        int frameWidth = texture.getWidth() / frameCount;
        int frameHeight = texture.getHeight();

        this.frames = new Array<TextureRegion>(this.frameCount);
        for (int i = 0; i < this.frameCount; i++) {
            this.frames.add(new TextureRegion(texture, i * frameWidth, 0, frameWidth, frameHeight));
        }
    }

    public void update(float dt) {
        this.currentFrameTime += dt;

        if (this.currentFrameTime >= this.maxFrameTime) {
            this.currentFrameTime -= this.maxFrameTime;

            if (++this.currentFrameIndex >= this.frameCount) {
                this.currentFrameIndex = 0;
            }
        }
    }

    public TextureRegion getFrame() {
        return this.frames.get(this.currentFrameIndex);
    }
}
