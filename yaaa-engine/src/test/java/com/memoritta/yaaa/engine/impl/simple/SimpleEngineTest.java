package com.memoritta.yaaa.engine.impl.simple;

import com.memoritta.yaaa.engine.ExecutionResult;
import com.memoritta.yaaa.model.arena.AaMap;
import com.memoritta.yaaa.model.impl.simple.arena.FlatMap;
import com.memoritta.yaaa.model.impl.simple.utils.FlatMapUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = { SimpleEngine.class })
@ContextConfiguration(classes = SimpleEngineTest.Config.class)
class SimpleEngineTest {

    @Autowired
    private SimpleEngine simpleEngine;

    @Test
    public void test() {
        ExecutionResult result = simpleEngine.doNextStep();
        assertThat(result).isNotNull();
    }

    public static class Config {

        @Bean
        public AaMap getFlatMap() {
            return FlatMapUtils.createFlatMap(2, 2 );
        }
    }
}