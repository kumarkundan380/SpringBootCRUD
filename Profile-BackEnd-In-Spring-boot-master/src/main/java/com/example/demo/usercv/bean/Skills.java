package com.example.demo.usercv.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Skills")
public class Skills {
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "programing")
	private String programing;
	@Column(name = "webTech")
	private String webTech;
	@Column(name = "dbs")
	private String dbs;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrograming() {
		return programing;
	}

	public void setPrograming(String programing) {
		this.programing = programing;
	}

	public String getWebTech() {
		return webTech;
	}

	public void setWebTech(String webTech) {
		this.webTech = webTech;
	}

	public String getDbs() {
		return dbs;
	}

	public void setDbs(String dbs) {
		this.dbs = dbs;
	}
}
