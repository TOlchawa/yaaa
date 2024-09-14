package com.memoritta.yaaa.model.impl.simple.engine;

import com.memoritta.yaaa.engine.ExecutionResult;
import com.memoritta.yaaa.model.arena.AaSpace;
import com.memoritta.yaaa.model.impl.simple.engine.manager.ActionManager;
import com.memoritta.yaaa.model.impl.simple.engine.manager.BotManager;
import com.memoritta.yaaa.model.impl.simple.engine.manager.SpaceManager;
import com.memoritta.yaaa.model.impl.simple.utils.FlatMapUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest(classes = { SimpleEngine.class, ActionManager.class })
@ContextConfiguration(classes = SimpleEngineTest.Config.class)
class SimpleEngineTest {

    @Autowired
    private SimpleEngine simpleEngine;

    @Autowired
    private ActionManager actionManager;

    @MockBean
    private SpaceManager spaceManager;

    @MockBean
    private BotManager botManager;

    @Test
    public void test() {
        ExecutionResult result = simpleEngine.doNextStep();
        assertThat(result).isNotNull();
        log.info("result: {}", result);
    }

    public static class Config {

        @Bean
        public AaSpace getFlatMap() {
            return FlatMapUtils.createFlatMap(2, 2 );
        }
    }
}