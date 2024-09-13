package com.memoritta.yaaa.model.impl.simple.arena;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FlatVectorTest {

    @Test
    public void test() {
        FlatVector fv0 = new FlatVector(0, 0);
        FlatVector fv1 = new FlatVector(1, 0);
        FlatVector fv1b = fv0.add(fv1);
        assertThat(fv1b).isEqualTo(fv1);
    }

}