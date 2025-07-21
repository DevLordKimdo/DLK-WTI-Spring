package dlk.wti.spring.uix.form.checkbox;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dlk.wti.spring.uix.form.dto.UixFormDTO;

@CrossOrigin(maxAge = 3600)
@RestController
public class UixFormCheckboxRestController {
	
    private final UixFormCheckboxService uixFormCheckboxService;
    public UixFormCheckboxRestController(UixFormCheckboxService uixFormCheckboxService) {this.uixFormCheckboxService = uixFormCheckboxService;}
    
	@GetMapping({"/rest/uix/form/checkbox","/rest/uix/form/checkbox/list"})
	public ResponseEntity<List<UixFormDTO>> List() {
		
		List<UixFormDTO> list = uixFormCheckboxService.list();

		return ResponseEntity.ok(list);
	}
			
	// JSON 형식으로 들어온 데이터를 DTO를 사용하지 않고 Map을 이용해 바로 꺼내서 사용하나는 방법.
	// JSON 데이터가 다음과 같은 형식으로 들어올 때 사용하면 된다.
	// {"checkIdx": ["1", "2", "3", ...]}
	@PostMapping("/rest/uix/form/checkbox/copy")
	public ResponseEntity<String> copy(@RequestBody Map<String, List<String>> request) {
		
		List<String> checkIdx = request.get("checkIdx");
		uixFormCheckboxService.copy(checkIdx);
		
		return ResponseEntity.ok("success");
	}
	
	/* 
	// 만약 프론트엔드 쪽이 JSON형식이 아닌 FormData 형식으로 보내준다면 코드를 아래처럼 작성해야함. 하지만 REST API 권장사항으로 데이터 전달은 Form 보다는 JSON 방식으로 보내는 것을 권장. 
	@PostMapping("/rest/uix/form/checkbox/copy-form")
	public ResponseEntity<String> copy(@RequestParam(value = "checkIdx", required = false, defaultValue = "") List<String> checkIdx) {

		if(!checkIdx.isEmpty()) {
			uixFormCheckboxService.copy(checkIdx);
		}
		
		return ResponseEntity.ok("success");
	}
	*/

	@PostMapping("/rest/uix/form/checkbox/update")
	public ResponseEntity<String> update(@RequestBody UixFormDTO uixFormDTO) {

		uixFormCheckboxService.update(uixFormDTO);
		
		return ResponseEntity.ok("success");
	}
	
	@PostMapping("/rest/uix/form/checkbox/delete")
	public ResponseEntity<String> delete(@RequestBody Map<String, List<String>> request) {
		
		List<String> checkIdx = request.get("checkIdx");
		uixFormCheckboxService.delete(checkIdx);
		
		return ResponseEntity.ok("success");
	}
}