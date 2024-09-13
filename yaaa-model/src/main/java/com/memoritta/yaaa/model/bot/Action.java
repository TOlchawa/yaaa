package com.memoritta.yaaa.model.bot;

import lombok.AllArgsConstructor;

/**
 * All possible actions a bot can take.
 */
public enum Action {
    CONSUME("consume"),
    MOVE("move"),
    ATTACK("attack"),
    LOOK("look"),
    ;

    private String name;

    Action(String name) {
        this.name = name;
    }
}
