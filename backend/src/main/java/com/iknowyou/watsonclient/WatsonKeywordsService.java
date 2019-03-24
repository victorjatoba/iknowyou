package com.iknowyou.watsonclient;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ibm.watson.developer_cloud.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalysisResults;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalyzeOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.Features;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.KeywordsOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.KeywordsResult;
import com.ibm.watson.developer_cloud.service.security.IamOptions;

@Component
public class WatsonKeywordsService {
	
public List<String> getKeywords(final String text) {
	final IamOptions options = new IamOptions.Builder().apiKey("Ous-jJK1oNwL-NptF5Ca9y1V-oz1FxS_R2NBEh89lgMS").build();
	
	final NaturalLanguageUnderstanding naturalLanguageUnderstanding = new NaturalLanguageUnderstanding("2018-11-16", options);
	naturalLanguageUnderstanding.setEndPoint("https://gateway.watsonplatform.net/natural-language-understanding/api");
	
	final KeywordsOptions keywords= new KeywordsOptions.Builder()
			  .sentiment(false)
			  .emotion(false)
			  .limit(5)
			  .build();
	
	final Features features = new Features.Builder()
			  .keywords(keywords)
			  .build();

	final AnalyzeOptions parameters = new AnalyzeOptions.Builder()
	  .text(text)
	  .features(features)
	  .build();

	final AnalysisResults response = naturalLanguageUnderstanding
	  .analyze(parameters)
	  .execute();

	
	return response.getKeywords().stream().map(KeywordsResult::getText).collect(Collectors.toList());
}

}
