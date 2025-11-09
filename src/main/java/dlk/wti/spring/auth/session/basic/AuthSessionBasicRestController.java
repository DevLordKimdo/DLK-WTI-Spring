package dlk.wti.spring.auth.session.basic;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "${front.server.url}",
        maxAge = 3600,
        allowCredentials = "true")
@RestController
public class AuthSessionBasicRestController {

    private final AuthSessionBasicService authSessionBasicService;
    public AuthSessionBasicRestController(AuthSessionBasicService authSessionBasicService) {this.authSessionBasicService = authSessionBasicService;}

    @PostMapping("/rest/auth/session/basic/request-session")
    public ResponseEntity<String> requestSession(HttpServletRequest request) {
        authSessionBasicService.requestSession(request);

        return ResponseEntity.ok("Success");
    }

    @GetMapping("/rest/auth/session/basic/check-session")
    public ResponseEntity<String> checkSession(HttpServletRequest request) {
        authSessionBasicService.checkSession(request);

        return ResponseEntity.ok("Success");
    }

    @PostMapping("/rest/auth/session/basic/delete-session")
    public ResponseEntity<String> deleteSession(HttpServletRequest request) {
        authSessionBasicService.deleteSession(request);

        return ResponseEntity.ok("Success");
    }
}