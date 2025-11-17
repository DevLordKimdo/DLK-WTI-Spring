package dlk.wti.spring.auth.login.session;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthLoginSessionController {

    private final AuthLoginSessionService authLoginSessionService;
    public AuthLoginSessionController(AuthLoginSessionService authLoginSessionService) {this.authLoginSessionService = authLoginSessionService;}

    @GetMapping({"/tmpl/auth/login/session","/tmpl/auth/login/session/index"})
    public String index() {

        return "auth/login/session/index";
    }

    @GetMapping("/tmpl/auth/login/session/login")
    public String loginGet() {

        return "auth/login/session/login";
    }

    @PostMapping("/tmpl/auth/login/session/login")
    public String loginPost(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request) {

        if(username.equals("admin") && password.equals("1234")) {
            authLoginSessionService.requestSession(request);
        }
        
        return "redirect:/tmpl" + "/auth/login/session/index";
    }

    @PostMapping("/tmpl/auth/login/session/logout")
    public String logout(HttpServletRequest request) {

        authLoginSessionService.deleteSession(request);

        return "redirect:/tmpl" + "/auth/login/session/login";
    }
}
