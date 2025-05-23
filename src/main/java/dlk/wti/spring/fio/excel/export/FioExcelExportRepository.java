package dlk.wti.spring.fio.excel.export;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import dlk.wti.spring.db.crud.dto.DbCrudDTO;

@Repository
public class FioExcelExportRepository {
	
	private final SqlSessionTemplate sql;
	public FioExcelExportRepository(SqlSessionTemplate sql) {this.sql = sql;}

	public List<DbCrudDTO> list() {
		return sql.selectList("DbCrud.list");
	}

}
