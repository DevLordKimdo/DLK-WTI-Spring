package dlk.wti.spring.uix.form.searchselectbox;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import dlk.wti.spring.uix.form.dto.UixFormDTO;

@Repository
public class UixFormSearchselectboxRepository {

	private final SqlSessionTemplate sql;
	public UixFormSearchselectboxRepository(SqlSessionTemplate sql) {this.sql = sql;}
	
	public List<UixFormDTO> listUser() {		
		return sql.selectList("UixForm.listUser");
	}
	
}
