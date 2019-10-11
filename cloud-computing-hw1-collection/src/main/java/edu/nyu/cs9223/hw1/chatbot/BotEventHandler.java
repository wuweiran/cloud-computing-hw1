package edu.nyu.cs9223.hw1.chatbot;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lexruntime.model.DialogAction;
import com.amazonaws.services.lexruntime.model.DialogActionType;
import com.amazonaws.services.lexruntime.model.FulfillmentState;
import com.google.gson.Gson;
import edu.nyu.cs9223.hw1.chatbot.model.BotEvent;
import edu.nyu.cs9223.hw1.chatbot.model.BotEventResponse;
import edu.nyu.cs9223.hw1.chatbot.model.CurrentIntent;
import edu.nyu.cs9223.hw1.config.Config;
import edu.nyu.cs9223.hw1.queue.SqsClient;
import edu.nyu.cs9223.hw1.queue.SqsClientFactory;

import java.util.Map;

/**
 * @author weiranwu
 */
public class BotEventHandler implements RequestHandler<BotEvent, BotEventResponse> {

    @Override
    public BotEventResponse handleRequest(BotEvent botEvent, Context context) {
        LambdaLogger logger = context.getLogger();
        logger.log("Received bot event");
        CurrentIntent intent = botEvent.getCurrentIntent();
        if (Config.getDiningSuggestionIntentName().equals(intent.getName())) {
            Map<String, String> slots = intent.getSlots();
            SqsClient sqsClient = SqsClientFactory.getInstance();
            sqsClient.sendMessage(new Gson().toJson(slots));
            return new BotEventResponse().dialogAction(
                    new DialogAction().withType(DialogActionType.Close)
                            .withFulfillmentState(FulfillmentState.Fulfilled));
        } else {
            throw new UnsupportedOperationException("internal_error");
        }
    }
}
