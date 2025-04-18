package dlk.wti.spring.fio.crud.basic;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

import org.springframework.stereotype.Repository;

import dlk.wti.spring.fio.crud.dto.FioCrudDTO;

@Repository
public class FioCrudBasicRepository {
	
	public List<Path> list(String fioPath) throws IOException {
		
		Path path = Paths.get(fioPath);
		List<Path> list = new ArrayList<>();
		
		if (!Files.exists(path) && !Files.isDirectory(path)) {
        	System.out.println("유효하지 않은 디렉토리 입니다.");
        	return null;
        } else {
    		try(DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
    			for (Path file : directoryStream) {
    				list.add(file);
    			}
    		}
    		return list;
        }
	}
	
	public void create(String fioPath, FioCrudDTO fioCrudDTO) throws IOException {
		
		Path path = Paths.get(fioPath);
		Path filePath = path.resolve(fioCrudDTO.getName());
		
		if (!Files.exists(path)) {
			// 지정한 경로에 폴더가 없으면 폴더 생성
		    Files.createDirectories(path);
		} else if (!Files.isDirectory(path)) {
		    throw new IOException("경로가 디렉토리가 아닙니다: " + fioPath);
		}
				
		// 방법1 파일 이름 중복 확인 후 작동 중지. 파일 덮어 씌우기면 필요X
		if (Files.exists(filePath)) { throw new IOException("이미 해당 파일이 존재합니다."); }
		
        Files.write(
			filePath,
			fioCrudDTO.getContent().getBytes(StandardCharsets.UTF_8),
			StandardOpenOption.CREATE_NEW	// 동일한 이름의 파일이 있으면 작동 중지되고 Error 를 반환
        );
        
		// 방법2 중복 파일이 있으면 덮어 씌우기. 이 코드를 사용할 시 위의 중복검사 위의 if문 제거 필요.
//      Files.write(
//			filePath,
//			fioCrudDTO.getContent().getBytes(StandardCharsets.UTF_8),
//			StandardOpenOption.CREATE, 				// 동일한 이름의 파일이 있으면 덮어 씌우기
//			StandardOpenOption.TRUNCATE_EXISTING	// 동일한 이름의 파일이 있으면 덮어 씌우기
//      );

	}
	
	public String read(String fioPath, String name) throws IOException {
		
		Path path = Paths.get(fioPath);
		Path filePath = path.resolve(name);
		
		// 내부 파일 읽기.
		String content = Files.readString(filePath);
		
		return content;
	}
	
	public void update(String fioPath, String preName, FioCrudDTO fioCrudDTO) throws IOException {
		
		Path path = Paths.get(fioPath);
		Path filePath = path.resolve(preName);
		
		String content = fioCrudDTO.getContent();
		String newName = fioCrudDTO.getName();
		Path newFilePath = path.resolve(newName);
		
		// 파일 쓰기
		Files.write(
				filePath,
				content.getBytes(StandardCharsets.UTF_8)
		);
		
		// 파일 이동(이름 변경) 로직. 
        if (!preName.equals(newName)) {
        	if (Files.exists(newFilePath)) { throw new IOException("이미 해당 파일이 존재합니다."); }
            Files.move(filePath, newFilePath, StandardCopyOption.REPLACE_EXISTING);
        }

	}
	
	public void delete(String fioPath, String name) throws IOException {
		
		Path path = Paths.get(fioPath);
		Path filePath = path.resolve(name);
		
		// 파일 삭제
		Files.delete(filePath);
		
	}
}
