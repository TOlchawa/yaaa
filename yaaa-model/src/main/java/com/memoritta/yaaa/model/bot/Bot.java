package com.memoritta.yaaa.model.bot;

import com.memoritta.yaaa.model.ai.Ai;

public interface Bot {
    Ai ai();
    void doAction(Action action);
}
