package com.memoritta.yaaa.engine;

import com.memoritta.yaaa.model.arena.AaSpace;
import com.memoritta.yaaa.model.behavior.AaAction;
import com.memoritta.yaaa.model.bot.Bot;

public interface AaEngine {
    ExecutionResult doNextStep();
    ActionResult applyAction(AaAction action, Bot bot, AaSpace aaSpace);
}
