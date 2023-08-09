package com.game.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.print.DocFlavor.STRING;
import javax.websocket.Session;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.game.mapper.BoardInfoMapper;
import com.game.mapper.TestInfoMapper;
import com.game.mapper.UserInfoMapper;
import com.game.vo.BoardInfoVO;
import com.game.vo.TestInfoVO;
import com.game.vo.UserInfoVO;

public class MybatisSqlSessionFactory {
	private static SqlSessionFactory SSF;
	private final static String CONFIG_PATH = "config/mybatis-config.xml";

	static {
		try {
			InputStream is = Resources.getResourceAsStream(CONFIG_PATH);
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			SSF = ssfb.build(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return SSF;
	}

	public static void main(String[] args) {
	 SqlSessionFactory ssf = getSqlSessionFactory();
	 SqlSession session = ssf.openSession();
	 TestInfoMapper testInfoMapper = session.getMapper(TestInfoMapper.class);
	 List<TestInfoVO> list = testInfoMapper.selectTestInfoList(null);
	 System.out.println(list);
	}

}
