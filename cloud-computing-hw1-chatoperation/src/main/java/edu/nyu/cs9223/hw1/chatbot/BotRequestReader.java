package edu.nyu.cs9223.hw1.chatbot;

import edu.nyu.cs9223.hw1.chatbot.model.BotRequest;
import edu.nyu.cs9223.hw1.chatbot.model.Message;
import lombok.Getter;

import java.util.List;

/**
 * @author wuweiran
 */
@Getter
public class BotRequestReader {
    public static final int OP_MESSAGE = 0;

    public static final int OP_RESET = 1;

    private final int operation;

    private final String userId;

    private final String message;

    public BotRequestReader(final BotRequest botRequest) {
        List<Message> botMessages = botRequest.getMessages();
        int operation = -1;
        String userId = null;
        String message = "";
        for (Message botMessage : botMessages) {
            String type = botMessage.getType().toLowerCase();
            String text = botMessage.getUnstructured().getText();
            if ("operation".equals(type)) {
                switch (text.toLowerCase()) {
                    case "message":
                        operation = OP_MESSAGE;
                        break;
                    case "reset":
                        operation = OP_RESET;
                        break;
                    default:
                        throw new UnsupportedOperationException();
                }
            } else if ("message".equals(type)) {
                message = text;
            } else if ("userid".equals(type)) {
                userId = text;
            }
        }
        if (operation == -1 || userId == null) {
            throw new IllegalStateException("Operation or user ID should be specified");
        }
        this.operation = operation;
        this.userId = userId;
        this.message = message;
    }
}
