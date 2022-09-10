package com.ram.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student{
	@Id
	private Integer stdId;
	@Column(name="sname")
	private String stdName;
	@Column(name="sclass")
	private String stdClass;
	@Column(name="Marks")
	private Integer Marks;
	
	//PDC+PSM+PGM+PPC+toString()

	
	public Student() {
		super();
	}
	public Integer getStdId() {
		return stdId;
	}
	public void setStdId(Integer stdId) {
		this.stdId = stdId;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getStdClass() {
		return stdClass;
	}
	public void setStdClass(String stdClass) {
		this.stdClass = stdClass;
	}
	public Integer getMarks() {
		return Marks;
	}
	public void setMarks(Integer Marks) {
		this.Marks = Marks;
	}
	@Override
	public String toString() {
		return "Student [stdId=" + stdId + ", stdName=" + stdName + ", stdClass=" + stdClass + ", Marks=" + Marks + "]";
	}
		
    
}
