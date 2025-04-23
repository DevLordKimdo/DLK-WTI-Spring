package dlk.wti.spring.db.form.rowsubmit;

import java.util.*;

import org.springframework.stereotype.Service;

import dlk.wti.spring.db.crud.dto.DbCrudDTO;

@Service
public class DbFormRowsubmitService {
	
	private final DbFormRowsubmitRepository dbFormRowsubmitRepository;
	public DbFormRowsubmitService(DbFormRowsubmitRepository dbFormRowsubmitRepository) {this.dbFormRowsubmitRepository = dbFormRowsubmitRepository;}
	
	public void submit(List<String> title, List<String> name, List<String> content) {

		List<DbCrudDTO> DbCrudDTO = new ArrayList<>();
		
		for (int i = 0; i < title.size(); i++) {
			DbCrudDTO tempDTO = new DbCrudDTO();
			tempDTO.setTitle(title.get(i));
			tempDTO.setName(name.get(i));
			tempDTO.setContent(content.get(i));
			DbCrudDTO.add(tempDTO);
		}
		
		dbFormRowsubmitRepository.create(DbCrudDTO);
	}
}
