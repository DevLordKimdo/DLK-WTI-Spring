package dlk.wti.spring.uix.form.checkbox;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dlk.wti.spring.db.crud.dto.DbCrudDTO;

@Controller
public class UixFormCheckboxController {

    private final UixFormCheckboxService uixFormCheckboxService;
    public UixFormCheckboxController(UixFormCheckboxService uixFormCheckboxService) {this.uixFormCheckboxService = uixFormCheckboxService;}

	@GetMapping({"/tmpl/uix/form/checkbox","/tmpl/uix/form/checkbox/list"})
	public String list(Model model) {
		
		List<DbCrudDTO> list = uixFormCheckboxService.list();
    	model.addAttribute("list", list);

		return "uix/form/checkbox/list";
	}
	
	@PostMapping("/tmpl/uix/form/checkbox/copy")
	public String copy(@RequestParam(value = "checkIdx", required = false, defaultValue = "") List<String> checkIdx) {

		if(!checkIdx.isEmpty()) {
			uixFormCheckboxService.copy(checkIdx);
		}
		
		return "redirect:/tmpl" + "/uix/form/checkbox/list";
	}
	
	@PostMapping("/tmpl/uix/form/checkbox/update")
	public String update(@RequestParam(value = "checkIdx", required = false, defaultValue = "") List<String> checkIdx, DbCrudDTO dbCrudDTO) {

		uixFormCheckboxService.update(checkIdx, dbCrudDTO);
		
		return "redirect:/tmpl" + "/uix/form/checkbox/list";
	}
	
	@PostMapping("/tmpl/uix/form/checkbox/delete")
	public String delete(@RequestParam(value = "checkIdx", required = false, defaultValue = "") List<String> checkIdx) {

		uixFormCheckboxService.delete(checkIdx);
		
		return "redirect:/tmpl" + "/uix/form/checkbox/list";
	}
}
