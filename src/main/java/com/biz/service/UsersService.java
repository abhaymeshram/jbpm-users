package com.biz.service;

import java.util.List;

import com.biz.model.BizResponse;
import com.biz.model.Groups;
import com.biz.model.UserGroups;
import com.biz.model.Users;

public interface UsersService {
	public BizResponse addUser(Users user) throws Exception;
	public BizResponse addGroup(Groups groups) throws Exception;
	public List<BizResponse> mapUserGroup(List<UserGroups> userGroups) throws Exception;
}
