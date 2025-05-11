package dlk.wti.spring.uix.pagination.basic;

import java.util.List;

import org.springframework.stereotype.Service;

import dlk.wti.spring.uix.pagination.dto.UixPaginationDTO;

@Service
public class UixPaginationBasicService {
	
    private final UixPaginationBasicRepository uixPaginationBasicRepository;
    public UixPaginationBasicService(UixPaginationBasicRepository uixPaginationBasicRepository) {this.uixPaginationBasicRepository = uixPaginationBasicRepository;}
    
	public List<UixPaginationDTO> list(UixPaginationDTO uixPaginationDTO){
		return uixPaginationBasicRepository.list(uixPaginationDTO);
	}
	
	public int count() {
		return uixPaginationBasicRepository.count();
	}
}
