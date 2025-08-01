package dlk.wti.spring.db.form.rowsubmit;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dlk.wti.spring.db.crud.dto.DbCrudDTO;

@CrossOrigin(maxAge = 3600)
@RestController
public class DbFormRowsubmitRestController {
	
    private final DbFormRowsubmitService dbFormRowsubmitService;
    public DbFormRowsubmitRestController(DbFormRowsubmitService dbFormRowsubmitService) {this.dbFormRowsubmitService = dbFormRowsubmitService;}
	

	@PostMapping("/rest/db/form/row-submit/submit")
	public ResponseEntity<String> submit(@RequestBody List<DbCrudDTO> dbCrudDTO) {
		
		dbFormRowsubmitService.submit(dbCrudDTO);
		
		return ResponseEntity.ok("Success");
	}
	
}
