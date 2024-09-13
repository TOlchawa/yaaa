package com.memoritta.yaaa.ui.text;

import com.memoritta.yaaa.ui.UI;
import com.memoritta.yaaa.ui.UIEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TextUI implements UI {

    @Override
    public void start() {
      log.info("Starting Text UI");
    }

    @Override
    public void update() {
        log.info("Updating Text UI");
    }

    @Override
    public void stop() {
        log.info("Stopping Text UI");
    }

    @Override
    public void processEvent(UIEvent event) {
        log.info("Processing event: action: {}, description: {}", event.action(), event.description());
    }
}
