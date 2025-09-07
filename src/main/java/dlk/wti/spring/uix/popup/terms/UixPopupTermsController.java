package dlk.wti.spring.uix.popup.terms;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UixPopupTermsController {
	@GetMapping({"/tmpl/uix/popup/terms","/tmpl/uix/popup/terms/index"})
	public String index() {

		return "uix/popup/terms/index";
	}
	
	@GetMapping("/tmpl/uix/popup/terms/{terms}")
	@ResponseBody
	public ResponseEntity<String> terms(@PathVariable("terms") String terms) throws IOException {

		Path termsPath    = Paths.get("src/main/resources/templates", "uix/popup/terms", terms + ".html");
		String termsContent = Files.readString(termsPath, StandardCharsets.UTF_8);
		
		return ResponseEntity.ok()
				.contentType(MediaType.TEXT_HTML)
				.body(termsContent);
	}
}
