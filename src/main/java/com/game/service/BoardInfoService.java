package com.game.service;

import java.util.List;
import java.util.Map;

import com.game.vo.BoardInfoVO;

public interface BoardInfoService {
	public List<BoardInfoVO> boardInfoList(BoardInfoVO boardInfo);
	public BoardInfoVO boardInfo(String biNum);
	public int insertBoardInfo(Map<String, String> boardInfo); 
	public int updateBoardInfo(Map<String, String> boardInfo); 
	public int deleteBoardInfo(String biNum); 
}
