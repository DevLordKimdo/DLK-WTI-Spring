package dlk.wti.spring.crud.basic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

@Controller
public class CrudBasicController {
	
    private final CrudBasicService crudBasicService;
    public CrudBasicController(CrudBasicService crudBasicService) {this.crudBasicService = crudBasicService;}
    
	@GetMapping("/crud/basic/list")
	public String list(Model model) {
						
		List<CrudBasicDTO> list = crudBasicService.list();
    	model.addAttribute("list", list);
		
		return "crud/basic/list";
	}
	
	@GetMapping("/crud/basic/create")
	public String create() {
		
		return "crud/basic/create";
	}
	
	@PostMapping("/crud/basic/create")
	public String create(CrudBasicDTO crudBasicDTO) {
		
		crudBasicService.create(crudBasicDTO);
		
		return "redirect:/crud/basic/list";
	}
	
	@GetMapping("/crud/basic/read/{idx}")
	public String read(@PathVariable("idx") String idx, Model model) {
		
		crudBasicService.updateHit(idx);
		CrudBasicDTO crudBasicDTO = crudBasicService.read(idx);
		model.addAttribute("read", crudBasicDTO);
		
		return "crud/basic/read";
	}
	
	@PostMapping("/crud/basic/update/{idx}")
	public String update(@PathVariable("idx") String idx, CrudBasicDTO crudBasicDTO) {
						
		crudBasicDTO.setIdx(idx);
		crudBasicService.update(crudBasicDTO);
		
		return "redirect:/crud/basic/read/" + idx;
	}
	
	@GetMapping("/crud/basic/delete/{idx}")
	public String delete(@PathVariable("idx") String idx) {
		
		crudBasicService.delete(idx);
		
		return "redirect:/crud/basic/list";
	}
	
}
