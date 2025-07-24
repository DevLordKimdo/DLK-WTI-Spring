package dlk.wti.spring.db.search.basic;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dlk.wti.spring.db.search.dto.DbSearchDTO;

@CrossOrigin(maxAge = 3600)
@RestController
public class DbSearchBasicRestController {

	private final DbSearchBasicService dbSearchBasicService;
	DbSearchBasicRestController(DbSearchBasicService dbSearchBasicService) {this.dbSearchBasicService = dbSearchBasicService;}

	@PostMapping("/rest/db/search/basic/list")
	public ResponseEntity<List<DbSearchDTO>> search(@RequestBody DbSearchDTO dbSearchDTO) {
		
		List<DbSearchDTO> list = dbSearchBasicService.list(dbSearchDTO);
		
		return ResponseEntity.ok(list);
	}
}