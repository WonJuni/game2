package com.game.service;

import java.util.List;

import com.game.vo.TestInfoVO;

public interface TestInfoService {
	public List<TestInfoVO> selectTestInfoList(TestInfoVO tiNum);
}
