package dlk.wti.spring.auth.login.session;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class AuthLoginSessionService {

    public void requestSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("username", "admin");
    }

    public void deleteSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
    }
}
