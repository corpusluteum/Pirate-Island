package com.manik.gameObject;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface GameObject {

    void render(SpriteBatch sb);

    void update(float delta);
}
