package com.ouroboros.flappybird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import java.util.Random;

/**
 * Created by Sand on 2/17/2016.
 */
public class FlappyBirdParameter {
    public static final int WIDTH = 480;
    public static final int HEIGHT = 800;

    public static final String TITLE = "Flappy Bird";

    public static final int CAMERA_OFFSET = 80;

    public static final int GRAVITY = -15;
    public static final int FLY_HEIGHT = 250;
    public static final int FLY_SPEED = 100;

    public static final int TUBE_FLUCTUATION = 130;
    public static final int TUBE_GAP = 100;
    public static final int TUBE_LOWEST_OPENING = 120;
    public static final int TUBE_SPACING = 125;
    public static final int TUBE_COUNT = 4;

    public static final Random TUBE_RAND = new Random();

    public static final int GROUND_OFFSET = -50;
    public static final int GROUND_COUNT = 2;

    public static final Texture BACKGROUND = new Texture("background.png");
    public static final Texture PLAY_BTN = new Texture("playbtn.png");
    public static final Texture BIRD = new Texture("bird.png");
    public static final Texture BIRD_ANIMATION = new Texture("birdanimation.png");
    public static final Texture TOP_TUBE = new Texture("toptube.png");
    public static final Texture BOTTOM_TUBE = new Texture("bottomtube.png");
    public static final Texture GROUND = new Texture("ground.png");
    public static final Texture GAME_OVER = new Texture("gameover.png");

    public static final BitmapFont FONT;

    public static final Music MUSIC;
    public static final Sound FLAP;

    static {
        FONT = new BitmapFont(Gdx.files.internal("georgia-native.fnt"));
        FONT.setColor(Color.WHITE);

        MUSIC = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
        MUSIC.setLooping(true);
        MUSIC.setVolume(0.25f);

        FLAP = Gdx.audio.newSound(Gdx.files.internal("sfx_wing.ogg"));
    }

    public static void disposeResources() {
        BACKGROUND.dispose();
        PLAY_BTN.dispose();
        BIRD.dispose();
        BIRD_ANIMATION.dispose();
        TOP_TUBE.dispose();
        BOTTOM_TUBE.dispose();
        GROUND.dispose();
        GAME_OVER.dispose();

        FONT.dispose();

        MUSIC.dispose();
        FLAP.dispose();
    }
}
