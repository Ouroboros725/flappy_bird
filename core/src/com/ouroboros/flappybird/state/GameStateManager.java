package com.ouroboros.flappybird.state;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by Sand on 2/16/2016.
 */
public class GameStateManager {
    private Stack<State> states;

    public GameStateManager() {
        this.states = new Stack<State>();
    }

    public void push(State state) {
        this.states.push(state);
    }

    public void pop() {
        try {
            this.states.pop().dispose();
        } catch (EmptyStackException ignored) {
        }
    }

    public void set(State state) {
        this.pop();
        this.push(state);
    }

    public void update(float dt) {
        try {
            this.states.peek().update(dt);
        } catch (EmptyStackException ignored) {
        }
    }

    public void render(SpriteBatch sb) {
        try {
            this.states.peek().render(sb);
        } catch (EmptyStackException ignored) {
        }
    }
}
