package com.memoritta.yaaa.model.impl.simple.engine.manager;

import com.memoritta.yaaa.engine.ActionResult;
import com.memoritta.yaaa.engine.ExecutionResult;

public class ActionManager {
    public ActionResult concatenate(ActionResult botActionResult, ActionResult spaceActionResult) {
        // this is fake action manager - TODO: add proper implementation
        String type = botActionResult.type() + " + " + spaceActionResult.type();
        String description = botActionResult.description() + " + " + spaceActionResult.description();
        return new ActionResult(type, description);
    }

    public ExecutionResult convert(ActionResult actionResult) {
        // this is fake action manager - TODO: add proper implementation
        return new ExecutionResult(actionResult.type(), actionResult.description());
    }
}
