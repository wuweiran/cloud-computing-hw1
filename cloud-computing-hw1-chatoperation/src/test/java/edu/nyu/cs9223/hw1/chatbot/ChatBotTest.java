package edu.nyu.cs9223.hw1.chatbot;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ChatBotTest {

    @Test
    public void postText() {
        ChatBot chatBot = ChatBotFactory.getInstance();
        chatBot.resetChat("test");
        List<String> response = chatBot.postText("test", "hello");
        assertEquals(response.size(), 3);
    }

    @Test
    public void resetChat() {
        ChatBot chatBot = ChatBotFactory.getInstance();
        assertEquals(chatBot.resetChat("test"), true);
    }
}