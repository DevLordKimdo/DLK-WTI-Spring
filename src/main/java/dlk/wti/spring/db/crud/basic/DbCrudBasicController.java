package dlk.wti.spring.db.crud.basic;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dlk.wti.spring.db.crud.dto.DbCrudDTO;

@Controller
public class DbCrudBasicController {

    private final DbCrudBasicService dbCrudBasicService;
    public DbCrudBasicController(DbCrudBasicService dbCrudBasicService) {this.dbCrudBasicService = dbCrudBasicService;}
    
	@GetMapping({"/tmpl/db/crud/basic","/tmpl/db/crud/basic/list"})
	public String list(Model model) {
						
		List<DbCrudDTO> list = dbCrudBasicService.list();
    	model.addAttribute("list", list);
		
		return "db/crud/basic/list";
	}
	
	@GetMapping("/tmpl/db/crud/basic/create")
	public String create() {
		
		return "db/crud/basic/create";
	}
	
	@PostMapping("/tmpl/db/crud/basic/create")
	public String create(DbCrudDTO dbCrudDTO) {
		
		dbCrudBasicService.create(dbCrudDTO);
		
		return "redirect:/tmpl" + "/db/crud/basic/list";
	}
	
	@GetMapping("/tmpl/db/crud/basic/read/{idx}")
	public String read(@PathVariable("idx") String idx, Model model) {
		
		dbCrudBasicService.updateHit(idx);
		DbCrudDTO dbCrudDTO = dbCrudBasicService.read(idx);
		model.addAttribute("read", dbCrudDTO);
		
		return "db/crud/basic/read";
	}
	
	@PostMapping("/tmpl/db/crud/basic/update/{idx}")
	public String update(@PathVariable("idx") String idx, DbCrudDTO dbCrudDTO) {
						
		dbCrudDTO.setIdx(idx);
		dbCrudBasicService.update(dbCrudDTO);
		
		return "redirect:/tmpl" + "/db/crud/basic/read/" + idx;
	}
	
	@GetMapping("/tmpl/db/crud/basic/delete/{idx}")
	public String delete(@PathVariable("idx") String idx) {
		
		dbCrudBasicService.delete(idx);
		
		return "redirect:/tmpl" + "/db/crud/basic/list";
	}
	
}
