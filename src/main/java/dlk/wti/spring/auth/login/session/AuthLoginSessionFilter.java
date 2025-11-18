package dlk.wti.spring.auth.login.session;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;

@Component
@Order(1)
public class AuthLoginSessionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest  httpRequest  = (HttpServletRequest)  request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);
        String uri = httpRequest.getRequestURI();

        // /tmpl 로 접속한 사용자 처리
        if (uri.startsWith("/tmpl/auth/login/session") && !uri.equals("/tmpl/auth/login/session/login")) {
            if (session == null || !"admin".equals(session.getAttribute("username"))) {
                httpResponse.sendRedirect("/tmpl/auth/login/session/login");
                return;
            }
        }
        if (uri.equals("/tmpl/auth/login/session/login")) {
            if (session != null && "admin".equals(session.getAttribute("username"))) {
                httpResponse.sendRedirect("/tmpl/auth/login/session/index");
                return;
            }
        }

        // /rest 로 접속한 사용자 처리
        if (uri.startsWith("/rest/auth/login/session") && !uri.equals("/rest/auth/login/session/login")) {
            if (session != null && "admin".equals(session.getAttribute("username"))) {
                System.out.println("세션이 없습니다.");
                return;
            }
        }
        if (uri.equals("/rest/auth/login/session/login")) {
            if (session != null && "admin".equals(session.getAttribute("username"))) {
                System.out.println("로그인된 사용자입니다.");
                return;
            }
        }

        // 통과
        chain.doFilter(request, response);
    }
}