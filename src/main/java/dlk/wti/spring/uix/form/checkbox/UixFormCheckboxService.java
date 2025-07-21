package dlk.wti.spring.uix.form.checkbox;

import java.util.List;

import org.springframework.stereotype.Service;

import dlk.wti.spring.uix.form.dto.UixFormDTO;

@Service
public class UixFormCheckboxService {
	
    private final UixFormCheckboxRepository uixFormCheckboxRepository;
    public UixFormCheckboxService(UixFormCheckboxRepository uixFormCheckboxRepository) {this.uixFormCheckboxRepository = uixFormCheckboxRepository;}
    
	public List<UixFormDTO> list(){
		return uixFormCheckboxRepository.list();
	}
	
	public void copy(List<String> checkIdx) {
		uixFormCheckboxRepository.copy(checkIdx);
	}
	
	public void update(UixFormDTO uixFormDTO) {
		uixFormCheckboxRepository.update(uixFormDTO);
	}
	
	public void delete(List<String> checkIdx) {
		uixFormCheckboxRepository.delete(checkIdx);
	}
}
