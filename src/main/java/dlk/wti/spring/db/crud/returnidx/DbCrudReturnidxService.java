package dlk.wti.spring.db.crud.returnidx;

import org.springframework.stereotype.Service;

import dlk.wti.spring.db.crud.dto.DbCrudDTO;

@Service
public class DbCrudReturnidxService {
	
	private final DbCrudReturnidxRepository dbCrudReturnidxRepository;
	public DbCrudReturnidxService(DbCrudReturnidxRepository dbCrudReturnidxRepository) {this.dbCrudReturnidxRepository = dbCrudReturnidxRepository;}
	
	public void create(DbCrudDTO dbCrudDTO) {
		dbCrudReturnidxRepository.create(dbCrudDTO);
	}
}