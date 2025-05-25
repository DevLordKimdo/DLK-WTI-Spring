package dlk.wti.spring.ws.connect.basic;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WsConnectConfig implements WebSocketConfigurer {
	
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new WsConnectHandler(), "/tmpl/ws/connect/basic/config").setAllowedOrigins("*");
    }
    
}

// @Configuration (설정 클래스 선언)
// @EnableWebSocket (소켓통신 기능 활성화 어노테이션. 이것이 잇어야 웹소켓 기능들이 동작)
// WebSocketHandlerRegistry registry 웹소켓 헨들러.
// registry.addHandler(실제 메세지를 처리할 핸들러 객체, "이 경로로 웹소켓 연결요청이 들어오면 앞의 핸들러가 처리")
// .setAllowedOrigins("*") CROS설정. "*" 는 모든 도메인에서 접속을 허용한다 는 뜻.