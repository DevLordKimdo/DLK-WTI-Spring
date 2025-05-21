package dlk.wti.spring.db.transactional.basic;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import dlk.wti.spring.db.crud.dto.DbCrudDTO;

@Repository
public class DbTransactionalBasicRepository {
	
	private final SqlSessionTemplate sql;
	public DbTransactionalBasicRepository(SqlSessionTemplate sql) {this.sql = sql;}
	
	public void create(DbCrudDTO dbCrudDTO) {
		sql.insert("DbCrud.create", dbCrudDTO);
	}

}
