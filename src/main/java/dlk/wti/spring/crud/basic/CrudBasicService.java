package dlk.wti.spring.crud.basic;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CrudBasicService {
	
    private final CrudBasicRepository crudBasicRepository;
    public CrudBasicService(CrudBasicRepository crudBasicRepository) {this.crudBasicRepository = crudBasicRepository;}
    
	public List<CrudBasicDTO> list(){
		return crudBasicRepository.list();
	}
	
	public void create(CrudBasicDTO crudBasicDTO) {
		crudBasicRepository.create(crudBasicDTO);
	}
	
	public void updateHit(String idx) {
		crudBasicRepository.updateHit(idx);
	}
	
	public CrudBasicDTO read(String idx){
		return crudBasicRepository.read(idx);
	}
	
	public void update(CrudBasicDTO crudBasicDTO) {
		crudBasicRepository.update(crudBasicDTO);
	}
	
	public void delete(String idx) {
		crudBasicRepository.delete(idx);
	}

}
