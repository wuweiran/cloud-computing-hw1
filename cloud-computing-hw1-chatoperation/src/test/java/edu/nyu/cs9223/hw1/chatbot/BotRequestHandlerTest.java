package edu.nyu.cs9223.hw1.chatbot;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import edu.nyu.cs9223.hw1.chatbot.model.BotRequest;
import edu.nyu.cs9223.hw1.chatbot.model.BotResponse;
import edu.nyu.cs9223.hw1.chatbot.model.Message;
import edu.nyu.cs9223.hw1.chatbot.model.UnstructuredMessage;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BotRequestHandlerTest {
    @Test
    public void successfulResponse() {
        BotRequestHandler botRequestHandler = new BotRequestHandler();
        LambdaLogger logger = mock(LambdaLogger.class);
        Context context = mock(Context.class);
        when(context.getLogger()).thenReturn(logger);

        BotRequest botRequest = new BotRequest().messages(new Message().type("operation").unstructured(new UnstructuredMessage().text("message")),
                new Message().type("message").unstructured(new UnstructuredMessage().text("hello")),
                new Message().type("userId").unstructured(new UnstructuredMessage().text("test")));
        BotResponse result = botRequestHandler
                .handleRequest(botRequest, context);
        assertNotEquals(result.getMessages().size(), 0);
    }
}
