package com.game.dao;

import java.util.List;
import java.util.Map;

public interface BoardInfoDAO {
	public List<Map<String, String>> boardInfoList(Map<String, String> boardInfo);
	public Map<String, String> boardInfo(String biNum);
	public int insertBoardInfo(Map<String, String> boardInfo); 
	public int updateBoardInfo(Map<String, String> boardInfo); 
	public int deleteBoardInfo(String biNum); 
	
}
