package dlk.wti.spring.db.crud.returnidx;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import dlk.wti.spring.db.crud.dto.DbCrudDTO;

@Repository
public class DbCrudReturnidxRepository {
	
	private final SqlSessionTemplate sql;
	public DbCrudReturnidxRepository(SqlSessionTemplate sql) {this.sql = sql;}
	
	public void create(DbCrudDTO dbCrudDTO) {
		sql.insert("DbCrud.createReturnIdx", dbCrudDTO);
	}
}