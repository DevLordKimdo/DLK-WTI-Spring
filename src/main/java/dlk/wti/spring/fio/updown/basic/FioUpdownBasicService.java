package dlk.wti.spring.fio.updown.basic;

import java.io.*;
import java.nio.file.*;
import java.util.*;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.core.io.Resource;
import org.springframework.core.io.FileSystemResource;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class FioUpdownBasicService {
	
	public void sampleDownload(HttpServletResponse response, String sampleFile) throws IOException {
		
        Path path = Paths.get(sampleFile);
        Resource resource = new FileSystemResource(path.toFile());

        String contentType = "application/octet-stream";
        String headerValue = "attachment; filename=\"" + resource.getFilename() + "\"";

        response.setContentType(contentType);
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, headerValue);
        response.setHeader(HttpHeaders.CACHE_CONTROL, "no-cache, no-store, must-revalidate");
        response.setHeader(HttpHeaders.PRAGMA, "no-cache");
        response.setHeader(HttpHeaders.EXPIRES, "0");

		FileCopyUtils.copy(resource.getInputStream(), response.getOutputStream());
		
	}
	
	public void singleUpload(MultipartFile file, String directory) throws IOException {
		
		if (!file.isEmpty()) {

            // 파일 이름 생성
            String fileName = file.getOriginalFilename();
            
            // 파일 저장 경로 생성
            Path uploadPath = Paths.get(directory);
            
            // 디렉토리가 존재하지 않으면 생성
            if (!Files.exists(uploadPath)) { Files.createDirectories(uploadPath); }
            
            // 파일 저장
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
	    }
	}
	
	public void multiUpload(List<MultipartFile> files, String directory) throws IOException {
		
		if (!files.isEmpty()) {
	            
            // 파일 저장 경로 생성
            Path uploadPath = Paths.get(directory);
            
            // 디렉토리가 존재하지 않으면 생성
            if (!Files.exists(uploadPath)) { Files.createDirectories(uploadPath); }
            
            // 각 파일을 저장
            for (MultipartFile file : files) {
                String fileName = file.getOriginalFilename();
                Path filePath = uploadPath.resolve(fileName);
                Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            }
	    }
		
	}
	
	public void deleteTarget(String directory, String deleteTarget) throws IOException {
		
        Path directoryPath = Paths.get(directory);
        Path filePath = directoryPath.resolve(deleteTarget);
        File file = filePath.toFile();

        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                System.out.println(deleteTarget + " 파일이 삭제되었습니다.");
            } else {
                System.out.println(deleteTarget + " 파일 삭제에 실패했습니다.");
            }
        } else {
            System.out.println(deleteTarget + " 파일이 존재하지 않습니다.");
        }
	}
	
	public void deleteAll(String directory) throws IOException {
		
        Path directoryPath = Paths.get(directory);

        // uploadPath 디렉토리에 있는 모든 파일 삭제
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directoryPath)) {
			for (Path path : directoryStream) {
			    Files.delete(path);
			}
		}
	}
}
