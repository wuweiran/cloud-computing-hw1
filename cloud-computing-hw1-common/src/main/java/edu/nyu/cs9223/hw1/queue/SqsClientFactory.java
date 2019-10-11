package edu.nyu.cs9223.hw1.queue;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import edu.nyu.cs9223.hw1.config.Config;

/**
 * @author wuweiran
 */
public class SqsClientFactory {
    private volatile static SqsClient sqsClient;

    private SqsClientFactory() {
    }

    public static SqsClient getInstance() {
        if (sqsClient == null) {
            synchronized (SqsClient.class) {
                if (sqsClient == null) {
                    sqsClient = buildSqsClient();
                }
            }
        }
        return sqsClient;
    }

    private static SqsClient buildSqsClient() {
        final AmazonSQS sqs = AmazonSQSClientBuilder
                .standard()
                .withCredentials(Config.getCredentialsProvider())
                .withRegion(Config.getRegions())
                .build();
        return new SqsClient(sqs, Config.getQueueUrl());
    }
}