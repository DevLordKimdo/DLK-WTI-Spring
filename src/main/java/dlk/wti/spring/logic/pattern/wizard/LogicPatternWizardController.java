package dlk.wti.spring.logic.pattern.wizard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import dlk.wti.spring.db.crud.dto.DbCrudDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class LogicPatternWizardController {
	
    @GetMapping({"/tmpl/logic/pattern/wizard","/tmpl/logic/pattern/wizard/index"})
	public String index() {
    	
    	return "logic/pattern/wizard/index";
    }
	
    // step1
    @GetMapping("/tmpl/logic/pattern/wizard/step1")
	public String step1(HttpSession session, Model model) {
    	
    	model.addAttribute("username", session.getAttribute("username"));
    	
    	return "logic/pattern/wizard/step1";
    }
    
    @PostMapping("/tmpl/logic/pattern/wizard/step1/back")
	public String step1back() {
    	
    	return "redirect:/tmpl" + "/logic/pattern/wizard/index";
    }
    
    @PostMapping("/tmpl/logic/pattern/wizard/step1/next")
	public String step1next(HttpSession session, DbCrudDTO dbCrudDTO) {
    	
    	session.setAttribute("username", dbCrudDTO.getUsername());
    	
    	return "redirect:/tmpl" + "/logic/pattern/wizard/step2";
    }
    

    // step2
    @GetMapping("/tmpl/logic/pattern/wizard/step2")
	public String step2(HttpSession session, Model model) {
    	
    	if(session.getAttribute("username") == null) {
    		return "redirect:/tmpl" + "/logic/pattern/wizard/index";
    	}
    	
    	model.addAttribute("title", session.getAttribute("title"));
    	
    	return "logic/pattern/wizard/step2";
    }
    
    @PostMapping("/tmpl/logic/pattern/wizard/step2/back")
	public String step2back() {
    	
    	return "redirect:/tmpl" + "/logic/pattern/wizard/step1";
    }
    
    @PostMapping("/tmpl/logic/pattern/wizard/step2/next")
	public String step2next(HttpSession session, DbCrudDTO dbCrudDTO) {
    	
    	session.setAttribute("title", dbCrudDTO.getTitle());
    	
    	return "redirect:/tmpl" + "/logic/pattern/wizard/step3";
    }
    
    // step3
    @GetMapping("/tmpl/logic/pattern/wizard/step3")
	public String step3(HttpSession session) {
    	
    	if(session.getAttribute("username") == null || session.getAttribute("title") == null) {
    		return "redirect:/tmpl" + "/logic/pattern/wizard/index";
    	}
    	
    	return "logic/pattern/wizard/step3";
    }
    
    @PostMapping("/tmpl/logic/pattern/wizard/step3/back")
	public String step3back() {
    	
    	return "redirect:/tmpl" + "/logic/pattern/wizard/step2";
    }
    
    @PostMapping("/tmpl/logic/pattern/wizard/step3/submit")
	public String step3submit(HttpSession session, DbCrudDTO dbCrudDTO) {
    	
    	System.out.println("username : " + session.getAttribute("username"));
    	System.out.println("   title : " + session.getAttribute("title"));
    	System.out.println(" content : " + dbCrudDTO.getContent());
		session.invalidate();
		
    	return "redirect:/tmpl" + "/logic/pattern/wizard/index";
    }
    
	
/*
url 파라미터 값과 함께 get으로 요청 받으면
url 파라미터 값(?param=value) 이런 값들을 세션기록 및 제거 후 리다이렉트 시키는 구조.
    @GetMapping("/tmpl/logic/pattern/wizard/step1")
	public String step1() {
    	

    	return "logic/pattern/wizard/step1";
    }
    
    @GetMapping("/tmpl/logic/pattern/wizard/step2")
	public String step2(HttpSession session, HttpServletRequest request) {
    	Map<String, String[]> allGetParameter = request.getParameterMap();

    	if(allGetParameter.size() > 0) {
    		session.setAttribute("username", request.getParameter("username"));
    		return "redirect:/tmpl" + "/logic/pattern/wizard/step2";
    	}
    	
    	if(session.getAttribute("username") == null) {
    		return "redirect:/tmpl" + "/logic/pattern/wizard/index";
    	}
    	
    	return "logic/pattern/wizard/step2";
    }
    
    @GetMapping("/tmpl/logic/pattern/wizard/step3")
	public String step3(HttpSession session, HttpServletRequest request) {
    	Map<String, String[]> allGetParameter = request.getParameterMap();
    	
    	if(allGetParameter.size() > 0) {
    		session.setAttribute("title", request.getParameter("title"));
    		return "redirect:/tmpl" + "/logic/pattern/wizard/step3";
    	}
    	
    	if(session.getAttribute("username") == null || session.getAttribute("title") == null) {
    		return "redirect:/tmpl" + "/logic/pattern/wizard/index";
    	}

    	return "logic/pattern/wizard/step3";
    }
    
    @PostMapping("/tmpl/logic/pattern/wizard/submit")
	public String submit(HttpSession session, HttpServletRequest request) {
    	
    	System.out.println("username : " + session.getAttribute("username"));
    	System.out.println("   title : " + session.getAttribute("title"));
    	System.out.println(" content : " + request.getParameter("content"));
		session.invalidate();

    	return "redirect:/tmpl" + "/logic/pattern/wizard/index";
    }
*/
}

