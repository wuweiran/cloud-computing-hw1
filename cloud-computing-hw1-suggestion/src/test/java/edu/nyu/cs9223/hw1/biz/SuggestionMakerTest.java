package edu.nyu.cs9223.hw1.biz;

import com.google.gson.JsonParseException;
import edu.nyu.cs9223.hw1.UserInfo;
import edu.nyu.cs9223.hw1.queue.SqsClient;
import edu.nyu.cs9223.hw1.queue.SqsClientFactory;
import edu.nyu.cs9223.hw1.recommendation.Suggestion;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class SuggestionMakerTest {

    @Test
    public void consumeAndSuggest() {
        SqsClient sqsClient = SqsClientFactory.getInstance();
        sqsClient.sendMessage("{\"Cuisine\":\"Japanese\",\"DiningDate\":\"2019-10-23\",\"DinningTime\":\"14:00\",\"PhoneNumber\":\"+13478854596\",\"PeopleNum\":\"20\",\"Location\":\"Manhattan\"}");
        sqsClient.sendMessage("{\"Cuisine\":\"Chinese\",\"DiningDate\":\"2019-10-22\",\"DinningTime\":\"14:00\",\"PhoneNumber\":\"+13478854596\",\"PeopleNum\":\"20\",\"Location\":\"Manhattan\"}");
        List<String> messages = sqsClient.receiveMessages();
        System.out.println(messages.size());
        for (String userInfoJson : messages) {
            try {
                System.out.println(userInfoJson);
                UserInfo userInfo = UserInfo.fromSlots(userInfoJson);
                System.out.println(userInfo);
                Suggestion suggestion = Suggestion.fromUserInfo(userInfo);
                assertNotNull(suggestion);
            } catch (JsonParseException jpe) {
                // do nothing
            }
        }
    }
}