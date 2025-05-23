package dlk.wti.spring.fio.excel.inport;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FioExcelInportController {
	
	private final FioExcelInportService fioExcelInportService;
	FioExcelInportController(FioExcelInportService fioExcelInportService) {this.fioExcelInportService = fioExcelInportService;}
	
	@GetMapping({"/tmpl/fio/excel/inport","/tmpl/fio/excel/inport/form"})
	public String form() {
		
		return "fio/excel/inport/form";
	}
	
	@PostMapping("/tmpl/fio/excel/inport/upload")
	public String upload(@RequestParam("excelUpload") MultipartFile file) throws IOException {
		
		fioExcelInportService.upload(file);
		
		return "redirect:/tmpl/fio/excel/inport/form";
	}

}
