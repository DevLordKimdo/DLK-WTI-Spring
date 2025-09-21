package dlk.wti.spring.uix.form.searchselectbox;

import java.util.List;

import org.springframework.stereotype.Service;

import dlk.wti.spring.uix.form.dto.UixFormDTO;

@Service
public class UixFormSearchselectboxService {

	private final UixFormSearchselectboxRepository uixFormSearchselectboxRepository;
	public UixFormSearchselectboxService(UixFormSearchselectboxRepository uixFormSearchselectboxRepository) {this.uixFormSearchselectboxRepository = uixFormSearchselectboxRepository;}
	
	public List<UixFormDTO> listUser(){
		return uixFormSearchselectboxRepository.listUser();
	}
}
