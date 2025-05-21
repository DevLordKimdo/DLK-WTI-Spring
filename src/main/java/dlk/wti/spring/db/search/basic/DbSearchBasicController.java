package dlk.wti.spring.db.search.basic;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import dlk.wti.spring.db.search.dto.DbSearchDTO;

@Controller
public class DbSearchBasicController {
	
	private final DbSearchBasicService dbSearchBasicService;
	DbSearchBasicController(DbSearchBasicService dbSearchBasicService) {this.dbSearchBasicService = dbSearchBasicService;}
	
	@GetMapping({"/tmpl/db/search/basic","/tmpl/db/search/basic/list"})
	public String list(Model model, DbSearchDTO dbSearchDTO) {
						
		List<DbSearchDTO> list = dbSearchBasicService.list(dbSearchDTO);
    	model.addAttribute("list", list);
    	model.addAttribute("search", dbSearchDTO);
		
		return "db/search/basic/list";
	}
	
	@PostMapping("/tmpl/db/search/basic/list")
	public String search(Model model, DbSearchDTO dbSearchDTO) {
						
		List<DbSearchDTO> list = dbSearchBasicService.list(dbSearchDTO);
    	model.addAttribute("list", list);
    	model.addAttribute("search", dbSearchDTO);
		
		return "db/search/basic/list";
	}

}
