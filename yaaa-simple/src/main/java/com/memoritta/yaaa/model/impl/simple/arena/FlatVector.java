package com.memoritta.yaaa.model.impl.simple.arena;

import com.memoritta.yaaa.model.arena.AaVector;

public record FlatVector(int x, int y) implements AaVector {

    // (x,y) x - horizontal, y - vertical
    // simple flat map

    public static final FlatVector UP = new FlatVector(0, 1);
    public static final FlatVector DOWN = new FlatVector(0, -1);
    public static final FlatVector LEFT = new FlatVector(-1, 0);
    public static final FlatVector RIGHT = new FlatVector(0, 1);
    public static final FlatVector ZERO = new FlatVector(0, 0);
    public static final FlatVector UP_RIGHT = UP.add(RIGHT);
    public static final FlatVector UP_LEFT = UP.add(LEFT);
    public static final FlatVector DOWN_RIGHT = DOWN.add(RIGHT);
    public static final FlatVector DOWN_LEFT = DOWN.add(LEFT);

    public FlatVector add(FlatVector vector) {
        return new FlatVector(this.x + vector.x, this.y + vector.y);
    }
}