package com.game.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.game.common.CommonView;
import com.game.mapper.TestInfoMapper;
import com.game.service.TestInfoService;
import com.game.service.impl.TestInfoServiceImpl;
import com.google.gson.Gson;


@WebServlet("/test-info/*")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson gson = new Gson();
	private TestInfoService testInfoService = new TestInfoServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = CommonView.getCmd(request);
		System.out.println("list".equals(cmd));
		if ("list".equals(cmd)) {
			String json = gson.toJson(testInfoService.selectTestInfoList(null));
			PrintWriter out = response.getWriter();
			out.print(json);
			System.out.println(json);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
