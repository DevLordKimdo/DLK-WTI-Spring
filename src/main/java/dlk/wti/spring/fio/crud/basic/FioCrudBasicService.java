package dlk.wti.spring.fio.crud.basic;

import java.io.*;
import java.nio.file.*;
import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class FioCrudBasicService {
	
	public List<String> list(String directoryPath) throws IOException {
		
		Path path = Paths.get(directoryPath);
		List<String> list = new ArrayList<>();
		
		if (!Files.exists(path) || !Files.isDirectory(path)) {
			
        	System.out.println("유효하지 않은 디렉토리 입니다.");
        	
        	return null;
        	
        } else {
        	
    		try(DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
    			Iterator<Path> iterator = directoryStream.iterator();
    			
    			while(iterator.hasNext()) {
    				Path filePath = iterator.next();
    				
    	            // 일반 파일만 필터링
    	            if (Files.isRegularFile(filePath)) {
    	                // 파일 이름만 추출하여 문자열로 변환 후 결과 목록에 추가
    	                String fileName = filePath.getFileName().toString();
    	                list.add(fileName);
    	            }
    			}
    		}
        }
		
		return list;
	}

}
