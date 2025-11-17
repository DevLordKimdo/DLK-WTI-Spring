package dlk.wti.spring.auth.login.session;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@CrossOrigin(origins = "${front.server.url}",
        maxAge = 3600,
        allowCredentials = "true")
@RestController
public class AuthLoginSessionRestController {

    private final AuthLoginSessionService authLoginSessionService;
    public AuthLoginSessionRestController(AuthLoginSessionService authLoginSessionService) {this.authLoginSessionService = authLoginSessionService;}

    @PostMapping("/rest/auth/login/session/login")
    public ResponseEntity<String> loginPost(@RequestBody HashMap<String, Object> map, HttpServletRequest request) {
        System.out.println(map);

        // null 포인터 값 오류 해결해줘야함. 프론트쪽에서 '' 나 null 을 보내버리면 error 발생
        String username = map.get("username").toString();
        String password = map.get("password").toString();

        if(username.equals("admin") && password.equals("1234")) {
            authLoginSessionService.requestSession(request);
        }

        return ResponseEntity.ok("Success");
    }

    @PostMapping("/rest/auth/login/session/logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {

        authLoginSessionService.deleteSession(request);

        return ResponseEntity.ok("Success");
    }

}