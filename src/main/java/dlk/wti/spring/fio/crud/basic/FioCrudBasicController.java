package dlk.wti.spring.fio.crud.basic;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FioCrudBasicController {
	
	private final FioCrudBasicService fioCrudBasicService;
	public FioCrudBasicController (FioCrudBasicService fioCrudBasicService) { this.fioCrudBasicService = fioCrudBasicService; }
	
    @Value("${location.fio.path}")
    private String fioPath;
	
	@GetMapping({"/fio/crud/basic","/fio/crud/basic/list"})
	public String list(Model model) throws IOException {
		
		List<String> list = fioCrudBasicService.list(fioPath);
	
		model.addAttribute("list", list);

		return "fio/crud/basic/list";
	}
	

}
