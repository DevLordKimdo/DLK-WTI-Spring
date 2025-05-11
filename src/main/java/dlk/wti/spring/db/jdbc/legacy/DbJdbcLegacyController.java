package dlk.wti.spring.db.jdbc.legacy;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dlk.wti.spring.db.crud.dto.DbCrudDTO;

@Controller
public class DbJdbcLegacyController {

    private final DbJdbcLegacyService dbJdbcLegacyService;
    public DbJdbcLegacyController(DbJdbcLegacyService dbJdbcLegacyService) {this.dbJdbcLegacyService = dbJdbcLegacyService;}

	@GetMapping({"/tmpl/db/jdbc/legacy","/tmpl/db/jdbc/legacy/list"})
	public String list(Model model) {
		
        List<DbCrudDTO> list = dbJdbcLegacyService.list();        
        model.addAttribute("list", list);
		
		return "db/jdbc/legacy/list";
	}
	
	@GetMapping("/tmpl/db/jdbc/legacy/create")
	public String create() {
		
		return "db/jdbc/legacy/create";
	}
	
	@PostMapping("/tmpl/db/jdbc/legacy/create")
	public String create(DbCrudDTO dbCrudDTO) {
		
		dbJdbcLegacyService.create(dbCrudDTO);
		
		return "redirect:/tmpl" + "/db/jdbc/legacy/list";
	}
	
	@GetMapping("/tmpl/db/jdbc/legacy/read/{idx}")
	public String read(@PathVariable("idx") String idx, Model model) {
		
		dbJdbcLegacyService.updateHit(idx);
		DbCrudDTO dbCrudDTO = dbJdbcLegacyService.read(idx);
		model.addAttribute("read", dbCrudDTO);
		
		return "db/jdbc/legacy/read";
	}
	
	@PostMapping("/tmpl/db/jdbc/legacy/update/{idx}")
	public String update(@PathVariable("idx") String idx, DbCrudDTO dbCrudDTO) {
						
		dbCrudDTO.setIdx(idx);
		dbJdbcLegacyService.update(dbCrudDTO);
		
		return "redirect:/tmpl" + "/db/jdbc/legacy/read/" + idx;
	}
	
	@GetMapping("/tmpl/db/jdbc/legacy/delete/{idx}")
	public String delete(@PathVariable("idx") String idx) {
		
		dbJdbcLegacyService.delete(idx);
		
		return "redirect:/tmpl" + "/db/jdbc/legacy/list";
	}
	
}
