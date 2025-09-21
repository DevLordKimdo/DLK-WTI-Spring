package dlk.wti.spring.uix.form.searchselectbox;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dlk.wti.spring.uix.form.dto.UixFormDTO;

@Controller
public class UixFormSearchselectboxController {
	
    private final UixFormSearchselectboxService uixFormSearchselectboxService;
    public UixFormSearchselectboxController(UixFormSearchselectboxService uixFormSearchselectboxService) {this.uixFormSearchselectboxService = uixFormSearchselectboxService;}
    
	
	@GetMapping({"/tmpl/uix/form/search-selectbox","/tmpl/uix/form/search-selectbox/form"})
	public String form(Model model) throws JsonProcessingException {
		
		List<UixFormDTO> listUser = uixFormSearchselectboxService.listUser();
		
	    ObjectMapper objectMapper = new ObjectMapper();
	    String listUserJson = objectMapper.writeValueAsString(listUser);
	    
	    model.addAttribute("listUserJson", listUserJson);
    	model.addAttribute("listUser", listUser);
    	    	
		return "uix/form/searchselectbox/form";
	}
	
	@PostMapping("/tmpl/uix/form/search-selectbox/submit")
	public String submit(UixFormDTO uixFormDTO) {
		
		System.out.println("Username : " + uixFormDTO.getUsername());
		System.out.println("manages  : " + uixFormDTO.getManages());

		return "redirect:/tmpl" + "/uix/form/search-selectbox/form";
	}

}
