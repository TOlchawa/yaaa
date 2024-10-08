package com.memoritta.yaaa.model.impl.simple.utils;

import com.memoritta.yaaa.model.impl.simple.arena.BasicField;
import com.memoritta.yaaa.model.impl.simple.arena.FlatMap;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;

@UtilityClass
public class FlatMapUtils {

    @NotNull
    public FlatMap createFlatMap(int w, int h) {
        FlatMap fm = new FlatMap();
        BasicField[][] arrayMap = createArrayMap(w, h, fm);
        fm.setArrayMap(arrayMap);
        return fm;
    }

    private BasicField[][] createArrayMap(int w, int h, FlatMap map) {
        BasicField[][] result = new BasicField[w][h];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                result[i][j] = new BasicField(i, j, map);
            }
        }
        return result;
    }

}
