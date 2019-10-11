package edu.nyu.cs9223.hw1.queue;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageRequest;

import java.util.LinkedList;
import java.util.List;

/**
 * This sample demonstrates how to make basic requests to Amazon SQS using the
 * AWS SDK for Java.
 * <p>
 * Prerequisites: You must have a valid Amazon Web Services developer account,
 * and be signed up to use Amazon SQS. For more information about Amazon SQS,
 * see https://aws.amazon.com/sqs
 * <p>
 * Make sure that your credentials are located in ~/.aws/credentials
 *
 * @author wuweiran
 */
public class SqsClient {
    private final String queueUrl;

    private final AmazonSQS sqs;

    public SqsClient(AmazonSQS sqs, String queueUrl) {
        this.sqs = sqs;
        this.queueUrl = queueUrl;
    }

    public List<String> receiveMessages() {
        final ReceiveMessageRequest receiveMessageRequest =
                new ReceiveMessageRequest(queueUrl);
        final List<Message> messages = sqs.receiveMessage(receiveMessageRequest).getMessages();
        List<String> result = new LinkedList<>();
        for (Message message : messages) {
            result.add(message.getBody());
        }
        return result;
    }
    public void sendMessage(String message) {
        sqs.sendMessage(new SendMessageRequest(queueUrl, message));
    }
}
