package com.memoritta.yaaa.ui;

public interface UI {
    void start();
    void update();
    void stop();

    void processEvent(UIEvent event);
}
