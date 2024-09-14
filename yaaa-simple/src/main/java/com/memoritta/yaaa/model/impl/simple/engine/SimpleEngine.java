package com.memoritta.yaaa.model.impl.simple.engine;

import com.memoritta.yaaa.engine.AaEngine;
import com.memoritta.yaaa.engine.ActionResult;
import com.memoritta.yaaa.engine.ExecutionResult;
import com.memoritta.yaaa.model.ai.Ai;
import com.memoritta.yaaa.model.arena.AaField;
import com.memoritta.yaaa.model.arena.AaSpace;
import com.memoritta.yaaa.model.behavior.AaAction;
import com.memoritta.yaaa.model.bot.Bot;
import com.memoritta.yaaa.model.impl.simple.engine.manager.ActionManager;
import com.memoritta.yaaa.model.impl.simple.engine.manager.BotManager;
import com.memoritta.yaaa.model.impl.simple.engine.manager.SpaceManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class SimpleEngine implements AaEngine {

    private static final Random RND = new Random();

    private final AaSpace aaSpace;
    private final BotManager botManager;
    private final SpaceManager spaceManager;
    private final ActionManager actionManager;
    private Set<Bot> alreadyProcessedBots = new HashSet<>();

    @Override
    public ExecutionResult doNextStep() {
        List<Bot> allBots = aaSpace.fields().stream()
                .map(AaField::bots)
                .flatMap(Set::stream)
                .filter(b -> !alreadyProcessedBots.contains(b))
                .collect(Collectors.toList());

        Bot bot = chooseRandomBot(allBots);
        ExecutionResult result = ofNullable(bot)
                .map(Bot::ai)
                .map(Ai::think)
                .map(action -> applyAction(action, bot, aaSpace))
                .map(actionManager::convert)
                .orElseGet(() -> new ExecutionResult("ACTION_SKIPPED", "Skip action for bot: " + bot));

        return result;
    }

    @Override
    public ActionResult applyAction(AaAction action, Bot bot, AaSpace aaSpace) {
        ActionResult botActionResult = botManager.applyAction(action, bot);
        ActionResult spaceActionResult = spaceManager.applyAction(action, aaSpace);
        return actionManager.concatenate(botActionResult, spaceActionResult);
    }

    private Bot chooseRandomBot(List<Bot> allBots) {
        Bot result = null;
        if (!allBots.isEmpty()) {
            int rndIdx = RND.nextInt(allBots.size());
            result = allBots.get(rndIdx);
        }
        return result;
    }
}
