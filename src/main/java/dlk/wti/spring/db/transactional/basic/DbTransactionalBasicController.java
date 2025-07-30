package dlk.wti.spring.db.transactional.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import dlk.wti.spring.db.crud.dto.DbCrudDTO;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class DbTransactionalBasicController {
	
    private final DbTransactionalBasicService dbTransactionalBasicService;
    public DbTransactionalBasicController(DbTransactionalBasicService dbTransactionalBasicService) {this.dbTransactionalBasicService = dbTransactionalBasicService;}

	@GetMapping({"/tmpl/db/transactional/basic","/tmpl/db/transactional/basic/form"})
	public String form() {

		return "db/transactional/basic/form";
	}
	
	@PostMapping("/tmpl/db/transactional/basic/form")
	public String form(DbCrudDTO dbCrudDTO, HttpServletRequest request) {
		
		String errorOption = request.getParameter("errorOption");
		String transOption = request.getParameter("transOption");
		
		if(transOption.equals("true")) {
			dbTransactionalBasicService.createWithTrans(dbCrudDTO, errorOption);
		} else {
			dbTransactionalBasicService.createNoneTrans(dbCrudDTO, errorOption);
		}

		return "redirect:/tmpl" + "/db/transactional/basic/form";
	}
}

// 자바 스프링부트를 이용한 트랜잭션 기능 예제.
// DB 작업 도중 하나라도 문제가 생기면 전체 작업하던 것을 모두 롤백시킴
// 자바 스프링으로 트랜잭션 기능을 구현하는 경우 다음과 같이 3가지 방법이 존재.
// 1. 프레임워크에 지원하는 기능을 이용 <-- (해당 코드에 사용된 기술)
// 2. Mybatis 기능을 이용
// 3. JDBC를 이용하여 직접 트랜잭션 제어 코드를 실행