// license/copyright header 
package com.beta.ruleservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** This class contains EndPoint for adding/deleting rules etc.
 * 
 * @author Sumit Khedkar
 *
 */
@RestController
@RequestMapping("v2")
public class RulesController {
	
	@Autowired
	private RuleService ruleService;
	
	@PostMapping("/rule")
	public void addRule() {
		//TODO
		ruleService.addRule(3, "capitalize");
	}
	
	@DeleteMapping("/rule")
	public void deleteRule() {
		//TODO
		ruleService.deleteRule(3);
	}

}
