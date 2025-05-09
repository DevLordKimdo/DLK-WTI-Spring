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
	
	// application.properties 에 지정한 변수 가져오기
    @Value("${location.fio.path}")
    private String fioPath;
	
	@GetMapping({"/tmpl/fio/crud/basic","/tmpl/fio/crud/basic/list"})
	public String list(Model model) throws IOException {
		
		List<FioCrudDTO> list = fioCrudBasicService.list(fioPath);
			
		model.addAttribute("list", list);

		return "fio/crud/basic/list";
	}
	
	@GetMapping("/tmpl/fio/crud/basic/create")
	public String create() {
		
		return "fio/crud/basic/create";
	}
	
	@PostMapping("/tmpl/fio/crud/basic/create")
	public String create(FioCrudDTO fioCrudDTO) throws IOException {
		
		fioCrudBasicService.create(fioPath,fioCrudDTO);
		
		return "redirect:/tmpl" + "/fio/crud/basic/list";
	}
	
	@GetMapping("/tmpl/fio/crud/basic/read/{name}")
	public String read(@PathVariable("name") String name, Model model) throws IOException {
		
		FioCrudDTO fioCrudDTO = fioCrudBasicService.read(fioPath, name);
		model.addAttribute("read", fioCrudDTO);
		
		return "fio/crud/basic/read";
	}
	
	@PostMapping("/tmpl/fio/crud/basic/update/{preName}")
	public String update(@PathVariable("preName") String preName, FioCrudDTO fioCrudDTO) throws IOException {

		fioCrudBasicService.update(fioPath, preName, fioCrudDTO);
		String name = fioCrudDTO.getName();
		
		return "redirect:/tmpl" + "/fio/crud/basic/read/" + name;
	}
	
	@GetMapping("/tmpl/fio/crud/basic/delete/{name}")
	public String delete(@PathVariable("name") String name) throws IOException {
		
		fioCrudBasicService.delete(fioPath, name);
		
		return "redirect:/tmpl" + "/fio/crud/basic/list";
	}
	
}

// 물리적인 파일 CRUD 기능.
// 선행작업으로 C:/fio 경로의 폴더 만들기 필요.
// 주의. 한글로 입력/생성/저장 할 시 유니코드 오류가 발생되므로 영어로만 작성할것.
// 주의. 텍스트로 입력된 파일만 넣을 것.