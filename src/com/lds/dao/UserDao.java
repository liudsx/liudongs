package com.lds.dao;

import java.util.List;

import com.lds.vo.UserInfo;

public interface UserDao {

	public void saveadd(UserInfo ui);

	public List<UserInfo> tolist();
	
	public UserInfo checkUserLogin(UserInfo ui);

}
