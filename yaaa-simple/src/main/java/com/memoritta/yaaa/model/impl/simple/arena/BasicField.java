package com.memoritta.yaaa.model.impl.simple.arena;

import com.memoritta.yaaa.model.arena.AaField;
import com.memoritta.yaaa.model.arena.AaResource;
import com.memoritta.yaaa.model.arena.AaVector;
import com.memoritta.yaaa.model.bot.Bot;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.memoritta.yaaa.model.impl.simple.arena.FlatVector.*;

@RequiredArgsConstructor
public class BasicField implements AaField {

    private final int x;
    private final int y;
    private final FlatMap parentMap;
    private final Set<AaResource> resources = new HashSet<>();
    private final Set<Bot> bots = new HashSet<>();

    private static final Set<FlatVector> DEFAULT_POSSIBLE_A_VECTORS = new HashSet<>(List.of(ZERO, UP, DOWN, LEFT, RIGHT, UP_LEFT, UP_RIGHT, DOWN_LEFT, DOWN_RIGHT));

    @Override
    public Set<AaResource> resources() {
        return new HashSet<>(resources);
    }

    @Override
    public Set<Bot> bots() {
        return new HashSet<>(bots);
    }

    @Override
    public AaField adjacentField(AaVector vector) {
        if (ZERO.equals(vector)) {
            return this;
        }
        FlatVector flatVector = (FlatVector) vector;
        return parentMap.getField( this.x + flatVector.getX(), this.y + flatVector.getY());
    }

    @Override
    public Set<AaVector> vectors() {
        return new HashSet<>(DEFAULT_POSSIBLE_A_VECTORS);
    }
}
