package edu.nyu.cs9223.hw1.biz;

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
            UserInfo userInfo = UserInfo.fromJson(userInfoJson);
            Suggestion suggestion = new Suggestion(userInfo);
            push(userInfo.getPhoneNumber(), suggestion);
        }
    }

    private static void push(String phoneNumber, Suggestion suggestion) {
        SnsClient snsClient = SnsClientFactory.getInstance();
        snsClient.sendSms(phoneNumber, suggestion.toSms());
    }
}
