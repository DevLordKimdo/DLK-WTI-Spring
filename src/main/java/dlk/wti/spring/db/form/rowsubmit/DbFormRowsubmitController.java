package dlk.wti.spring.db.form.rowsubmit;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DbFormRowsubmitController {
	
    private final DbFormRowsubmitService dbFormRowsubmitService;
    public DbFormRowsubmitController(DbFormRowsubmitService dbFormRowsubmitService) {this.dbFormRowsubmitService = dbFormRowsubmitService;}
	
	@GetMapping({"/db/form/row-submit","/db/form/row-submit/form"})
	public String form() {
		
		return "db/form/rowsubmit/form";
	}
	
	@PostMapping("/db/form/row-submit/submit")
	public String submit(@RequestParam("title")   List<String> title, 
			             @RequestParam("name")    List<String> name,
			             @RequestParam("content") List<String> content) {
		
		dbFormRowsubmitService.submit(title, name, content);
		
		return "redirect:/fe/form/row-submit/form";
	}
	

}
