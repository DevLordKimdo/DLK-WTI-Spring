package dlk.wti.spring.fio.excel.export;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FioExcelExportController {
	
	private final FioExcelExportService fioExcelExportService;
	FioExcelExportController(FioExcelExportService fioExcelExportService) {this.fioExcelExportService = fioExcelExportService;}
	
	@GetMapping({"/tmpl/fio/excel/export","/tmpl/fio/excel/export/index"})
	public String index() {
		
		return "fio/excel/export/index";
	}
	
	@GetMapping("/tmpl/fio/excel/export/down-excel")
	public ResponseEntity<byte[]> downExcel() throws IOException {
	    byte[] excelFile = fioExcelExportService.downExcel();
	    
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	    headers.setContentDispositionFormData("attachment", "ResultDATA.xlsx");
	    
	    return new ResponseEntity<>(excelFile, headers, HttpStatus.OK);
	}
	
	@GetMapping("/tmpl/fio/excel/export/down-excel-enhance")
	public ResponseEntity<byte[]> downExcelEnhance() throws IOException {
	    byte[] excelFile = fioExcelExportService.downExcelEnhance();
	    
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	    headers.setContentDispositionFormData("attachment", "ResultDATAEnhance.xlsx");
	    
	    return new ResponseEntity<>(excelFile, headers, HttpStatus.OK);
	}

}