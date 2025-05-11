package dlk.wti.spring.uix.iframe.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UixIframeBasicController {
	
	@GetMapping({"/tmpl/uix/iframe/basic","/tmpl/uix/iframe/basic/index"})
	public String index() {
		
		return "uix/iframe/basic/index";
	}
	
	@GetMapping("/tmpl/uix/iframe/basic/content")
	public String content() {
		
		return "uix/iframe/basic/content";
	}
}