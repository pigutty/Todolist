package com.pigutty.springboot.Todolist;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TodoData")
public class TodoData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long id;
	
	@Column(nullable = true)
	public String title;
	
	@Column(nullable = true)
	public String text;
	
	@Column(nullable = true)
	public Integer status_id;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id=id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title=title;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text=text;
	}
	
	public Integer getStatus() {
		return status_id;
	}
	
	public void setStatus(Integer status_id) {
		this.status_id=status_id;
	}
	
}
