package com.game.service.impl;

import java.util.List;
import java.util.Map;

import javax.websocket.Session;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.game.common.MybatisSqlSessionFactory;
import com.game.dao.BoardInfoDAO;
import com.game.dao.impl.BoardInfoDAOImpl;
import com.game.mapper.BoardInfoMapper;
import com.game.service.BoardInfoService;
import com.game.vo.BoardInfoVO;

public class BoardInfoServiceImpl implements BoardInfoService {
	private static final BoardInfoDAO boardInfoDAO = new BoardInfoDAOImpl();
	private SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
	@Override
	public List<BoardInfoVO> boardInfoList(BoardInfoVO boardInfo) {
		try(SqlSession sqlSession = sqlSessionFactory.openSession()){
			BoardInfoMapper boardInfoMapper = sqlSession.getMapper(BoardInfoMapper.class);
			return boardInfoMapper.selectBoardInfoList(boardInfo);
		}catch (Exception e) {
			throw e;
		}
	}

	@Override
	public BoardInfoVO boardInfo(String biNum) {
		try(SqlSession sqlSession = sqlSessionFactory.openSession()){
			BoardInfoMapper boardInfoMapper = sqlSession.getMapper(BoardInfoMapper.class);
			return boardInfoMapper.selectBoardInfo(biNum);
		}catch (Exception e) {
			throw e;
		}
	}

	@Override
	public int insertBoardInfo(Map<String, String> boardInfo) {
		// TODO Auto-generated method stub
		return boardInfoDAO.insertBoardInfo(boardInfo);
	}

	@Override
	public int updateBoardInfo(Map<String, String> boardInfo) {
		// TODO Auto-generated method stub
		return boardInfoDAO.updateBoardInfo(boardInfo);
	}

	@Override
	public int deleteBoardInfo(String biNum) {
		// TODO Auto-generated method stub
		return boardInfoDAO.deleteBoardInfo(biNum);
	}

}
