package edu.nyu.cs9223.hw1.chatbot;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import edu.nyu.cs9223.hw1.chatbot.model.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Handler for requests for the chat bot to LF0.
 *
 * @author wuweiran
 * @date 2019-10-8
 */
public class BotRequestHandler implements RequestHandler<BotRequest, BotResponse> {

    @Override
    public BotResponse handleRequest(final BotRequest botRequest, final Context context) {
        final LambdaLogger logger = context.getLogger();
        Map<String, String> headers = new HashMap<>(3);
        headers.put("Content-Type", "application/json");
        logger.log("Request received. Chat Operation: " + botRequest.toString());
        try {
            ChatBot chatBot = ChatBotFactory.getInstance();
            BotRequestReader botRequestReader = new BotRequestReader(botRequest);
            if (botRequestReader.getOperation() == BotRequestReader.OP_MESSAGE) {
                logger.log("Sending message to chat bot: " + botRequestReader.getMessage());
                List<String> replies = chatBot.postText(botRequestReader.getUserId(), botRequestReader.getMessage());
                logger.log("Message sent, response size: " + replies.size());
                List<Message> messages = new LinkedList<>();
                for (String reply : replies) {
                    messages.add(new Message().type("message").unstructured(new UnstructuredMessage().text(reply)));
                }
                return new BotResponse().messages(messages);
            } else if (botRequestReader.getOperation() == BotRequestReader.OP_RESET) {
                logger.log("Deleting session of user: " + botRequestReader.getUserId());
                boolean result = chatBot.resetChat(botRequestReader.getUserId());
                logger.log("Reset result: " + result);
                if (result) {
                    return new BotResponse().messages(new Message().type("operation")
                            .unstructured(new UnstructuredMessage().text("reset")));
                } else {
                    throw new ForbiddenException("forbidden").code(1);
                }
            }
        } catch (Exception e) {
            throw new InternalServerErrorException("internal_server_error").code(0);
        }
        return null;
    }
}
