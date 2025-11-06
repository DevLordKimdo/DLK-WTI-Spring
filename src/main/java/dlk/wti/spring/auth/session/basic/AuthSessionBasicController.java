package dlk.wti.spring.auth.session.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AuthSessionBasicController {
	
	private final AuthSessionBasicService authSessionBasicService;
	public AuthSessionBasicController(AuthSessionBasicService authSessionBasicService) {this.authSessionBasicService = authSessionBasicService;}
	
	@GetMapping({"/tmpl/auth/session/basic","/tmpl/auth/session/basic/index"})
	public String index() {
		
		return "auth/session/basic/index";
	}
	
	@GetMapping("/tmpl/auth/session/basic/request-session")
	public String requestSession(HttpServletRequest request) {
		
		authSessionBasicService.requestSession(request);
		
		return "redirect:/tmpl" + "/auth/session/basic/index";
	}
	
	@GetMapping("/tmpl/auth/session/basic/check-session")
	public String checkSession(HttpServletRequest request) {
		
		authSessionBasicService.checkSession(request);
		
		return "redirect:/tmpl" + "/auth/session/basic/index";
	}
	
	@GetMapping("/tmpl/auth/session/basic/delete-session")
	public String deleteSession(HttpServletRequest request) {
		
		authSessionBasicService.deleteSession(request);
		
		return "redirect:/tmpl" + "/auth/session/basic/index";
	}
}