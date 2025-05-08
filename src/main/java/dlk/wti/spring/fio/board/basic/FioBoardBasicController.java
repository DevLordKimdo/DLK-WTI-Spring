package dlk.wti.spring.fio.board.basic;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import dlk.wti.spring.fio.board.dto.FioBoardDTO;

@Controller
public class FioBoardBasicController {
	
    private final FioBoardBasicService fioBoardBasicService;
    public FioBoardBasicController(FioBoardBasicService fioBoardBasicService) {this.fioBoardBasicService = fioBoardBasicService;}
    
	// application.properties 에 지정한 변수 가져오기
    @Value("${location.fio.path}")
    private String fioPath;

	@GetMapping({"/template/fio/board/basic","/template/fio/board/basic/list"})
	public String list(Model model) {
		
		List<FioBoardDTO> list = fioBoardBasicService.list();
    	model.addAttribute("list", list);
		
		return "fio/board/basic/list";
	}
	
	@PostMapping("/template/fio/board/basic/upload")
	public String upload(@RequestParam("upload") List<MultipartFile> files) {
				
		try {
			fioBoardBasicService.upload(files, fioPath);
        } catch (Exception e) {
            e.printStackTrace();
        }

		return "redirect:/template" + "/fio/board/basic/list";
	}
}

// 파일 게시판을 구현하는 코드
// 사실상 기능들은 다른 기능들 (file UpDown 기능과 DB Crud 기능) 들을 조합한 기능에 그침
// 하지만 파일 업로드 할 시 업로드 회차에 따른 번호값(Group Idx) 부여 라는 로직을 구현하기 위해 만든 기능