package com.lds.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.lds.vo.UserInfo;
@Repository("dao")
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{

	@Override
	public void saveadd(UserInfo ui) {
		getSqlSession().insert("com.lds.mapper.UserMapper.saveadd",ui);
		
	}

	@Override
	public List<UserInfo> tolist() {
		return getSqlSession().selectList("com.lds.mapper.UserMapper.tolist");
	}

	@Override
	public UserInfo checkUserLogin(UserInfo ui) {
		return getSqlSession().selectOne("com.lds.mapper.UserMapper.checkuser",ui);
	}

}
