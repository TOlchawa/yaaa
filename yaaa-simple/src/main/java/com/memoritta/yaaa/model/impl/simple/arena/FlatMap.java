package com.memoritta.yaaa.model.impl.simple.arena;

import com.memoritta.yaaa.model.arena.AaMap;
import com.memoritta.yaaa.model.arena.AaField;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class FlatMap implements AaMap {

    private BasicField[][] arrayMap;

    @Override
    public Set<AaField> fields() {
        return Arrays.stream(arrayMap).flatMap(Arrays::stream).collect(Collectors.toSet());
    }

    public BasicField getField(int x, int y) {
        return arrayMap[x][y];
    }
}
