package com.memoritta.yaaa.model.impl.simple.arena;

import com.memoritta.yaaa.model.arena.AaVector;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
public class FlatVector implements AaVector {

    // (x,y) x - horizontal, y - vertical
    // simple flat map

    public static final FlatVector ZERO = new FlatVector(0, 0);
    public static final FlatVector UP = new FlatVector(0, 1);
    public static final FlatVector DOWN = new FlatVector(0, -1);
    public static final FlatVector LEFT = new FlatVector(-1, 0);
    public static final FlatVector RIGHT = new FlatVector(0, 1);
    public static final FlatVector UP_RIGHT = UP.add(RIGHT);
    public static final FlatVector UP_LEFT = UP.add(LEFT);
    public static final FlatVector DOWN_RIGHT = DOWN.add(RIGHT);
    public static final FlatVector DOWN_LEFT = DOWN.add(LEFT);
    private final int x;
    private final int y;

    public FlatVector add(FlatVector vector) {
        return new FlatVector(this.x + vector.x, this.y + vector.y);
    }
}