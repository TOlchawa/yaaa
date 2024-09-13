package com.memoritta.yaaa.engine.impl.simple;

import com.memoritta.yaaa.engine.AaEngine;
import com.memoritta.yaaa.engine.ExecutionResult;
import com.memoritta.yaaa.model.arena.AaField;
import com.memoritta.yaaa.model.arena.AaMap;
import com.memoritta.yaaa.model.bot.Bot;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SimpleEngine implements AaEngine {

    private static final Random RND = new Random();

    private final AaMap aaMap;
    private Set<Bot> alreadyProcessedBots = new HashSet<>();

    @Override
    public ExecutionResult doNextStep() {
        List<Bot> allBots = aaMap.fields().stream()
                .map(AaField::bots)
                .flatMap(Set::stream)
                .filter(b -> !alreadyProcessedBots.contains(b))
                .collect(Collectors.toList());

        Bot bot = chooseRandomBot(allBots);

        return new ExecutionResult("foo " + bot.hashCode(), "bar " + bot.hashCode() + " " + bot.ai().hashCode());
    }

    private Bot chooseRandomBot(List<Bot> allBots) {
        int rndIdx = RND.nextInt(allBots.size());
        Bot result = allBots.get(rndIdx);
        return result;
    }
}
