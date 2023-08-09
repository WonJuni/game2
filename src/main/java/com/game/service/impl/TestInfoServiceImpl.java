package com.game.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.game.common.MybatisSqlSessionFactory;
import com.game.mapper.TestInfoMapper;
import com.game.mapper.UserInfoMapper;
import com.game.service.TestInfoService;
import com.game.vo.TestInfoVO;

public class TestInfoServiceImpl implements TestInfoService {
	private SqlSessionFactory ssf = MybatisSqlSessionFactory.getSqlSessionFactory();
	@Override
	public List<TestInfoVO> selectTestInfoList(TestInfoVO tiNum) {
		try(SqlSession session = ssf.openSession()){
			TestInfoMapper testInfoMapper = session.getMapper(TestInfoMapper.class);
			System.out.println(testInfoMapper.selectTestInfoList(tiNum));
			return testInfoMapper.selectTestInfoList(tiNum);
		}catch (Exception e) {
			throw e;
		}
	}
	
	public static void main(String[] args) {
		TestInfoServiceImpl testInfoServiceImpl = new TestInfoServiceImpl();
		System.out.println(testInfoServiceImpl.selectTestInfoList(null));
	}

}
