package dlk.wti.spring.uix.form.imagepreview;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UixFormImagePreviewController {
	
	@GetMapping({"/tmpl/uix/form/image-preview","/tmpl/uix/form/image-preview/form"})
	public String form() {

		return "uix/form/imagepreview/form";
	}
}
