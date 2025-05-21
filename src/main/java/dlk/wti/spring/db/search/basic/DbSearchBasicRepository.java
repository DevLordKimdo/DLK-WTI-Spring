package dlk.wti.spring.db.search.basic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import dlk.wti.spring.db.search.dto.DbSearchDTO;

@Repository
public class DbSearchBasicRepository {
	
	private final SqlSessionTemplate sql;
	public DbSearchBasicRepository(SqlSessionTemplate sql) {this.sql = sql;}

	public List<DbSearchDTO> list(DbSearchDTO dbSearchDTO) {
		return sql.selectList("DbSearch.list", dbSearchDTO);
	}
	
}