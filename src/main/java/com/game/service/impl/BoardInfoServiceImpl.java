package com.game.service.impl;

import java.util.List;
import java.util.Map;

import com.game.dao.BoardInfoDAO;
import com.game.dao.impl.BoardInfoDAOImpl;
import com.game.service.BoardInfoService;

public class BoardInfoServiceImpl implements BoardInfoService {
	private static final BoardInfoDAO boardInfoDAO = new BoardInfoDAOImpl();
	@Override
	public List<Map<String, String>> boardInfoList(Map<String, String> boardInfo) {
		// TODO Auto-generated method stub
		return boardInfoDAO.boardInfoList(boardInfo);
	}

	@Override
	public Map<String, String> boardInfo(String biNum) {
		// TODO Auto-generated method stub
		return boardInfoDAO.boardInfo(biNum);
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
