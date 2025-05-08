package dlk.wti.spring.fio.updown.basic;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class FioUpdownBasicController {
	
    private final FioUpdownBasicService fioUpdownBasicService;
    public FioUpdownBasicController(FioUpdownBasicService fioUpdownBasicService) {this.fioUpdownBasicService = fioUpdownBasicService;}
    
	// application.properties 에 지정한 변수 가져오기
    // 다운로드/업로드 파일 경로 지정
    @Value("${location.fio.path}")
    private String fioPath;
	
	@GetMapping({"/template/fio/updown/basic","/template/fio/updown/basic/form"})
	public String form() {
		
		return "fio/updown/basic/form";
	}

    @GetMapping("/template/fio/updown/basic/sample-download")
    public void sampleDownload(HttpServletResponse response) throws IOException {
        // 다운로드 파일 경로 지정
        final String sampleFile = fioPath + "/sample.png";
    	
    	fioUpdownBasicService.sampleDownload(response, sampleFile);
    }
	
	@PostMapping("/template/fio/updown/basic/single-upload")
	public String SingleUpload(@RequestParam("singleUpload") MultipartFile file) throws IOException {
				
    	fioUpdownBasicService.singleUpload(file, fioPath);

		return "redirect:/template" + "/fio/updown/basic/form";
	}
	
	@PostMapping("/template/fio/updown/basic/multi-upload")
	public String multiUpload(@RequestParam("multiUpload") List<MultipartFile> files)  throws IOException {
		
    	fioUpdownBasicService.multiUpload(files, fioPath);
		
		return "redirect:/template" + "/fio/updown/basic/form";
	}
	
	@PostMapping("/template/file-io/basic/delete-target")
	public String deleteTarget(HttpServletRequest request) throws IOException {
		        
		// 삭제 대상 파일 이름
		String deleteTarget = request.getParameter("deleteTarget"); // 삭제할 파일 이름
		
		fioUpdownBasicService.deleteTarget(fioPath, deleteTarget);
		
        return "redirect:/template" + "/file-io/basic/form";
	}
	
	@GetMapping("/template/fio/updown/basic/delete-all")
	public String deleteAll() throws IOException {
				
        fioUpdownBasicService.deleteAll(fioPath);

		return "redirect:/template" + "/fio/updown/basic/form";
	}
}

// 파일 업/다운로드 예제 소스 구현
// 주의 fio 경로 (C:/fio) 폴더가 있어야 할것. (없어도 자동으로 생성되는 코드는 적용되어 있음)
// 주의 sampleDownload 기능을 사용하기 위해서는 C:/fio/sample.png 경로의 파일이 있어야 함.