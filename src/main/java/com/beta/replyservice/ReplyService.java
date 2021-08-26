// license/copyright header
package com.beta.replyservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beta.ruleservice.RuleService;

/** This class contains method related to message processing.
 * 
 * @author Sumit Khedkar
 *
 */
@Service
public class ReplyService {
	
	@Autowired
	private RuleService ruleService;
	
	private Logger logger = LoggerFactory.getLogger(ReplyService.class);

	/** This method processes given input and returns 
	 *  final string after applying all transformation rules.
	 * 
	 * @param message - Actual string
	 * @return        - Transformed string
	 */
	public String handleRequest(String message) {

		String[] tokens = message.split("-");

		String rulesString = tokens[0];

		// 1. Apply very first rule and get result.
		String result = ruleService.applyRule(Character.getNumericValue(rulesString.charAt(0)), tokens[1]);

		// 2. Apply subsequent rules and get final result.
		for (int count = 1; count < rulesString.length(); count++) {
			char ruleStr = rulesString.charAt(count);
			result = ruleService.applyRule(Character.getNumericValue(ruleStr), result);
		}

		return result;
	}

	/** This  method validates given input message. */
	public boolean validateMessage(String message) {
		String[] tokens = message.split("-");
		if (tokens.length != 2) {
			logger.error("Invalid input received.");
			return false;
		} 

		if (!validateRulesPart(tokens[0])) {
			return false;
		}

		return true;
	}

	/** Validate Rules section */
	public boolean validateRulesPart(String rulesString) {
		//TODO:
		return true;
	}

}