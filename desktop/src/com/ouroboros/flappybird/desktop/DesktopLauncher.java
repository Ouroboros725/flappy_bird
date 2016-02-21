package com.ouroboros.flappybird.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ouroboros.flappybird.FlappyBird;
import com.ouroboros.flappybird.FlappyBirdParameter;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = FlappyBirdParameter.WIDTH;
        config.height = FlappyBirdParameter.HEIGHT;
        config.title = FlappyBirdParameter.TITLE;

        new LwjglApplication(new FlappyBird(), config);
    }
}
