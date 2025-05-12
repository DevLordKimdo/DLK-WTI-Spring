package dlk.wti.spring.uix.form.checkbox;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import dlk.wti.spring.uix.form.dto.UixFormDTO;

@Repository
public class UixFormCheckboxRepository {
	
	private final SqlSessionTemplate sql;
	public UixFormCheckboxRepository(SqlSessionTemplate sql) {this.sql = sql;}

	public List<UixFormDTO> list() {
		return sql.selectList("DbCrud.list");
	}
    
    public void copy(List<String> checkIdx) {
    	sql.insert("UixForm.createCopy", checkIdx);
    }
    
    public void update(UixFormDTO uixFormDTO) {
    	sql.update("UixForm.updateMulti", uixFormDTO);
    }
    
    public void delete(List<String> checkIdx) {
    	sql.delete("UixForm.deleteMulti", checkIdx);
    }
}