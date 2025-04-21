package dlk.wti.spring.fe.form.rowsubmit;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dlk.wti.spring.db.crud.dto.DbCrudDTO;

@Controller
public class FeFormRowsubmitController {
	
    private final FeFormRowsubmitService feFormRowsubmitService;
    public FeFormRowsubmitController(FeFormRowsubmitService feFormRowsubmitService) {this.feFormRowsubmitService = feFormRowsubmitService;}
	
	@GetMapping({"/fe/form/row-submit","/fe/form/row-submit/form"})
	public String form() {
		
		return "fe/form/rowsubmit/form";
	}
	
	@PostMapping("/fe/form/row-submit/submit")
	public String Submit(@RequestParam("title")   List<String> title, 
			             @RequestParam("name")    List<String> name,
			             @RequestParam("content") List<String> content) {
		
		List<DbCrudDTO> DbCrudDTO = feFormRowsubmitService.submit(title, name, content);

		for(DbCrudDTO list : DbCrudDTO) {
			System.out.println(list.getTitle() + " " + list.getName() + " " + list.getContent());
		}
		
		return "redirect:/fe/form/row-submit/form";
	}

}
