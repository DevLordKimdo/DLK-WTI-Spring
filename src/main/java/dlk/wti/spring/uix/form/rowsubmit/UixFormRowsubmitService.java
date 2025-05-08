package dlk.wti.spring.uix.form.rowsubmit;

import java.util.*;

import org.springframework.stereotype.Service;

import dlk.wti.spring.db.crud.dto.DbCrudDTO;

@Service
public class UixFormRowsubmitService {
	
	public List<DbCrudDTO> submit(List<String> title, List<String> name, List<String> content) {
		
		List<DbCrudDTO> DbCrudDTO = new ArrayList<>();
		
		for (int i = 0; i < title.size(); i++) {
			DbCrudDTO tempDTO = new DbCrudDTO();
			tempDTO.setTitle(title.get(i));
			tempDTO.setName(name.get(i));
			tempDTO.setContent(content.get(i));
			DbCrudDTO.add(tempDTO);
		}
		
		return DbCrudDTO;
	}

}
