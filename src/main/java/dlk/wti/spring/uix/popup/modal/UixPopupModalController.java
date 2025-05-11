package dlk.wti.spring.uix.popup.modal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UixPopupModalController {
	
	@GetMapping({"/tmpl/uix/popup/modal","/tmpl/uix/popup/modal/index"})
	public String index() {

		return "uix/popup/modal/index";
	}
}