package dlk.wti.spring.ws.connect.basic;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WsConnectHandler extends TextWebSocketHandler {

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("클라이언트 연결됨: " + session.getId());
    }
	
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String receivedMessage = message.getPayload();
        // 서버에서 수신한 메시지 출력
        System.out.println("수신한 메시지: " + receivedMessage);
        // 클라이언트에게 응답 송신
        session.sendMessage(new TextMessage("서버가 받은 메시지: " + receivedMessage));
    }
    
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("클라이언트 연결 종료: " + session.getId());
    }
    
}