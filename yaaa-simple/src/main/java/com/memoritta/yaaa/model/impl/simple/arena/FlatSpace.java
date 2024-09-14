package com.memoritta.yaaa.model.impl.simple.arena;

import com.memoritta.yaaa.model.arena.AaSpace;
import com.memoritta.yaaa.model.arena.AaField;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class FlatSpace implements AaSpace {

    private BasicField[][] arrayMap;

    @Override
    public Set<AaField> fields() {
        return Arrays.stream(arrayMap).flatMap(Arrays::stream).collect(Collectors.toSet());
    }

    public BasicField getField(int x, int y) {
        return arrayMap[x][y];
    }
}
