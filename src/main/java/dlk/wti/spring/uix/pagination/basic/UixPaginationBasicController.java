package dlk.wti.spring.uix.pagination.basic;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dlk.wti.spring.uix.pagination.dto.UixPaginationDTO;
import dlk.wti.spring.util.UtilPagination;

@Controller
public class UixPaginationBasicController {
	
    private final UixPaginationBasicService uixPaginationBasicService;
    public UixPaginationBasicController(UixPaginationBasicService uixPaginationBasicService) {this.uixPaginationBasicService = uixPaginationBasicService;}

    @GetMapping("/tmpl/uix/pagination/basic/list/{currentPageIndex}")
	public String getList(@PathVariable("currentPageIndex") int currentPageIndex , Model model) {

		int count = uixPaginationBasicService.count();
		int postsPerPage = 10;
		int pageStartIndex = (currentPageIndex - 1) * postsPerPage;
		UtilPagination utilPagination = new UtilPagination(currentPageIndex, postsPerPage, count);
		model.addAttribute("page", utilPagination);

		UixPaginationDTO uixPaginationDTO = new UixPaginationDTO();
		uixPaginationDTO.setPostsPerPage(postsPerPage);
		uixPaginationDTO.setPageStart(pageStartIndex);
		
		List<UixPaginationDTO> list = uixPaginationBasicService.list(uixPaginationDTO);
    	model.addAttribute("list", list);
		
		return "uix/pagination/basic/list";
	}
    
    @PostMapping("/tmpl/uix/pagination/basic/list/{currentPageIndex}")
	public String postList(@PathVariable("currentPageIndex") int currentPageIndex , Model model) {

		int count = uixPaginationBasicService.count();
		int postsPerPage = 10;
		int pageStartIndex = (currentPageIndex - 1) * postsPerPage;
		UtilPagination utilPagination = new UtilPagination(currentPageIndex, postsPerPage, count);
		model.addAttribute("page", utilPagination);

		UixPaginationDTO uixPaginationDTO = new UixPaginationDTO();
		uixPaginationDTO.setPostsPerPage(postsPerPage);
		uixPaginationDTO.setPageStart(pageStartIndex);
		
		List<UixPaginationDTO> list = uixPaginationBasicService.list(uixPaginationDTO);
    	model.addAttribute("list", list);
		
		return "uix/pagination/basic/list";
	}
}

// 페이징 기능
// Util 패키지의 UtilPagination 로 따로 빼놓음.
// 같은 코드를 get과 post로 빼놓은 이유는 템플릿 페이지에서 페이지 전환 시 post로 데이터를 보내기 때문.
// getList 만 쓰고싶다면 listhref.html 를 쓰면 된다.
// 참고 : 첫번째 페이지 번호와 마지막 페이지 번호 출력 기능도 있다.
// startPageIndex 와 lastPageIndex