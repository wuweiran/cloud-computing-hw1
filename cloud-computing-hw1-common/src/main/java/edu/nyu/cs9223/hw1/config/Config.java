package edu.nyu.cs9223.hw1.config;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;

/**
 * Tool class for configurations.
 *
 * @author wuweiran
 */
public class Config {
    public static final String ACCESS_KEY = "AKIAZPF2QUV4B7F3ABEO";

    public static final String SECRET_KEY = "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";

    private Config() {
    }

    public static AWSCredentialsProvider getCredentialsProvider() {
        return new AWSStaticCredentialsProvider(new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY));
    }

    public static Regions getRegions() {
        return Regions.US_EAST_1;
    }

    public static String getBotName() {
        return "DiningConcierge";
    }

    public static String getBotAlias() {
        return "Pre";
    }

    public static String getDiningSuggestionIntentName() {
        return "DiningSuggestionsIntent";
    }

    public static String getQueueUrl() {
        return "https://sqs.us-east-1.amazonaws.com/651078706552/UserInfoQueue";
    }
}
