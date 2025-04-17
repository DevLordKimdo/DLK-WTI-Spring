package dlk.wti.spring.fio.crud.basic;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dlk.wti.spring.fio.crud.dto.FioCrudDTO;

@Controller
public class FioCrudBasicController {
	
	private final FioCrudBasicService fioCrudBasicService;
	public FioCrudBasicController (FioCrudBasicService fioCrudBasicService) { this.fioCrudBasicService = fioCrudBasicService; }
	
    @Value("${location.fio.path}")
    private String fioPath;
	
	@GetMapping({"/fio/crud/basic","/fio/crud/basic/list"})
	public String list(Model model) throws IOException {
		
		List<FioCrudDTO> list = fioCrudBasicService.list(fioPath);
			
		model.addAttribute("list", list);

		return "fio/crud/basic/list";
	}
	
	@GetMapping("fio/crud/basic/create")
	public String create() {
		
		return "fio/crud/basic/create";
	}
	
	@PostMapping("fio/crud/basic/create")
	public String create(FioCrudDTO fioCrudDTO) throws IOException {
		
		fioCrudBasicService.create(fioPath,fioCrudDTO);
		
		return "redirect:/fio/crud/basic/list";
	}
	
	@GetMapping("fio/crud/basic/read/{name}")
	public String read(@PathVariable("name") String name, Model model) throws IOException {
		
		FioCrudDTO fioCrudDTO = fioCrudBasicService.read(fioPath,name);
		model.addAttribute("read", fioCrudDTO);
		
		return "fio/crud/basic/read";
	}

}

// 물리적인 파일 CRUD 기능.
// 선행작업으로 C:/fio 경로의 폴더 만들기 필요.
