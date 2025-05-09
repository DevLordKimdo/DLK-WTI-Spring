package dlk.wti.spring.logic.http.prgpattern;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LogicHttpPrgpatternController {
	
    @GetMapping({"/tmpl/logic/http/prg-pattern","/tmpl/logic/http/prg-pattern/index"})
	public String index(ModelMap modelMap, Model model) {
    	
    	// 다른 방식으로 메소드 파라미터에 ModelMap 대신 @ModelAttribute("") 를 사용 가능.
    	// 예시 : public String index(@ModelAttribute("value") String value, Model model) {
    	
    	model.addAttribute("value", modelMap.get("value"));
    	
    	return "logic/http/prgpattern/index";
    }
    
    @PostMapping("/tmpl/logic/http/prg-pattern/submit-post")
	public String submitPost(HttpServletRequest request, RedirectAttributes redirectAttributes) {
    	
    	redirectAttributes.addFlashAttribute("value", request.getParameter("value"));
    	
    	return "redirect:/tmpl" + "/logic/http/prg-pattern/index";
    }

}
