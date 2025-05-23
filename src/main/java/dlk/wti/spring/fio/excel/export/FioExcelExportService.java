package dlk.wti.spring.fio.excel.export;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import dlk.wti.spring.db.crud.dto.DbCrudDTO;
import dlk.wti.spring.util.UtilExportExcel;

@Service
public class FioExcelExportService {
	
	private final FioExcelExportRepository fioExcelExportRepository;
	FioExcelExportService(FioExcelExportRepository fioExcelExportRepository) {this.fioExcelExportRepository = fioExcelExportRepository;}
	
    public byte[] downExcel() throws IOException {
    	List<DbCrudDTO> list = fioExcelExportRepository.list(); //DB로 데이터 가져오기

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Data");
        
        // 헤더 생성
        Row headerRow = sheet.createRow(0);
        String[] columns = {"idx", "title", "content","name", "datetime", "hit"}; // DbCrudDTO의 필드에 맞게 수정
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
        }
        // 데이터 채우기
        int rowNum = 1;
        for (DbCrudDTO dto : list) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(dto.getIdx());
            row.createCell(1).setCellValue(dto.getTitle());
            row.createCell(2).setCellValue(dto.getContent());
            row.createCell(3).setCellValue(dto.getName());
            row.createCell(4).setCellValue(dto.getDatetime());
            row.createCell(5).setCellValue(dto.getHit());
        }
        // 엑셀 파일을 바이트 배열로 변환
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();

        return outputStream.toByteArray();
    }
    
    // 향상된 버전. Util 쪽으로 따로 모듈화를 진행하여 작업.
    // 위의 하드코딩을 하는 방식과 달리 어떤 DB 자료를 가져와도 출력되게끔 구조를 설계.
    // DTO에 선언된 변수값들을 자동으로 넣어줌.
    public byte[] downExcelEnhance() throws IOException {
        List<DbCrudDTO> list = fioExcelExportRepository.list();
        
        UtilExportExcel utilExportExcel = new UtilExportExcel();

        return utilExportExcel.exportToExcel(list, "Data");
    }

}
