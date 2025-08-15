package dlk.wti.spring.auth.cookie.basic;

import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class AuthCookieBasicService {

	public void requestBackend(HttpServletRequest request, HttpServletResponse response) {
		
		// 현재 서버 도메인 이름 불러오기
		String serverName = request.getServerName();
		
		// 현재 서버가 SSL(HTTPS)인증서 적용이 되어 있는지 확인
		boolean isSecure = request.isSecure();
		
		// 발행할 쿠키 값 정보
		ResponseCookie cookie = ResponseCookie.from("backendCookie", "value")
        .path("/")				// 경로
        .maxAge(3600)			// 유효시간
        .httpOnly(true)			// 클라이언트 스크립트에서 접근 불가. 자바스크립트로 쿠키접근하는 것을 차단.
        .secure(isSecure)		// 보안옵션(옵션을 적용하고자 할 경우 서버 도메인이 https 상태여야만 쿠키가 발급됨)
        .sameSite("Lax") 		// 어떤 도메인에서만 사용할 수 있는지 설정. "Strict", "Lax", "None"
        .domain(serverName) 	// 도메인 설정. 필요한 경우
        .build();				// 설정 완료

		// 구형방식
//		Cookie cookie = new Cookie("backendCookie","value");
//		cookie.setPath("/"); 						// 경로
//		cookie.setMaxAge(3600); 					// 유효시간
//	    cookie.setHttpOnly(true); 					// 클라이언트 스크립트에서 접근 불가
//	    cookie.setSecure(isSecure); 					// 보안옵션(옵션을 적용하고자 할 경우 서버 도메인이 https 상태여야만 쿠키가 발급됨)
//	    cookie.setDomain(serverName); 			// 도메인 설정 (필요한 경우)

	    response.addHeader("Set-Cookie", cookie.toString());
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
