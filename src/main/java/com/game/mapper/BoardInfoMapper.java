package com.game.mapper;

import java.util.List;

import com.game.vo.BoardInfoVO;

public interface BoardInfoMapper {
	List<BoardInfoVO> selectBoardInfoList(BoardInfoVO board); 
}