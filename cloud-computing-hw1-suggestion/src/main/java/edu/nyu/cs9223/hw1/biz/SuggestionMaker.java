package edu.nyu.cs9223.hw1.biz;

import com.google.gson.JsonParseException;
import edu.nyu.cs9223.hw1.UserInfo;
import edu.nyu.cs9223.hw1.notification.SnsClient;
import edu.nyu.cs9223.hw1.notification.SnsClientFactory;
import edu.nyu.cs9223.hw1.queue.SqsClient;
import edu.nyu.cs9223.hw1.queue.SqsClientFactory;
import edu.nyu.cs9223.hw1.recommendation.Suggestion;

import java.util.List;

/**
 * @author wuweiran
 */
public class SuggestionMaker {
    private SuggestionMaker() {
    }

    public static void consumeAndSuggest() {
        SqsClient sqsClient = SqsClientFactory.getInstance();
        List<String> messages = sqsClient.receiveMessages();
        for (String userInfoJson : messages) {
            try {
                UserInfo userInfo = UserInfo.fromSlots(userInfoJson);
                Suggestion suggestion = Suggestion.fromUserInfo(userInfo);
                if (suggestion != null) {
                    push(userInfo.getPhoneNumber(), suggestion.toSms());
                }
            } catch (JsonParseException jpe) {
                // do nothing
            }
        }
    }

    private static void push(String phoneNumber, String message) {
        SnsClient snsClient = SnsClientFactory.getInstance();
        snsClient.sendSms(message, phoneNumber);
    }
}
