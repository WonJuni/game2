package com.game.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;

import com.game.common.DBCon;
import com.game.dao.UserInfoDAO;

public class UserInfoDAOImpl implements UserInfoDAO{

	@Override
	public List<Map<String, String>> selectUserInfoList(Map<String, String> userInfo) {
		String sql = "SELECT * FROM USER_INFO";
		List<Map<String, String>> userInfoList = new ArrayList();
		try(Connection connection = DBCon.getCon()){
			try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
				try(ResultSet resultSet = preparedStatement.executeQuery()){
					while (resultSet.next()) {
						Map<String, String> userInfoMap = new HashMap();
						userInfoMap.put("uiNum", resultSet.getString("UI_NUM"));
						userInfoMap.put("uiName", resultSet.getString("UI_NAME"));
						userInfoMap.put("uiPwd", resultSet.getString("UI_PWD"));
						userInfoMap.put("uiImgPath", resultSet.getString("UI_IMG_PATH"));
						userInfoMap.put("uiDesc", resultSet.getString("UI_DESC"));
						userInfoMap.put("uiBirth", resultSet.getString("UI_BIRTH"));
						userInfoMap.put("uiCredat", resultSet.getString("CREDAT"));
						userInfoMap.put("uiCretim", resultSet.getString("CRETIM"));
						userInfoMap.put("uiLmodat", resultSet.getString("LMODAT"));
						userInfoMap.put("uiLmotim", resultSet.getString("LMOTIM"));
						userInfoMap.put("uiActive", resultSet.getString("ACTIVE"));
						userInfoList.add(userInfoMap);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userInfoList;
	}

	@Override
	public Map<String, String> selectUserInfo(String uiNum) {
		String sql = "SELECT * FROM user_info WHERE UI_NUM = ?";
		try(Connection connection = DBCon.getCon()){
			try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
				preparedStatement.setString(1, uiNum);
				try(ResultSet resultSet = preparedStatement.executeQuery()){
					if(resultSet.next()) {
						Map<String, String> userInfoMap = new HashMap();
						userInfoMap.put("uiNum", resultSet.getString("UI_NUM"));
						userInfoMap.put("uiName", resultSet.getString("UI_NAME"));
						userInfoMap.put("uiPwd", resultSet.getString("UI_PWD"));
						userInfoMap.put("uiImgPath", resultSet.getString("UI_IMG_PATH"));
						userInfoMap.put("uiDesc", resultSet.getString("UI_DESC"));
						userInfoMap.put("uiBirth", resultSet.getString("UI_BIRTH"));
						userInfoMap.put("uiCredat", resultSet.getString("CREDAT"));
						userInfoMap.put("uiCretim", resultSet.getString("CRETIM"));
						userInfoMap.put("uiLmodat", resultSet.getString("LMODAT"));
						userInfoMap.put("uiLmotim", resultSet.getString("LMOTIM"));
						userInfoMap.put("uiActive", resultSet.getString("ACTIVE"));
						return userInfoMap;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertUserInfo(Map<String, String> userInfo) {
		String sql ="INSERT INTO user_info(UI_NAME, UI_ID, UI_PWD, UI_IMG_PATH, \r\n"
				+ "UI_DESC, UI_BIRTH, CREDAT, CRETIM,\r\n"
				+ "LMODAT, LMOTIM)\r\n"
				+ "VALUES(?, ?, ?, ?, ?, ?, DATE_FORMAT(NOW(), '%Y%m%d'), DATE_FORMAT(NOW(),'%H%i%s'),\r\n"
				+ "DATE_FORMAT(NOW(), '%Y%m%d'),DATE_FORMAT(NOW(),'%H%i%s')\r\n"
				+ ")";
		try(Connection connection = DBCon.getCon()){
			try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
				preparedStatement.setString(1, userInfo.get("uiName"));
				preparedStatement.setString(2, userInfo.get("uiId"));
				preparedStatement.setString(3, userInfo.get("uiPwd"));
				preparedStatement.setString(4, userInfo.get("uiImgPath"));
				preparedStatement.setString(5, userInfo.get("uiDesc"));
				preparedStatement.setString(6, userInfo.get("uiBirth"));
				
				return preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateUserInfo(Map<String, String> userInfo) {
		String sql = "UPDATE user_info SET UI_NAME = ?, UI_ID=?, UI_PWD=?, UI_IMG_PATH = ?,\r\n"
				+ " UI_DESC = ?, UI_BIRTH =?, LMODAT =DATE_FORMAT(NOW(), '%Y%m%d'), LMOTIM = DATE_FORMAT(NOW(),'%H%i%s')\r\n"
				+ " WHERE UI_NUM = ?";
		try(Connection connection = DBCon.getCon()){
			try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
				preparedStatement.setString(1, userInfo.get("uiName"));
				preparedStatement.setString(2, userInfo.get("uiId"));
				preparedStatement.setString(3, userInfo.get("uiPwd"));
				preparedStatement.setString(4, userInfo.get("uiImgPath"));
				preparedStatement.setString(5, userInfo.get("uiDesc"));
				preparedStatement.setString(6, userInfo.get("uiBirth"));
				preparedStatement.setString(7, userInfo.get("uiNum"));
				
				return preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int deleteUserInfo(String uiNum) {
		String sql = "DELETE FROM user_info WHERE UI_NUM=?";
		try(Connection connection = DBCon.getCon()){
			try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
				preparedStatement.setString(1, uiNum);
				
				return preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public Map<String, String> login(String uiId) {
		String sql = "SELECT * FROM user_info WHERE UI_ID = ?";
		try(Connection connection = DBCon.getCon()){
			try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
				preparedStatement.setString(1, uiId);
				try(ResultSet resultSet = preparedStatement.executeQuery()){
					if(resultSet.next()) {
						Map<String, String> userInfoMap = new HashMap();
						userInfoMap.put("uiNum", resultSet.getString("UI_NUM"));
						userInfoMap.put("uiId", resultSet.getString("UI_ID"));
						userInfoMap.put("uiName", resultSet.getString("UI_NAME"));
						userInfoMap.put("uiPwd", resultSet.getString("UI_PWD"));
						return userInfoMap;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		UserInfoDAO userInfoDAO = new UserInfoDAOImpl();
		System.out.println(userInfoDAO.selectUserInfoList(null));
		System.out.println(userInfoDAO.selectUserInfo("1"));
		System.out.println(userInfoDAO.login("JOON99"));
//		Map<String, String> testMap = new HashMap();
//		testMap.put("uiName", "test");
//		testMap.put("uiId", "test");
//		testMap.put("uiPwd", "test");
//		testMap.put("uiDesc", "test");
//		testMap.put("uiBirth", "19991010");
//		testMap.put("uiNum", "17");
//		System.out.println(userInfoDAO.deleteUserInfo("17"));

	}

	

}
