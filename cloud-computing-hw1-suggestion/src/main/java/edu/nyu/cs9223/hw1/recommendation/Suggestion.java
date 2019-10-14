package edu.nyu.cs9223.hw1.recommendation;

import edu.nyu.cs9223.hw1.UserInfo;
import edu.nyu.cs9223.hw1.search.ElasticSearchService;

import java.util.List;

/**
 * @author wwrus
 */
public class Suggestion {

    private UserInfo userInfo;

    private List<SourceInfo> sourceInfoList;

    private static final String SMS_TEMPLATE = "Hello! Here are my %CUISINE% restaurant suggestions for %PEOPLE_NUM% people" +
            ", for %DATE% at %TIME%:\n%SUGGESTIONS%Enjoy your meal!";

    private Suggestion(UserInfo userInfo, List<SourceInfo> sourceInfoList) {
        this.userInfo = userInfo;
        this.sourceInfoList = sourceInfoList;
    }

    public static Suggestion fromUserInfo(UserInfo userInfo) {
        List<SourceInfo> sourceInfoList = ElasticSearchService.search(userInfo.getCuisine());

        if (sourceInfoList.size() > 0) {
            return new Suggestion(userInfo, sourceInfoList);
        } else {
            return null;
        }
    }

    public String toSms() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sourceInfoList.size(); i++) {
            sb.append(i + 1).append(". ");
            sb.append(sourceInfoList.get(i).getName()).append(", ")
                    .append("located at ").append(sourceInfoList.get(i).getAddress());
            sb.append('\n');
        }
        String suggestions = sb.toString();
        return SMS_TEMPLATE.replaceAll("%CUISINE%", userInfo.getCuisine())
                .replaceAll("%PEOPLE_NUM%", userInfo.getPeopleNum())
                .replaceAll("%DATE%", userInfo.getDiningTime())
                .replaceAll("%TIME%", userInfo.getDiningDate())
                .replaceAll("%SUGGESTIONS%", suggestions);
    }
}
