package dlk.wti.spring.db.crud.returnidx;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import dlk.wti.spring.db.crud.dto.DbCrudDTO;

@Controller
public class DbCrudReturnidxController {
	
    private final DbCrudReturnidxService dbCrudReturnidxService;
    public DbCrudReturnidxController(DbCrudReturnidxService dbCrudReturnidxService) {this.dbCrudReturnidxService = dbCrudReturnidxService;}
	
	@GetMapping({"/tmpl/db/crud/return-idx","/tmpl/db/crud/return-idx/create"})
	public String create() {
		
		return "db/crud/returnidx/create";
	}
	
	@PostMapping("/tmpl/db/crud/return-idx/create")
	public String create(DbCrudDTO dbCrudDTO) {

		dbCrudReturnidxService.create(dbCrudDTO);
		System.out.println("Return Idx : " + dbCrudDTO.getIdx());
		
		return "redirect:/tmpl" + "/db/crud/return-idx/create";
	}

}
