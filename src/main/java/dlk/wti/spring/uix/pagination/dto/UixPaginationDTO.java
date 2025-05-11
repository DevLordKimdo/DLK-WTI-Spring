package dlk.wti.spring.uix.pagination.dto;

import dlk.wti.spring.db.crud.dto.DbCrudDTO;

public class UixPaginationDTO extends DbCrudDTO {
	
	private int postsPerPage;
	private int pageStart;
	
	public int getPostsPerPage() {
		return postsPerPage;
	}
	public void setPostsPerPage(int postsPerPage) {
		this.postsPerPage = postsPerPage;
	}
	public int getPageStart() {
		return pageStart;
	}
	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}

}
