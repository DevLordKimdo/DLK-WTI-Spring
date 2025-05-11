package dlk.wti.spring.util;

public class UtilPagination {
	
	// 현재 페이지 번호
	private int currentPageIndex;

	// 한 페이지당 출력할 글의 개수 (설정)
	private int postsPerPage;

	// 전체 게시글 개수
	private int totalPosts;

	// 가장 마지막 페이지
	private int lastPageIndex;

	// 페이지 묶음의 시작번호
	private int startPageIndex;

	// 페이지 묶음의 끝번호
	private int endPageIndex;

	// 다음 페이지 묶음으로 가기
	private boolean hasPrevPage;

	// 이전 페이지 묶음으로 가기
	private boolean hasNextPage;

	public UtilPagination(int currentPageIndex, int postsPerPage, int totalPosts) {
		this.currentPageIndex = currentPageIndex;
		this.postsPerPage = postsPerPage;
		this.totalPosts = totalPosts;
		this.lastPageIndex = LastPageIndex(postsPerPage, totalPosts);
		this.endPageIndex = EndPageIndex(currentPageIndex);
		this.startPageIndex = StartPageIndex(this.endPageIndex);
		this.hasPrevPage = HasPrevPage(this.startPageIndex);
		this.hasNextPage = HasNextPage(this.endPageIndex, totalPosts, postsPerPage);
		
		if(this.lastPageIndex < this.endPageIndex) {this.endPageIndex = this.lastPageIndex;}
	}

	private int LastPageIndex(int postsPerPage, int totalPosts) {
		return (int) Math.ceil((double) totalPosts / postsPerPage);
	}

	private int EndPageIndex(int currentPageIndex) {
		return (int) (Math.ceil(currentPageIndex / 10.0)) * 10;
	}

	private int StartPageIndex(int endPageIndex) {
		return endPageIndex - 9;
	}

	private boolean HasPrevPage(int startPageIndex) {
		return startPageIndex > 1;
	}

	private boolean HasNextPage(int endPageIndex, int totalPosts, int postsPerPage) {
		return endPageIndex < lastPageIndex;
	}

	public int getCurrentPageIndex() {
		return currentPageIndex;
	}

	public int getPostsPerPage() {
		return postsPerPage;
	}

	public int getTotalPosts() {
		return totalPosts;
	}

	public int getLastPageIndex() {
		return lastPageIndex;
	}

	public int getStartPageIndex() {
		return startPageIndex;
	}

	public int getEndPageIndex() {
		return endPageIndex;
	}

	public boolean isHasPrevPage() {
		return hasPrevPage;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}
}
