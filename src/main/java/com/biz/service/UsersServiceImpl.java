package com.biz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.biz.dao.UsersDAOImpl;
import com.biz.model.BizResponse;
import com.biz.model.Groups;
import com.biz.model.UserGroups;
import com.biz.model.Users;

@Service
public class UsersServiceImpl implements UsersService {
	
	@Autowired(required=true)
	private UsersDAOImpl personDAOImpl;
	
	@Value("${sql.addUser}")
	String sqlAddUser;
	
	@Value("${sql.addGroup}")
	String sqlAddGroup;
	
	@Value("${sql.map.user.group}")
	String sqlMapUserGroup;
	

	@Override
	public BizResponse addUser(Users user) throws Exception {
		System.out.println(user);
		System.out.println(sqlAddUser);
		return this.personDAOImpl.addUser(user, sqlAddUser);
	}

	@Override
	public BizResponse addGroup(Groups groups) throws Exception {
		System.out.println(groups);
		System.out.println(sqlAddUser);
		return this.personDAOImpl.addGroup(groups, sqlAddGroup);
	}

	@Override
	public List<BizResponse> mapUserGroup(List<UserGroups> userGroups) throws Exception {
		List<BizResponse> bizResponses = new ArrayList<>();
		for(UserGroups userGroup : userGroups){
			bizResponses.add(this.personDAOImpl.mapUserGroup(userGroup, sqlMapUserGroup));
		}
		return bizResponses;
	}

}
