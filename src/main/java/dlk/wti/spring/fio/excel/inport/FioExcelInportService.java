package dlk.wti.spring.fio.excel.inport;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import dlk.wti.spring.db.crud.dto.DbCrudDTO;

@Service
public class FioExcelInportService {
	
	private final FioExcelInportRepository fioExcelInportRepository;
	FioExcelInportService(FioExcelInportRepository fioExcelInportRepository) {this.fioExcelInportRepository = fioExcelInportRepository;}

	// 엑셀 파일의 내용을 읽어 DTO로 집어넣는 예제. 중간중간 프린트 문을 통해 대략적인 흐름도를 확인할 수 있음.
	public void example(MultipartFile file) throws IOException {
		InputStream inputStream = file.getInputStream();
		Workbook workbook = WorkbookFactory.create(inputStream);
		
		//Sheet sheet = workbook.getSheetAt(0); // 첫 번째 시트를 가져오기
		Sheet sheet = workbook.getSheet("Sheet1"); // 시트 이름으로 가져오기
		
		   workbook.close();
		inputStream.close();
		
		// 각 셀의 내용을 출력
		for (Row row : sheet) {
			for (Cell cell : row) {
				if(cell.getCellType() == CellType.NUMERIC) {				// 셀의 값이 숫자일 경우
					System.out.print(cell.getNumericCellValue() + " ");		// 셀의 값을 숫자형으로 출력
				} else if(cell.getCellType() == CellType.STRING) {			// 셀의 값이 문자열일 경우
					System.out.print(cell.getStringCellValue() + " ");		// 셀의 값을 문자열로 출력
				} else {
					System.out.print(cell.toString() + " ");				// 셀의 값을 무조건 string 값으로 출력
				}
			}
			System.out.println("");
		}
		
		// 좌표값 출력
		for (Row row : sheet) {
			for (Cell cell : row) {
				System.out.print("(" + cell.getRowIndex() + "," + cell.getColumnIndex() + ")");
			}
			System.out.println("");
		}
		
		// DTO 배열에 집어넣기
        List<DbCrudDTO> dbCrudDTO = new ArrayList<>();
        
        // 칼럼을 매칭 안하고 순차적으로 집어넣기.
        // 장점 : 구현이 쉬움
        // 단점 : 엑셀 작성시 무조건 기본 틀에 맞춰서 작성해야하는 문제가 있음
        for (Row row : sheet) {
        	if(row.getRowNum() > 0) {	// 엑셀에서 첫번째 행을 생략
        		DbCrudDTO tempDTO = new DbCrudDTO();
                for (Cell cell : row) {
                	switch(cell.getColumnIndex()) {
                		case 0: tempDTO.setTitle(cell.toString());
                		case 1: tempDTO.setName (cell.toString());
                		case 2: tempDTO.setContent(cell.toString());
                	}
                }
                dbCrudDTO.add(tempDTO);
        	}
        }
        
        // DTO 순차적으로 출력 (확인용)
        for(DbCrudDTO TempDTO : dbCrudDTO) {
        	System.out.println(TempDTO.getTitle() + " " + TempDTO.getName() + " " + TempDTO.getContent());
        }        
	}
	
	// 위의 코드에 필요없는 부분(프린트문) 들을 모두 제거 후 DB에 저장하는 코드
	public void upload(MultipartFile file) throws IOException {
		InputStream inputStream = file.getInputStream();
		Workbook workbook = WorkbookFactory.create(inputStream);
		
		Sheet sheet = workbook.getSheet("Sheet1");
		
		   workbook.close();
		inputStream.close();
		
        List<DbCrudDTO> dbCrudDTO = new ArrayList<>();
        
        for (Row row : sheet) {
        	if(row.getRowNum() > 0) {
        		DbCrudDTO tempDTO = new DbCrudDTO();
                for (Cell cell : row) {
                	switch(cell.getColumnIndex()) {
                		case 0: tempDTO.setTitle(cell.toString());
                		case 1: tempDTO.setName (cell.toString());
                		case 2: tempDTO.setContent(cell.toString());
                	}
                }
                dbCrudDTO.add(tempDTO);
        	}
        }
        
        fioExcelInportRepository.create(dbCrudDTO);
        
	}
}