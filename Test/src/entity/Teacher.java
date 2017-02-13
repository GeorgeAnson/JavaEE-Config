package entity;

import java.sql.Date;

public class Teacher {

	 private String tid;
	 private String tname;
	 private String gender;
	 private Date birthday;
	 private String address;
	 
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", tname=" + tname + ", gender=" + gender
				+ ", birthday=" + birthday + ", address=" + address + "]";
	}
	
}
