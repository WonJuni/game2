package com.game.service;

import java.util.List;
import java.util.Map;

import com.game.vo.UserInfoVO;

public interface UserInfoService {
	public List<UserInfoVO> selectUserInfoList(UserInfoVO userInfo);
	public Map<String, String> selectUserInfo(String uiNum);
	public int insertUserInfo(Map<String, String> userInfo);
	public int updateUserInfo(Map<String, String> userInfo);
	public int deleteUserInfo(String uiNum);
	public Map<String, String> login(String uiId);
}
