package usil.proyecto.alarmatempranoa.models;

import java.util.Date;

public class New {
	
	private Integer newId;
	private String content;
	private String author;
	private String link;
	private String source;
	private Date createdAt;
	private Date updatedAt;
	
	public New(Integer newId,String content,String author,String link,String source,Date createdAt,Date updatedAt){
		this.newId = newId;
		this.content = content;
		this.author = author;
		this.link = link;
		this.source = source; 
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	public Integer getNewId() {
		return newId;
	}
	public void setNews_id(Integer newId) {
		this.newId = newId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
}
