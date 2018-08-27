package com.biz.dao;

import com.biz.model.BizResponse;
import com.biz.model.Groups;
import com.biz.model.UserGroups;
import com.biz.model.Users;

public interface UsersDAO {
	public BizResponse addUser(Users users, String sql);
	public BizResponse addGroup(Groups groups, String sql);
	public BizResponse mapUserGroup(UserGroups userGroups, String sql);

}
