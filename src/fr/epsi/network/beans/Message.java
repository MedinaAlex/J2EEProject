package fr.epsi.network.beans;

import java.sql.Timestamp;

public class Message {

	private Long id;
	private String title;
	private String content;
	private User author;
	private Timestamp creationDate;
	private Timestamp updateDate;
	private int status;
	
	public Message(){
		super();
	}
	
	public Message(Long id, String title, String content, User author, Timestamp creationDate, Timestamp updateDate,
			int status) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.author = author;
		this.creationDate = creationDate;
		this.updateDate = updateDate;
		this.status = status;
	}
	
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public Timestamp getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}
	public Timestamp getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}


}
