package dlk.wti.spring.logic.pattern.prg;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LogicPatternPrgController {
	
    @GetMapping({"/tmpl/logic/pattern/prg","/tmpl/logic/pattern/prg/index"})
	public String index(Model model, ModelMap modelMap) {
    	
    	// 다른 방식으로 메소드 파라미터에 ModelMap 대신 @ModelAttribute("") 를 사용 가능.
    	// 예시 : public String index(@ModelAttribute("value") String value, Model model) { ... }
    	
    	model.addAttribute("content", modelMap.get("content"));
    	
    	return "logic/pattern/prg/index";
    }
    
    @PostMapping("/tmpl/logic/pattern/prg/submit")
	public String submit(HttpServletRequest request, RedirectAttributes redirectAttributes) {
    	
    	// 리다이렉트(GET)으로 보내줄 때 값을 전달해줌
    	redirectAttributes.addFlashAttribute("content", request.getParameter("content"));
    	
    	return "redirect:/tmpl" + "/logic/pattern/prg/done";
    }
    
    @GetMapping("/tmpl/logic/pattern/prg/done")
	public String done() {
    	
    	return "forward:/tmpl" + "/logic/pattern/prg/index";
    }
}

// PRG패턴 구현
// 사용자가 POST 제출 후 뒤로가기를 하여 다시 재전송 하는 상황을 방지하기 위한 패턴