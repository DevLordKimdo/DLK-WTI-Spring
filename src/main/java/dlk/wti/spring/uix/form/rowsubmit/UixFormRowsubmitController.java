package dlk.wti.spring.uix.form.rowsubmit;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dlk.wti.spring.db.crud.dto.DbCrudDTO;

@Controller
public class UixFormRowsubmitController {
	
	@GetMapping({"/tmpl/uix/form/row-submit","/tmpl/uix/form/row-submit/form"})
	public String form() {
		
		return "uix/form/rowsubmit/form";
	}
	
	@PostMapping("/tmpl/uix/form/row-submit/submit")
	public String submit(@RequestParam("title")    List<String> title, 
			             @RequestParam("username") List<String> username,
			             @RequestParam("content")  List<String> content) {
		
		List<DbCrudDTO> dbCrudDTO = new ArrayList<>();
		
		for (int i = 0; i < title.size(); i++) {
			DbCrudDTO tempDTO = new DbCrudDTO();
			tempDTO.setTitle(title.get(i));
			tempDTO.setUsername(username.get(i));
			tempDTO.setContent(content.get(i));
			dbCrudDTO.add(tempDTO);
		}

		for(DbCrudDTO list : dbCrudDTO) {
			System.out.println(list.getTitle() + " " + list.getUsername() + " " + list.getContent());
		}
		
		return "redirect:/tmpl" + "/uix/form/row-submit/form";
	}
	
	@GetMapping("/tmpl/uix/form/row-submit/form-fetch")
	public String formFetch() {
		
		return "uix/form/rowsubmit/formfetch";
	}
	
	
	@PostMapping("/tmpl/uix/form/row-submit/submit-fetch")
	@ResponseBody
	public String submitFetch(@RequestBody Map<String, List<DbCrudDTO>> request) {
		
		List<DbCrudDTO> dbCrudDTO = request.get("list");
		for(DbCrudDTO list : dbCrudDTO) {
			System.out.println(list.getTitle() + " " + list.getUsername() + " " + list.getContent());
		}
	    
	    return "Success";
	}
}

// JSON 타입으로 전송할 때 백엔드 컨트롤러 에서 JSON 타입의 데이터를 받는 방법
// @RequestBody Map<String, List<Map<String, String>>> request -> JSON 으로 들어온 데이터들을 틀 없이 받아들이기. DTO가 없을 때 임시방편으로 사용 가능.
// @RequestBody Map<String, List<DbCrudDTO>> request -> JSON으로 들어온 데이터들을 DTO 형식으로 받아주기
