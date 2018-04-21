/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aws.codestar.projecttemplates.service;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.comprehend.AmazonComprehend;
import com.amazonaws.services.comprehend.AmazonComprehendClientBuilder;
import com.amazonaws.services.comprehend.model.DetectSentimentRequest;
import com.amazonaws.services.comprehend.model.DetectSentimentResult;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author chunyap
 */
@Service
public class ComprehendService {
    
    public Map<String, String> getSentiment(String input){
        // Create credentials using a provider chain. For more information, see
        // https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/credentials.html       
        //AWSCredentialsProvider awsCreds = new InstanceProfileCredentialsProvider();

        System.out.println("Building comprehend client");
        AmazonComprehend comprehendClient =
            AmazonComprehendClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
                                         
        // Call detectSentiment API
        System.out.println("Calling DetectSentiment");
        DetectSentimentRequest detectSentimentRequest = new DetectSentimentRequest().withText(input)
                                                                                    .withLanguageCode("en");
        DetectSentimentResult detectSentimentResult = comprehendClient.detectSentiment(detectSentimentRequest);
        System.out.println(detectSentimentResult);
        System.out.println("End of DetectSentiment\n");
        System.out.println( "Done" );
        
        Map<String, String> result = new HashMap<>();
        result.put("Sentiment", detectSentimentResult.getSentiment().toString());
        result.put("SentimentScore", detectSentimentResult.getSentimentScore().toString());
        
        return result;
    }
}
