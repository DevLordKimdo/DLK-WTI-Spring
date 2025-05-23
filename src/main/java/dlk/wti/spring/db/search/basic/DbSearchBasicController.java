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

// 검색기능
// 주의. SQLite의 비트윈절 쓰게되면, 예를들어
// WHERE datetime BETWEEN '2025-01-01' AND '2025-01-02'
// 이런 문장을 쓰게 될 시 날짜 범위처리 방식 때문에
// '2025-01-01 00:00:00' AND '2025-01-02 00:00:00' 로 된다. 즉 48시간을 검색하는게 아닌 24시간만 검색하게 됨.
// 다른 SQL 들 과는 다른 방식을 보여줌.