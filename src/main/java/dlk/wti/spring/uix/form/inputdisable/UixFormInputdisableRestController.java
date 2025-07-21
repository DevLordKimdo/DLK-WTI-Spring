package dlk.wti.spring.uix.form.inputdisable;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin(maxAge = 3600)
@RestController
public class UixFormInputdisableRestController {
	
	@PostMapping("/rest/uix/form/input-disable/submit")
	public ResponseEntity<String> submit(HttpServletRequest request) {
		
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
	    
	    return ResponseEntity.ok("Success");
	}

}
