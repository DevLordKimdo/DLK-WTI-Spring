package dlk.wti.spring.db.form.rowsubmit;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import dlk.wti.spring.db.crud.dto.DbCrudDTO;

@Repository
public class DbFormRowsubmitRepository {
	
	private final SqlSessionTemplate sql;
	public DbFormRowsubmitRepository(SqlSessionTemplate sql) {this.sql = sql;}
	
	public void create(List<DbCrudDTO> dbCrudDTO) {
		
		for(DbCrudDTO list : dbCrudDTO) {
			sql.insert("DbCrud.create", list);
		}
	}
}
