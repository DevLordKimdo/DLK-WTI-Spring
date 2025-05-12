package dlk.wti.spring.uix.form.dto;

import java.util.List;

import dlk.wti.spring.db.crud.dto.DbCrudDTO;

public class UixFormDTO extends DbCrudDTO {
	
	private List<String> idxList;

	public List<String> getIdxList() {
		return idxList;
	}
	public void setIdxList(List<String> idxList) {
		this.idxList = idxList;
	}

}