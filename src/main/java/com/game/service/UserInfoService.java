package com.game.service;

import java.util.List;
import java.util.Map;

public interface UserInfoService {
	public List<Map<String, String>> selectUserInfoList(Map<String,String> userInfo);
	public Map<String, String> selectUserInfo(String uiNum);
	public int insertUserInfo(Map<String, String> userInfo);
	public int updateUserInfo(Map<String, String> userInfo);
	public int deleteUserInfo(String uiNum);
	public Map<String, String> login(String uiId);
}
