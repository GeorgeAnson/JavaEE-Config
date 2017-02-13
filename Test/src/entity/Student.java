package entity;

import java.util.Date;

 
public class Student {
	private  String sid;
	private String sname;
	private String gender;
	private Date birthday;
	private String address;
	private String aaa;


	public Student() {
		 
	}
	
	public Student(String sid,String sname,String gender,Date birthday,String address,String aaa){
		this.sid=sid;
		this.sname=sname;
		this.gender=gender;
		this.birthday=birthday;
		this.address=address;
		this.aaa=aaa;
		
	}

	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSid(){
		return sid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
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

	public String getAaa() {
		return aaa;
	}

	public void setAaa(String aaa) {
		this.aaa = aaa;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", gender=" + gender + ", birthday=" + birthday
				+ ", address=" + address + ", aaa=" + aaa + "]";
	}
 
}
