package dlk.wti.spring.fe.form.inputdisable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class FeFormInputdisable {
	
	@GetMapping({"/fe/form/input-disable","/fe/form/input-disable/form"})
	public String form() {

		return "fe/form/inputdisable/form";
	}
	
	@PostMapping("/fe/form/input-disable/submit")
	public String submit(HttpServletRequest request) {
		
		System.out.println( "");
	    System.out.println( "text Normal   Value : " +  request.getParameter("textNormal") );
	    System.out.println( "text Readonly Value : " +  request.getParameter("textReadonly") );
	    System.out.println( "text Disabled Value : " +  request.getParameter("textDisabled") );
	    System.out.println( "text Required Value : " +  request.getParameter("textRequired") );
	    System.out.println( "text Hidden   Value : " +  request.getParameter("textHidden") );
	    
	    System.out.println( "checkbox Normal 1 Value : " +  request.getParameter("checkboxNormal1") );
	    System.out.println( "checkbox Normal 2 Value : " +  request.getParameter("checkboxNormal2") );
	    System.out.println( "checkbox Normal 3 Value : " +  request.getParameter("checkboxNormal3") );
	    System.out.println( "checkbox Readonly True  Value : " +  request.getParameter("checkboxReadonlyTrue") );
	    System.out.println( "checkbox Readonly False Value : " +  request.getParameter("checkboxReadonlyFalse") );
	    System.out.println( "checkbox Disabled True  Value : " +  request.getParameter("checkboxDisabledTrue") );
	    System.out.println( "checkbox Disabled False Value : " +  request.getParameter("checkboxDisabledFalse") );

	    System.out.println( "select Normal   Value : " +  request.getParameter("selectNormal") );
	    System.out.println( "select Readonly Value : " +  request.getParameter("selectReadonly") );
	    System.out.println( "select Disabled Value : " +  request.getParameter("selectDisabled") );
	    
	    System.out.println( "radio Normal   Value : " +  request.getParameter("radioNormal") );
	    System.out.println( "radio Readonly Value : " +  request.getParameter("radioReadonly") );
	    System.out.println( "radio Disabled Value : " +  request.getParameter("radioDisabled") );
	    
	    System.out.println( "textarea Normal   Value : " +  request.getParameter("textareaNormal") );
	    System.out.println( "textarea Readonly Value : " +  request.getParameter("textareaReadonly") );
	    System.out.println( "textarea Disabled Value : " +  request.getParameter("textareaDisabled") );
	    
		return "redirect:/fe/form/input-disable/form";
	}

}
