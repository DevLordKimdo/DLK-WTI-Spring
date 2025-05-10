package dlk.wti.spring.db.crud.dto;

import java.util.List;

public class DbCrudDTO {
	
	private String idx;
	private String title;
	private String content;
	private String name;
	private String datetime;
	private String hit;
	private List<String> idxList;
	
	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getHit() {
		return hit;
	}
	public void setHit(String hit) {
		this.hit = hit;
	}
	public List<String> getIdxList() {
		return idxList;
	}
	public void setIdxList(List<String> idxList) {
		this.idxList = idxList;
	}
	
}
