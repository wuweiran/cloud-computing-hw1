package edu.nyu.cs9223.hw1;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import edu.nyu.cs9223.hw1.biz.SuggestionMaker;

/**
 * @author weiranwu
 */
public class PeriodicEventHandler implements RequestHandler<Object, Object> {

    @Override
    public Object handleRequest(Object botEvent, Context context) {
        LambdaLogger logger = context.getLogger();
        SuggestionMaker.consumeAndSuggest();
        logger.log("triggered");
        return null;
    }
}
