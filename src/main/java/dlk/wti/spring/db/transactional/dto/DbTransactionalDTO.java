package dlk.wti.spring.db.transactional.dto;

import dlk.wti.spring.db.crud.dto.DbCrudDTO;

public class DbTransactionalDTO extends DbCrudDTO {

	private String errorOption;
	private String transOption;
	
	public String getErrorOption() {
		return errorOption;
	}
	public void setErrorOption(String errorOption) {
		this.errorOption = errorOption;
	}
	public String getTransOption() {
		return transOption;
	}
	public void setTransOption(String transOption) {
		this.transOption = transOption;
	}
}
