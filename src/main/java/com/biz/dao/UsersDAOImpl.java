package com.biz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.biz.model.BizResponse;
import com.biz.model.Groups;
import com.biz.model.UserGroups;
import com.biz.model.Users;
import com.biz.util.CommonsUtil;

@Service
public class UsersDAOImpl implements UsersDAO {

	@Autowired
	CommonsUtil commonsUtil;
	
	@Value("${sql.count.user.group}")
	String sqlCountUserGroup;
	
	@Value("${sql.id.user}")
	String sqlUserID;
	
	@Value("${sql.id.groups}")
	String sqlGroupID;

	@Override
	public BizResponse addUser(Users users, String sql) {
		BizResponse bizResponse = new BizResponse();
        try (Connection conn = this.commonsUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, users.getUserName());
            pstmt.setString(2, users.getPassword());
            pstmt.setString(3, users.getEmail());
            pstmt.setString(4, users.getFirstName());
            pstmt.setString(5, users.getLastName());
            pstmt.setString(6, users.getMobile());
            pstmt.setString(7, users.getCreatedBy());
            System.out.println(pstmt.executeUpdate());
            bizResponse.setStatus("Sucess");
        } catch (SQLException e) {
            bizResponse.setStatus("Failed");
            bizResponse.setError(e.getMessage());
            System.out.println(e.getMessage());
        }
		return bizResponse;
	}


	@Override
	public BizResponse addGroup(Groups groups, String sql) {
		BizResponse bizResponse = new BizResponse();
        try (Connection conn = this.commonsUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, groups.getName());
            pstmt.setString(2, groups.getDescription());
            System.out.println(pstmt.executeUpdate());
            bizResponse.setStatus("Sucess");
        } catch (SQLException e) {
            bizResponse.setStatus("Failed");
            bizResponse.setError(e.getMessage());
            System.out.println(e.getMessage());
        }
		return bizResponse;
	}


	@Override
	public BizResponse mapUserGroup(UserGroups userGroups, String sql) {
		BizResponse bizResponse = new BizResponse();
		if(isUserExist(userGroups.getUserName(), userGroups.getGroupName()) > 0){
			int userId = getID(userGroups.getUserName(), sqlUserID);
			int groupId = getID(userGroups.getGroupName(), sqlGroupID);		
			try (Connection conn = this.commonsUtil.getConnection();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setInt(1, userId);
	            pstmt.setInt(2, groupId);
	            System.out.println(pstmt.executeUpdate());
	            bizResponse.setStatus("Sucess");
	        } catch (SQLException e) {
	            bizResponse.setStatus("Failed");
	            bizResponse.setError(e.getMessage());
	            System.out.println(e.getMessage());
	        }
		}else{
			bizResponse.setStatus("Failed");
			bizResponse.setError("User or Group does not exist.");
		}
		return bizResponse;	
        
	}
	
	private int isUserExist(String userName, String userGroup){
		String temp  = sqlCountUserGroup.replace("#userName#", userName);
		temp = temp.replace("#groupName#", userGroup);
		int count = 0;
		System.out.println("Count user group query: " + temp);
		try (Connection conn = this.commonsUtil.getConnection();
				Statement stmt3 = conn.createStatement();) {
			ResultSet rs3 = stmt3.executeQuery(temp);
			while (rs3.next())
				count = rs3.getInt("userGroupCount");
            System.out.println("Number of record found: " + count);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
		return count;
	}
	
	
	private int getID(String parameter, String sql){
		String tempSql = sql.replace("#parameter#", parameter);
		System.out.println("Query parameter is: " + parameter + " Query: " + tempSql);
		int id = 0;
		try (Connection conn = this.commonsUtil.getConnection();
				Statement stmt3 = conn.createStatement();) {
			ResultSet rs3 = stmt3.executeQuery(tempSql);
			while (rs3.next())
				id = rs3.getInt("id");
            System.out.println("Id is: " + id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
		return id;
	}
}
