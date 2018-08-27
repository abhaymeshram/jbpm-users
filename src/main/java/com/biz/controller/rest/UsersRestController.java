package com.biz.controller.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biz.model.BizResponse;
import com.biz.model.Groups;
import com.biz.model.Sample;
import com.biz.model.UserGroups;
import com.biz.model.Users;
import com.biz.service.UsersServiceImpl;

@RestController
public class UsersRestController {
	private static final Logger logger = LoggerFactory.getLogger(UsersRestController.class);

	@Autowired(required=true)
	private UsersServiceImpl personServiceImpl;
	
	@RequestMapping(value = "/user/add", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
	public BizResponse addUser(@RequestBody Users users) throws Exception {
		System.out.println(users);
		logger.info("Input data Request for user is: "+users);
		return personServiceImpl.addUser(users);
	}
	
	@RequestMapping(value = "/group/add", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
	public BizResponse addGroup(@RequestBody Groups groups) throws Exception {
		logger.info("Input data Request for group is: "+groups);
		return personServiceImpl.addGroup(groups);
	}
	
	@RequestMapping(value = "/user/group/map", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
	public List<BizResponse> mapUserGroup(@RequestBody List<UserGroups> userGroups) throws Exception {
		logger.info("Input data Request for Map user is: "+ userGroups);
		return personServiceImpl.mapUserGroup(userGroups);
	}
	
	@RequestMapping(value = "/user/temp", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
	public Sample sample(@RequestBody Sample sample) throws Exception {
		sample.setLastName("I am setter.");
		logger.info("Input data Request for Map user is: "+ sample);
		return sample;
	}

}
