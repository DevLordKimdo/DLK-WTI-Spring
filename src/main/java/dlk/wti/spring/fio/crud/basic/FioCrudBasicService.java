package dlk.wti.spring.fio.crud.basic;

import java.io.*;
import java.nio.file.*;
import java.util.*;

import org.springframework.stereotype.Service;

import dlk.wti.spring.fio.crud.dto.FioCrudDTO;

@Service
public class FioCrudBasicService {
	
	private final FioCrudBasicRepository fioCrudBasicRepository;
	public FioCrudBasicService (FioCrudBasicRepository fioCrudBasicRepository) { this.fioCrudBasicRepository = fioCrudBasicRepository; }

	public List<FioCrudDTO> list(String fioPath) throws IOException {
		
		List<FioCrudDTO> list = new ArrayList<>();
    	List<Path> ArrayList = fioCrudBasicRepository.list(fioPath);
    	int i = 0;
    	
    	if(ArrayList != null) {
        	for(Path file : ArrayList) {
        		FioCrudDTO tempDTO = new FioCrudDTO();
        		i++;
        		
        		// 파일 이름, 크기 지정
                String Name = file.getFileName().toString();
                String Size = Long.toString(Files.size(file));
                
                // 확장자 구하기
                String Extension = "";
                int lastIndex = Name.lastIndexOf(".");
                if (lastIndex > 0) { Extension = Name.substring(lastIndex + 1); }
                
                // 번호 부여
                String ListNo = Integer.toString(i);
                
                tempDTO.setName(Name);
                tempDTO.setListNo(ListNo);
                tempDTO.setExtension(Extension);
                tempDTO.setSize(Size);
                list.add(tempDTO);
        	}
    	}
		return list;
	}
	
	public void create(String fioPath, FioCrudDTO fioCrudDTO) throws IOException {
		fioCrudBasicRepository.create(fioPath, fioCrudDTO);
	}
	
	public FioCrudDTO read(String fioPath, String name) throws IOException {
		
		FioCrudDTO fioCrudDTO = new FioCrudDTO();
		
		fioCrudDTO.setContent(fioCrudBasicRepository.read(fioPath, name));
		fioCrudDTO.setName(name);

		return fioCrudDTO;
	}
	
	public void update(String fioPath, String preName, FioCrudDTO fioCrudDTO) throws IOException {
		fioCrudBasicRepository.update(fioPath, preName, fioCrudDTO);
	}
	
	public void delete(String fioPath, String name) throws IOException {
		fioCrudBasicRepository.delete(fioPath, name);
	}
	
}
