package dlk.wti.spring.db.transactional.basic;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dlk.wti.spring.db.transactional.dto.DbTransactionalDTO;

@CrossOrigin(maxAge = 3600)
@RestController
public class DbTransactionalBasicRestController {
	
    private final DbTransactionalBasicService dbTransactionalBasicService;
    public DbTransactionalBasicRestController(DbTransactionalBasicService dbTransactionalBasicService) {this.dbTransactionalBasicService = dbTransactionalBasicService;}
	
	@PostMapping("/rest/db/transactional/basic/form")
	public ResponseEntity<String> form(@RequestBody DbTransactionalDTO dbTransactionalDTO) {
		
		String errorOption = dbTransactionalDTO.getErrorOption();
		String transOption = dbTransactionalDTO.getTransOption();
		
		if(transOption.equals("true")) {
			dbTransactionalBasicService.createWithTrans(dbTransactionalDTO, errorOption);
		} else {
			dbTransactionalBasicService.createNoneTrans(dbTransactionalDTO, errorOption);
		}

		return ResponseEntity.ok("Success");
	}
}

// REST API는 데이터를 받을 때 JSON 하나만 받도록 구조를 만드는게 표준.
// 그래서 DTO를 하나 더 만들게 되었음.