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
	public String name;
	
	@Column(nullable = true)
	public String text;
	
	@Column(nullable = true)
	public Integer statusid;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id=id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text=text;
	}
	
	public Integer getstatusid() {
		return statusid;
	}
	
	public void setstatusid(Integer statusid) {
		this.statusid=statusid;
	}
	
}
