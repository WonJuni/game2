package com.game.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.game.common.DBCon;
import com.game.dao.BoardInfoDAO;

public class BoardInfoDAOImpl implements BoardInfoDAO {

	@Override
	public List<Map<String, String>> boardInfoList(Map<String, String> boardInfo) {
		List<Map<String, String>> boardInfoList = new ArrayList();
		String sql = "SELECT BI.*, UI.UI_NAME FROM BOARD_INFO BI\r\n"
				+ "INNER JOIN USER_INFO UI\r\n"
				+ "ON BI.UI_NUM = UI.UI_NUM WHERE 1=1";
		if (boardInfo != null) {
			String key = boardInfo.get("key");
			if ("1".equals(key)) {
				sql += " OR BI_TITLE LIKE CONCAT('%',?,'%')";
			} else if ("2".equals(key)) {
				sql += " OR UI_NAME LIKE CONCAT('%',?,'%')";
			} else if ("3".equals(key)) {
				sql += " OR BI_CONTENT LIKE CONCAT('%',?,'%')";
			} else if ("4".equals(key)) {
				sql += " OR BI_TITLE LIKE CONCAT('%',?,'%')";
				sql += " OR BI_CONTENT LIKE CONCAT('%',?,'%')";
			} else if ("5".equals(key)) {
				sql += " OR UI_NAME LIKE CONCAT('%',?,'%')";
				sql += " OR BI_CONTENT LIKE CONCAT('%',?,'%')";
			} else if ("6".equals(key)) {
				sql += " OR BI_TITLE LIKE CONCAT('%',?,'%')";
				sql += " OR UI_NAME LIKE CONCAT('%',?,'%')";
			} else if ("7".equals(key)) {
				sql += " OR BI_TITLE LIKE CONCAT('%',?,'%')";
				sql += " OR UI_NAME LIKE CONCAT('%',?,'%')";
				sql += " OR BI_CONTENT LIKE CONCAT('%',?,'%')";
			}

		}
		try(Connection connection = DBCon.getCon()){
			try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
				if (boardInfo != null) {
					String key = boardInfo.get("key");
					if ("1".equals(key)) {
						preparedStatement.setString(1, boardInfo.get("value"));
					} else if ("1".equals(key)) {
						preparedStatement.setString(1, boardInfo.get("value"));
					} else if ("2".equals(key)) {
						preparedStatement.setString(1, boardInfo.get("value"));
					} else if ("3".equals(key)) {
						preparedStatement.setString(1, boardInfo.get("value"));
					} else if ("4".equals(key)) {
						preparedStatement.setString(1, boardInfo.get("value"));
						preparedStatement.setString(2, boardInfo.get("value"));
					} else if ("5".equals(key)) {
						preparedStatement.setString(1, boardInfo.get("value"));
						preparedStatement.setString(2, boardInfo.get("value"));
					} else if ("6".equals(key)) {
						preparedStatement.setString(1, boardInfo.get("value"));
						preparedStatement.setString(2, boardInfo.get("value"));
					} else if ("7".equals(key)) {
						preparedStatement.setString(1, boardInfo.get("value"));
						preparedStatement.setString(2, boardInfo.get("value"));
						preparedStatement.setString(3, boardInfo.get("value"));
					}
				}
				try(ResultSet resultSet = preparedStatement.executeQuery()){
					while (resultSet.next()) {
						Map<String, String> boardInfoMap = new HashMap();
						boardInfoMap.put("biNum", resultSet.getString("BI_NUM"));
						boardInfoMap.put("biTitle", resultSet.getString("BI_TITLE"));
						boardInfoMap.put("biContent", resultSet.getString("BI_CONTENT"));
						boardInfoMap.put("uiNum", resultSet.getString("UI_NUM"));
						boardInfoMap.put("uiName", resultSet.getString("UI_NAME"));
						boardInfoMap.put("biCredat", resultSet.getString("CREDAT"));
						boardInfoMap.put("biCretim", resultSet.getString("CRETIM"));
						boardInfoMap.put("biLmodat", resultSet.getString("LMODAT"));
						boardInfoMap.put("biLmotim", resultSet.getString("LMOTIM"));
						boardInfoMap.put("biActive", resultSet.getString("ACTIVE"));
						boardInfoList.add(boardInfoMap);
						
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return boardInfoList;
	}

	@Override
	public Map<String, String> boardInfo(String biNum) {
		String sql = "SELECT * FROM BOARD_INFO WHERE BI_NUM=?";
		try(Connection connection = DBCon.getCon()){
			try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
				preparedStatement.setString(1, biNum);
				try(ResultSet resultSet = preparedStatement.executeQuery()){
					while (resultSet.next()) {
						Map<String, String> boardInfoMap = new HashMap();
						boardInfoMap.put("biNum", resultSet.getString("BI_NUM"));
						boardInfoMap.put("biTitle", resultSet.getString("BI_TITLE"));
						boardInfoMap.put("biContent", resultSet.getString("BI_CONTENT"));
						boardInfoMap.put("uiNum", resultSet.getString("UI_NUM"));
						boardInfoMap.put("biCredat", resultSet.getString("CREDAT"));
						boardInfoMap.put("biCretim", resultSet.getString("CRETIM"));
						boardInfoMap.put("biLmodat", resultSet.getString("LMODAT"));
						boardInfoMap.put("biLmotim", resultSet.getString("LMOTIM"));
						boardInfoMap.put("biActive", resultSet.getString("ACTIVE"));
						return boardInfoMap;
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertBoardInfo(Map<String, String> boardInfo) {
		String sql = "INSERT INTO board_info(BI_TITLE, BI_CONTENT, UI_NUM, CREDAT, CRETIM, LMODAT, LMOTIM)\r\n"
				+ "VALUES(?, ?, ?,  DATE_FORMAT(NOW(), '%Y%m%d'),DATE_FORMAT(NOW(),'%H%i%s'), DATE_FORMAT(NOW(), '%Y%m%d'),DATE_FORMAT(NOW(),'%H%i%s')\r\n"
				+ ")";
		try(Connection connection = DBCon.getCon()){
			try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
				preparedStatement.setString(1, boardInfo.get("biTitle"));
				preparedStatement.setString(2, boardInfo.get("biContent"));
				preparedStatement.setString(3, boardInfo.get("uiNum"));
				return preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBoardInfo(Map<String, String> boardInfo) {
		String sql = "UPDATE board_info SET BI_TITLE = ?,\r\n"
				+ "BI_CONTENT = ?,\r\n"
				+ "UI_NUM = ?,\r\n"
				+ "LMODAT = DATE_FORMAT(NOW(), '%Y%m%d'),\r\n"
				+ "LMOTIM = DATE_FORMAT(NOW(), '%H%i%s')\r\n"
				+ "WHERE BI_NUM=?";
		
		try(Connection connection = DBCon.getCon()){
			try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
				preparedStatement.setString(1, boardInfo.get("biTitle"));
				preparedStatement.setString(2, boardInfo.get("biContent"));
				preparedStatement.setString(3, boardInfo.get("uiNum"));
				preparedStatement.setString(4, boardInfo.get("biNum"));
				return preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteBoardInfo(String biNum) {
		String sql = "DELETE FROM BOARD_INFO WHERE BI_NUM = ?";
		try(Connection connection = DBCon.getCon()){
			try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
				preparedStatement.setString(1, biNum);
				
				return preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public static void main(String[] args) {
		BoardInfoDAOImpl boardInfoDAOImpl = new BoardInfoDAOImpl();
		System.out.println(boardInfoDAOImpl.boardInfoList(null));
		System.out.println(boardInfoDAOImpl.boardInfo("6"));
		Map<String, String> testMap = new HashMap();
//		testMap.put("biTitle", "javaTest");
//		testMap.put("biContent", "javaTest");
//		testMap.put("uiNum", "1");
//		testMap.put("biNum", "4");
//		System.out.println(boardInfoDAOImpl.deleteBoardInfo(testMap.get("biNum")));
	}

}
