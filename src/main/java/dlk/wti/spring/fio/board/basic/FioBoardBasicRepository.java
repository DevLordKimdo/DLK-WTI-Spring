package dlk.wti.spring.fio.board.basic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import dlk.wti.spring.fio.board.dto.FioBoardDTO;

@Repository
public class FioBoardBasicRepository {
	
    private final SqlSessionTemplate sql;
    public FioBoardBasicRepository(SqlSessionTemplate sql) {this.sql = sql;}
    
    public List<FioBoardDTO> list() {
    	return sql.selectList("FioBoard.list");
    }
    
    public String newGroupIdx() {
    	return sql.selectOne("FioBoard.newGroupIdx");
    }
    
    public void upload(FioBoardDTO fioBoardDTO) {
    	sql.insert("FioBoard.upload", fioBoardDTO);
    }

}
