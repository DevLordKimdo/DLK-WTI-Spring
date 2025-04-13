package dlk.wti.spring.db.crud.basic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import dlk.wti.spring.db.crud.dto.DbCrudDTO;

@Repository
public class DbCrudBasicRepository {
	
	private final SqlSessionTemplate sql;
	public DbCrudBasicRepository(SqlSessionTemplate sql) {this.sql = sql;}
	

	public List<DbCrudDTO> list() {
		return sql.selectList("DbCrud.list");
	}
	
	public void create(DbCrudDTO dbCrudDTO) {
		sql.insert("DbCrud.create", dbCrudDTO);
	}
	
    public void updateHit(String idx) {
    	sql.update("DbCrud.updateHit", idx);
    }
    
    public DbCrudDTO read(String idx) {
        return sql.selectOne("DbCrud.read", idx);
    }
    
    public void update(DbCrudDTO dbCrudDTO) {
    	sql.update("DbCrud.update", dbCrudDTO);
    }
    
    public void delete(String idx) {
    	sql.delete("DbCrud.delete", idx);
    }
	
}
