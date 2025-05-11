package dlk.wti.spring.db.jdbc.legacy;

import java.util.List;

import org.springframework.stereotype.Service;

import dlk.wti.spring.db.crud.dto.DbCrudDTO;

@Service
public class DbJdbcLegacyService {

    private final DbJdbcLegacyRepository dbJdbcLegacyRepository;
    public DbJdbcLegacyService(DbJdbcLegacyRepository dbJdbcLegacyRepository) {this.dbJdbcLegacyRepository = dbJdbcLegacyRepository;}

    public List<DbCrudDTO> list() {
        return dbJdbcLegacyRepository.list();
    }
    
	public void create(DbCrudDTO dbCrudDTO) {
		dbJdbcLegacyRepository.create(dbCrudDTO);
	}
	
	public void updateHit(String idx) {
		dbJdbcLegacyRepository.updateHit(idx);
	}
	
	public DbCrudDTO read(String idx){
		return dbJdbcLegacyRepository.read(idx);
	}
	
	public void update(DbCrudDTO dbCrudDTO) {
		dbJdbcLegacyRepository.update(dbCrudDTO);
	}
	
	public void delete(String idx) {
		dbJdbcLegacyRepository.delete(idx);
	}
	
}
