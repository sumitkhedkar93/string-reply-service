// license/copyright header
package com.beta.replyservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Modified ReplyController as per requirements.
 * @author Sumit Khedkar
 */
@RestController
@RequestMapping("v2")
public class ReplyControllerV2 {
	
	@Autowired
	private ReplyService replyService;
	
	private Logger logger = LoggerFactory.getLogger(ReplyControllerV2.class);

	@GetMapping("/reply")
	public ReplyMessage replying() {
		return new ReplyMessage("Message is empty");
	}
	
	@GetMapping("/reply/{message}")
	public ReplyMessage replying(@PathVariable String message) {

		// Validate input based on different parameters.
		if (!replyService.validateMessage(message)) {
			logger.error("Discarding the request.");
			throw new IllegalArgumentException("Invalid parameters received.");
		}
		
		String result = replyService.handleRequest(message);
		logger.info("Request completed successfully for input: {}", message);
		
		return new ReplyMessage(result);
	}

}