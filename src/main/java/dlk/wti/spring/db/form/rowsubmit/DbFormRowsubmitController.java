package dlk.wti.spring.db.form.rowsubmit;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dlk.wti.spring.db.crud.dto.DbCrudDTO;

@Controller
public class DbFormRowsubmitController {
	
    private final DbFormRowsubmitService dbFormRowsubmitService;
    public DbFormRowsubmitController(DbFormRowsubmitService dbFormRowsubmitService) {this.dbFormRowsubmitService = dbFormRowsubmitService;}
	
	@GetMapping({"/tmpl/db/form/row-submit","/tmpl/db/form/row-submit/form"})
	public String form() {
		
		return "db/form/rowsubmit/form";
	}
	
	@PostMapping("/tmpl/db/form/row-submit/submit")
	public String submit(@RequestParam("title")    List<String> title, 
			             @RequestParam("username") List<String> username,
			             @RequestParam("content")  List<String> content) {

		List<DbCrudDTO> DbCrudDTO = new ArrayList<>();
		
		for (int i = 0; i < title.size(); i++) {
			DbCrudDTO tempDTO = new DbCrudDTO();
			tempDTO.setTitle(title.get(i));
			tempDTO.setUsername(username.get(i));
			tempDTO.setContent(content.get(i));
			DbCrudDTO.add(tempDTO);
		}
		
		dbFormRowsubmitService.submit(DbCrudDTO);
		
		return "redirect:/tmpl" + "/db/form/row-submit/form";
	}
	
}