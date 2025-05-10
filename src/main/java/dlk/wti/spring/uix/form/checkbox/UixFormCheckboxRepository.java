package dlk.wti.spring.uix.form.checkbox;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import dlk.wti.spring.db.crud.dto.DbCrudDTO;

@Repository
public class UixFormCheckboxRepository {
	
	private final SqlSessionTemplate sql;
	public UixFormCheckboxRepository(SqlSessionTemplate sql) {this.sql = sql;}

	public List<DbCrudDTO> list() {
		return sql.selectList("DbCrud.list");
	}
	
    public DbCrudDTO read(String idx) {
        return sql.selectOne("DbCrud.read", idx);
    }
    
    public void create(DbCrudDTO dbCrudDTO) {
    	sql.insert("DbCrud.create", dbCrudDTO);
    }
    
    public void update(DbCrudDTO dbCrudDTO) {
    	sql.update("DbCrud.updateMulti", dbCrudDTO);
    }
    
    public void delete(List<String> checkIdx) {
    	sql.delete("DbCrud.deleteMulti", checkIdx);
    }
}