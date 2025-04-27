package dlk.wti.spring.fio.board.basic;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import dlk.wti.spring.fio.board.dto.FioBoardDTO;

@Service
public class FioBoardBasicService {
	
    private final FioBoardBasicRepository fioBoardBasicRepository;
    public FioBoardBasicService(FioBoardBasicRepository fioBoardBasicRepository) {this.fioBoardBasicRepository = fioBoardBasicRepository;}
    
	public List<FioBoardDTO> list(){
		
		List<FioBoardDTO> list = fioBoardBasicRepository.list();

		if (!list.isEmpty()) {
		    String prevGroupIdx = list.get(0).getGroupIdx();

		    // GroupIdx 그룹화. 같은 GroupIdx 번호 끼리는 대표자 번호를 제외한 나머지 GroupIdx 는 null로 변환
		    for (int i = 1; i < list.size(); i++) {
		    	FioBoardDTO currentDTO = list.get(i);
		        String currentGroupIdx = currentDTO.getGroupIdx();

		        if (currentGroupIdx != null && currentGroupIdx.equals(prevGroupIdx)) {
		            currentDTO.setGroupIdx(null);
		        } else {
		        	prevGroupIdx = currentGroupIdx;
		        }
		    }
		}
		
		return list;
	}
	
	public void upload(List<MultipartFile> files, String directory) throws IOException {
		
		
		// 새로운 GroupIdx 값 생성
		String newGroupIdx = fioBoardBasicRepository.newGroupIdx();
		
		// 순차적으로 DB에 INSERT
		for (int i = 0; i < files.size(); i++) {
			MultipartFile file = files.get(i);
			FioBoardDTO fioBoardDTO = new FioBoardDTO();
			fioBoardDTO.setGroupIdx(newGroupIdx);
			fioBoardDTO.setName(file.getOriginalFilename());
			fioBoardDTO.setSeq(Integer.toString(i+1));
			fioBoardDTO.setSize(Long.toString(file.getSize()));
	    	
	    	fioBoardBasicRepository.upload(fioBoardDTO);
	    }
	    
		// 첨부파일 물리 드라이브에 업로드
        Path uploadPath = Paths.get(directory);
        
        // 경로에 폴더가 없을 시 폴더 생성
        if (!Files.exists(uploadPath)) {
        	Files.createDirectories(uploadPath);
        }
        
        for (MultipartFile file : files) {
            String fileName = file.getOriginalFilename();
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        }
	}

}
