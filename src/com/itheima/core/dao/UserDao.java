package com.itheima.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.itheima.core.po.User;

public interface UserDao {
	/* ͨ���˺ź������ѯ�û� */
	public User selectUser(@Param("userid") String userid,
						@Param("password") String password);
	public int insertUser(User user);
	public int updateUser(User user);
	public List<User> selectUserList(User user);
	public Integer selectUserListCount(User user);
}
