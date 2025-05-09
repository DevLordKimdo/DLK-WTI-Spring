package dlk.wti.spring.auth.cookie.basic;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class AuthCookieBasicService {

	public void requestBackend(HttpServletRequest request, HttpServletResponse response) {
		
		Cookie cookie = new Cookie("backendCookie","value");
		cookie.setPath(request.getContextPath()); 	// 경로
		cookie.setMaxAge(3600); 					// 유효시간
	    cookie.setHttpOnly(true); 					// 클라이언트 스크립트에서 접근 불가
	    cookie.setSecure(true); 					// 보안옵션(https 연결 전용 옵션)
	    //cookie.setDomain("example.com"); 			// 도메인 설정 (필요한 경우)

		response.addCookie(cookie);
	}
	
	public void checkCookie(HttpServletRequest request) {
		
		System.out.println("쿠키 정보 값 출력");
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				System.out.println("cookie name   : " + cookie.getName());
				System.out.println("cookie value  : " + cookie.getValue());
			}
		} else {
			System.out.println("쿠키가 없습니다.");
		}
	}
	
}
