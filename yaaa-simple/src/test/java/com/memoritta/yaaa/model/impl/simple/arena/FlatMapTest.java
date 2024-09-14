package com.memoritta.yaaa.model.impl.simple.arena;

import com.memoritta.yaaa.model.arena.AaField;
import com.memoritta.yaaa.model.impl.simple.utils.FlatMapUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.memoritta.yaaa.model.impl.simple.arena.FlatVector.ZERO;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest(classes = FlatSpace.class)
class FlatMapTest {

    @Test
    public void testFlatMap() {
        FlatSpace fm = FlatMapUtils.createFlatMap(4, 4);
        fm.fields().forEach(f -> {
            AaField o = f.adjacentField(ZERO);
            log.debug("zero: {}; this: {}", o, f);
            assertThat(o).isEqualTo(f);
        });
        assertThat(fm.fields().size()).isEqualTo(16);
    }


}