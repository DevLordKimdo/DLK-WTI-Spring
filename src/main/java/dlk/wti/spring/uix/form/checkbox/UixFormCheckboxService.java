package dlk.wti.spring.uix.form.checkbox;

import java.util.List;

import org.springframework.stereotype.Service;

import dlk.wti.spring.db.crud.dto.DbCrudDTO;

@Service
public class UixFormCheckboxService {
	
    private final UixFormCheckboxRepository uixFormCheckboxRepository;
    public UixFormCheckboxService(UixFormCheckboxRepository uixFormCheckboxRepository) {this.uixFormCheckboxRepository = uixFormCheckboxRepository;}
    
	public List<DbCrudDTO> list(){
		return uixFormCheckboxRepository.list();
	}
	
	public void copy(List<String> checkIdx) {
		for(String idx : checkIdx) {
			DbCrudDTO dbCrudDTO = uixFormCheckboxRepository.read(idx);
			uixFormCheckboxRepository.create(dbCrudDTO);
		}
	}
	
	public void update(List<String> checkIdx, DbCrudDTO dbCrudDTO) {
		dbCrudDTO.setIdxList(checkIdx);
		uixFormCheckboxRepository.update(dbCrudDTO);
	}
	
	public void delete(List<String> checkIdx) {
		uixFormCheckboxRepository.delete(checkIdx);
	}
}
