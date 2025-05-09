package dlk.wti.spring.auth.cookie.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class AuthCookieBasicController {
	
	private final AuthCookieBasicService authCookieBasicService;
	public AuthCookieBasicController(AuthCookieBasicService authCookieBasicService) {this.authCookieBasicService = authCookieBasicService;}

	@GetMapping({"/tmpl/auth/cookie/basic","/tmpl/auth/cookie/basic/index"})
	public String index() {

		return "auth/cookie/basic/index";
	}
	
	@GetMapping("/tmpl/auth/cookie/basic/request-backend")
	public String requestBackend(HttpServletRequest request, HttpServletResponse response) {
		
		authCookieBasicService.requestBackend(request, response);
		
		return "redirect:/tmpl" + "/auth/cookie/basic/index";
	}
	
	@GetMapping("/tmpl/auth/cookie/basic/check-cookie")
	public String checkCookie(HttpServletRequest request) {
		
		authCookieBasicService.checkCookie(request);
				
		return "redirect:/tmpl" + "/auth/cookie/basic/index";
	}
	
}
