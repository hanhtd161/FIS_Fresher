package fis.topic01.pratice01;

import java.util.Date;

public class Student implements Comparable<Student>{
	private int code;
	private String name;
	private Date birthDate;
	
	public Student() {
	}
	
	public Student(int code, String name, Date birthDate) {
		this.code = code;
		this.name = name;
		this.birthDate = birthDate;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public int compareTo(Student o) {
		if(this.getCode() > o.getCode()) {
			return 1;
		}
		if(this.getCode() < o.getCode()) {
			return -1;
		}
		return 0;
	}
	
	@Override
	public String toString() {
		return code + "\t" + name + "\t" + birthDate;
	}
	
	
	
	
	
}
