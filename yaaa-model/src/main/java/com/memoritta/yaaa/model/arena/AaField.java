package com.memoritta.yaaa.model.arena;

import com.memoritta.yaaa.model.bot.Bot;

import java.util.Set;

public interface AaField {

    Set<AaResource> resources();
    Set<Bot> bots();
    AaField adjacentField(AaVector AVector);
    Set<AaVector> vectors();

}
