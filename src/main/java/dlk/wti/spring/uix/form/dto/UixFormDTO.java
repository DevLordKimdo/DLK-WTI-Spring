package dlk.wti.spring.uix.form.dto;

import java.util.List;

import dlk.wti.spring.db.crud.dto.DbCrudDTO;

public class UixFormDTO extends DbCrudDTO {
	
	private List<String> checkIdx;

	public List<String> getCheckIdx() {
		return checkIdx;
	}

	public void setCheckIdx(List<String> checkIdx) {
		this.checkIdx = checkIdx;
	}
	
}