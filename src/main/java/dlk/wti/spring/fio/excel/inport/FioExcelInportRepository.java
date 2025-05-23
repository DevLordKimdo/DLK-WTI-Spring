package dlk.wti.spring.fio.excel.inport;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import dlk.wti.spring.db.crud.dto.DbCrudDTO;

@Repository
public class FioExcelInportRepository {
	
	private final SqlSessionTemplate sql;
	public FioExcelInportRepository(SqlSessionTemplate sql) {this.sql = sql;}
	
	public void create(List<DbCrudDTO> dbCrudDTO) {
		sql.insert("FioExcel.excelUpload", dbCrudDTO);
	}

}
