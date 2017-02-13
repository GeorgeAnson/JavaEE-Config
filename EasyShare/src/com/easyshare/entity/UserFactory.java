package com.easyshare.entity;

public class UserFactory implements IUser {

	@Override
	public Object getUser(CommonUserInfo commonUserInfo) {
		
		Object object=null;
		if(commonUserInfo.getUserType()==1)
		{
			object = new Teacher(commonUserInfo);
		}
		else if(commonUserInfo.getUserType()==2)
		{
			object=new Student(commonUserInfo);
		}
		return object;
	}

}
