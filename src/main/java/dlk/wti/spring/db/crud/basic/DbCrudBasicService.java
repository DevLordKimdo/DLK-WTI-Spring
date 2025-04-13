package dlk.wti.spring.db.crud.basic;

import java.util.List;

import org.springframework.stereotype.Service;

import dlk.wti.spring.db.crud.dto.DbCrudDTO;

@Service
public class DbCrudBasicService {
	
	private final DbCrudBasicRepository dbCrudBasicRepository;
	public DbCrudBasicService(DbCrudBasicRepository dbCrudBasicRepository) {this.dbCrudBasicRepository = dbCrudBasicRepository;}
	
	public List<DbCrudDTO> list(){
		return dbCrudBasicRepository.list();
	}
	
	public void create(DbCrudDTO dbCrudDTO) {
		dbCrudBasicRepository.create(dbCrudDTO);
	}
	
	public void updateHit(String idx) {
		dbCrudBasicRepository.updateHit(idx);
	}
	
	public DbCrudDTO read(String idx){
		return dbCrudBasicRepository.read(idx);
	}
	
	public void update(DbCrudDTO dbCrudDTO) {
		dbCrudBasicRepository.update(dbCrudDTO);
	}
	
	public void delete(String idx) {
		dbCrudBasicRepository.delete(idx);
	}

}
