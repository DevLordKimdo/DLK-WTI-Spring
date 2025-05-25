package dlk.wti.spring.ws.connect.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WsConnectBasicController {
	
    @GetMapping({"/tmpl/ws/connect/basic","/tmpl/ws/connect/basic/index"})
    public String index() {
    	
        return "ws/connect/basic/index";
    }

}

// 웹소켓 기능.
// 화면에서 연결(웹소켓 연결), 연결해제(웹소켓 연결해제), 메세지 전송 3개의 기능이 구현됨
// 메세지를 전송하면 서버에서 메세지 내용이 출력되며
// 그 메세지를 다시 클라이언트 웹브라우저의 consolg 로 출력함