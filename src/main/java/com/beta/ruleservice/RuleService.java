// license/copyright header
package com.beta.ruleservice;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

import javax.annotation.PostConstruct;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

/** This class provides methods to process
 *  given input, add, delete rule etc.
 * 
 * @author Sumit Khedkar
 *
 */
@Service
public class RuleService {
	
	private Map<Integer, Function<String, String>> rulesMap = new ConcurrentHashMap<>();

	/** Initialize rules map. */
	@PostConstruct
	private void intialize() { 
		rulesMap.put(1, input -> new StringBuilder(input).reverse().toString());
		rulesMap.put(2, input -> DigestUtils.md5Hex(input));
		
	}

	public String applyRule(int rule, String message) {
		return rulesMap.get(rule).apply(message);
	}
	
	/** Method to add new rules.
	 * 
	 * @param  ruleNumber : Integer like 1,2,3,4.
	 * @param  operation  : Keyword specifying operation. e.g. 'capitalize' to get capitalized output
	 * @return true on successful addition of operation.
	 */
	public boolean addRule(int ruleNumber, String operation) {

		// Don't allow to modify already created rules..
		if (rulesMap.containsKey(ruleNumber)) {
			return false;
		}
		
		rulesMap.put(ruleNumber, message -> message.toUpperCase());
		return true;
	}
	
	/** Method to delete rule
	 * 
	 * @param ruleNumner : Integer like 1,2,3,4.
	 * @return           : true on success
	 */
	public boolean deleteRule(int ruleNumner) {
		if(rulesMap.containsKey(ruleNumner)) {
			rulesMap.remove(ruleNumner);
		}
		return true;
	}
	
}
