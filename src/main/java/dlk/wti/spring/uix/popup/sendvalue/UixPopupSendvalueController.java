package dlk.wti.spring.uix.popup.sendvalue;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UixPopupSendvalueController {

	@GetMapping({"/tmpl/uix/popup/send-value","/tmpl/uix/popup/send-value/index"})
	public String index() {

		return "uix/popup/sendvalue/index";
	}
	
	@GetMapping("/tmpl/uix/popup/send-value/popup")
	public String popup() {

		return "uix/popup/sendvalue/popup";
	}
	
}