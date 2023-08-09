package com.game.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.game.common.MybatisSqlSessionFactory;
import com.game.dao.UserInfoDAO;
import com.game.dao.impl.UserInfoDAOImpl;
import com.game.mapper.UserInfoMapper;
import com.game.service.UserInfoService;
import com.game.vo.UserInfoVO;

public class UserInfoSeviceImpl implements UserInfoService {
	private UserInfoDAO userInfoDAO = new UserInfoDAOImpl();
	private SqlSessionFactory ssf = MybatisSqlSessionFactory.getSqlSessionFactory();
	@Override
	public List<UserInfoVO> selectUserInfoList(UserInfoVO userInfo) {
		try(SqlSession session = ssf.openSession()){
			UserInfoMapper userInfoMapper = session.getMapper(UserInfoMapper.class);
			return userInfoMapper.selectUserInfoList(userInfo);
		}catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Map<String, String> selectUserInfo(String uiNum) {
		return userInfoDAO.selectUserInfo(uiNum);
	}

	@Override
	public int insertUserInfo(Map<String, String> userInfo) {
		return userInfoDAO.insertUserInfo(userInfo);
	}

	@Override
	public int updateUserInfo(Map<String, String> userInfo) {
		return userInfoDAO.updateUserInfo(userInfo);
	}

	@Override
	public int deleteUserInfo(String uiNum) {
		return userInfoDAO.deleteUserInfo(uiNum);
	}

	@Override
	public Map<String, String> login(String uiId) {
		return userInfoDAO.login(uiId);
	}

	

}
