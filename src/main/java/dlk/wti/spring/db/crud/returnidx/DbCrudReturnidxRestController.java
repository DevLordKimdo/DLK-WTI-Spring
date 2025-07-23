package dlk.wti.spring.db.crud.returnidx;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dlk.wti.spring.db.crud.dto.DbCrudDTO;

@CrossOrigin(maxAge = 3600)
@RestController
public class DbCrudReturnidxRestController {

    private final DbCrudReturnidxService dbCrudReturnidxService;
    public DbCrudReturnidxRestController(DbCrudReturnidxService dbCrudReturnidxService) {this.dbCrudReturnidxService = dbCrudReturnidxService;}

	@PostMapping("/rest/db/crud/return-idx/create")
	public ResponseEntity<String> Create(@RequestBody DbCrudDTO dbCrudDTO) {

		dbCrudReturnidxService.create(dbCrudDTO);
		System.out.println("Return Idx : " + dbCrudDTO.getIdx());
		
		return ResponseEntity.ok("Success");
	}
	
}
