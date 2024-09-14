package com.memoritta.yaaa.controller;

import com.memoritta.yaaa.engine.AaEngine;
import com.memoritta.yaaa.engine.ExecutionResult;
import com.memoritta.yaaa.ui.UI;
import com.memoritta.yaaa.ui.UIEvent;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@RequiredArgsConstructor
public class AaController {

    private final UI ui;
    private final AaEngine aaEngine;

    @PostConstruct
    public void execute() {
        // execute code in new type of threads from jdk 21
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            ExecutionResult stepResult = aaEngine.doNextStep();
            ui.processEvent(new UIEvent(stepResult.type(), stepResult.description()));
        });
    }

}
