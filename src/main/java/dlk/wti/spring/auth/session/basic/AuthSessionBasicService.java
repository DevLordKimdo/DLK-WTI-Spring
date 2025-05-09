package dlk.wti.spring.auth.session.basic;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class AuthSessionBasicService {
	
	public void requestSession(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(3600);
		session.setAttribute("session-name", "value");
		
	}
	
	public void checkSession(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		System.out.println(session.getAttribute("session-name"));
		
		     if (session.getAttribute("session-name") == null) { System.out.println("세션이 없습니다."); }
		else if (session.getAttribute("session-name") == "value") { System.out.println("유효한 세션입니다."); }
		else { System.out.println("유효한 세션이 아닙니다."); }

	}
	
	public void deleteSession(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.invalidate();
		
	}
}
