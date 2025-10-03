package dlk.wti.spring.logic.pattern.wizard;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class LogicPatternWizardController {
	
    @GetMapping({"/tmpl/logic/pattern/wizard","/tmpl/logic/pattern/wizard/index"})
	public String index() {
    	

    	return "logic/pattern/wizard/index";
    }
    
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
}
