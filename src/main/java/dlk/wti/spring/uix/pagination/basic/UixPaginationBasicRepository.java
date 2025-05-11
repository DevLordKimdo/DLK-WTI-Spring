package dlk.wti.spring.uix.pagination.basic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import dlk.wti.spring.uix.pagination.dto.UixPaginationDTO;

@Repository
public class UixPaginationBasicRepository {
	
    private final SqlSessionTemplate sql;
    public UixPaginationBasicRepository(SqlSessionTemplate sql) {this.sql = sql;}
    
    public List<UixPaginationDTO> list(UixPaginationDTO uixPaginationDTO) {
    	return sql.selectList("UixPagination.list", uixPaginationDTO);
    }
    
    public int count() {
    	return sql.selectOne("UixPagination.count");
    }

}
