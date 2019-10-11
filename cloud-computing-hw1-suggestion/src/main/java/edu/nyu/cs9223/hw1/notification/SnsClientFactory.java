package edu.nyu.cs9223.hw1.notification;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import edu.nyu.cs9223.hw1.config.Config;
import edu.nyu.cs9223.hw1.queue.SqsClient;

/**
 * @author wuweiran
 */
public class SnsClientFactory {
    private volatile static SnsClient snsClient;

    private SnsClientFactory() {
    }

    public static SnsClient getInstance() {
        if (snsClient == null) {
            synchronized (SnsClient.class) {
                if (snsClient == null) {
                    snsClient = buildSnsClient();
                }
            }
        }
        return snsClient;
    }

    private static SnsClient buildSnsClient() {
        final AmazonSNS sns = AmazonSNSClientBuilder
                .standard()
                .withCredentials(Config.getCredentialsProvider())
                .withRegion(Config.getRegions())
                .build();
        return new SnsClient(sns);
    }
}