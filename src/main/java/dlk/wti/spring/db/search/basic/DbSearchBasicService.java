package dlk.wti.spring.db.search.basic;

import java.util.List;

import org.springframework.stereotype.Service;

import dlk.wti.spring.db.search.dto.DbSearchDTO;

@Service
public class DbSearchBasicService {
	
	private final DbSearchBasicRepository dbSearchBasicRepository;
	DbSearchBasicService(DbSearchBasicRepository dbSearchBasicRepository) {this.dbSearchBasicRepository = dbSearchBasicRepository;}
	
	public List<DbSearchDTO> list(DbSearchDTO dbSearchDTO){
		return dbSearchBasicRepository.list(dbSearchDTO);
	}
	
}