package dlk.wti.spring.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UtilExportExcel {
	public <T> byte[] exportToExcel(List<T> data, String sheetName) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet(sheetName);

        if (data.isEmpty()) {
            System.out.println("Data list is empty");
        }

        Class<?> clazz = data.get(0).getClass();
        Field[] fields = clazz.getDeclaredFields();

        // 헤더 생성
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < fields.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(fields[i].getName());
        }

        // 데이터 채우기
        int rowNum = 1;
        for (T item : data) {
            Row row = sheet.createRow(rowNum++);
            for (int i = 0; i < fields.length; i++) {
                Cell cell = row.createCell(i);
                fields[i].setAccessible(true);
                try {
                    Object value = fields[i].get(item);
                    if (value != null) {
                        cell.setCellValue(value.toString());
                    }
                } catch (IllegalAccessException e) {
                    cell.setCellValue("N/A");
                }
            }
        }

        // 엑셀 파일을 바이트 배열로 변환
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();

        return outputStream.toByteArray();
    }
}