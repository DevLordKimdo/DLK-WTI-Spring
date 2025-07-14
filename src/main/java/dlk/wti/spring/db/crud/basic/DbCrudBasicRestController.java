package dlk.wti.spring.db.crud.basic;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dlk.wti.spring.db.crud.dto.DbCrudDTO;

@CrossOrigin(maxAge = 3600)
@RestController
public class DbCrudBasicRestController {
	
    private final DbCrudBasicService dbCrudBasicService;
    public DbCrudBasicRestController(DbCrudBasicService dbCrudBasicService) {this.dbCrudBasicService = dbCrudBasicService;}
    
	@GetMapping({"/rest/db/crud/basic","/rest/db/crud/basic/list"})
	public ResponseEntity<List<DbCrudDTO>> List() {
						
		List<DbCrudDTO> list = dbCrudBasicService.list();
		
		return ResponseEntity.ok(list);
	}
	
	@PostMapping("/rest/db/crud/basic/create")
	public ResponseEntity<String> Create(@RequestBody DbCrudDTO dbCrudDTO) {
		
		dbCrudBasicService.create(dbCrudDTO);
		
		return ResponseEntity.ok("Success");
	}
	
	@GetMapping("/rest/db/crud/basic/read/{idx}")
	public ResponseEntity<DbCrudDTO> Read(@PathVariable("idx") String idx) {
		
		dbCrudBasicService.updateHit(idx);
		DbCrudDTO dbCrudDTO = dbCrudBasicService.read(idx);
		
		return ResponseEntity.ok(dbCrudDTO);
	}
	
	@PostMapping("/rest/db/crud/basic/update/{idx}")
	public ResponseEntity<String> Update(@PathVariable("idx") String idx, @RequestBody DbCrudDTO dbCrudDTO) {

		dbCrudDTO.setIdx(idx);
		dbCrudBasicService.update(dbCrudDTO);
		
		return ResponseEntity.ok("Success");
	}
	
	@GetMapping("/rest/db/crud/basic/delete/{idx}")
	public ResponseEntity<String> Delete(@PathVariable("idx") String idx) {
		
		dbCrudBasicService.delete(idx);
		
		return ResponseEntity.ok("Success");
	}
}
