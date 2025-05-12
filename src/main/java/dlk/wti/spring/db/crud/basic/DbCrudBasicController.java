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

// 의존성 주입 하는 방법
// 첫번째(현재 방법) - 생성자 주입방법. final로 불변성 객체로 선언할 수 있음.
// private final DbCrudBasicService dbCrudBasicService;
// public DbCrudBasicController(DbCrudBasicService dbCrudBasicService) {this.dbCrudBasicService = dbCrudBasicService;}
//
// 두번째(@Autowired 어노테이션) - final을 안쓰기 때문에 불변성을 보장하지 못하고 Spring 프레임워크 의존도를 높이는 단점이 있음.
// @Autowired
// private DbCrudBasicService dbCrudBasicService;
