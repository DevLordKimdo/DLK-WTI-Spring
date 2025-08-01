package dlk.wti.spring.db.form.rowsubmit;

import java.util.*;

import org.springframework.stereotype.Service;

import dlk.wti.spring.db.crud.dto.DbCrudDTO;

@Service
public class DbFormRowsubmitService {
	
	private final DbFormRowsubmitRepository dbFormRowsubmitRepository;
	public DbFormRowsubmitService(DbFormRowsubmitRepository dbFormRowsubmitRepository) {this.dbFormRowsubmitRepository = dbFormRowsubmitRepository;}
	
	public void submit(List<DbCrudDTO> DbCrudDTO) {		
		dbFormRowsubmitRepository.create(DbCrudDTO);
	}
}
