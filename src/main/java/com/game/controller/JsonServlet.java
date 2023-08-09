package com.game.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.game.common.CommonView;
import com.game.service.BoardInfoService;
import com.game.service.impl.BoardInfoServiceImpl;
import com.game.vo.BoardInfoVO;
import com.google.gson.Gson;

/**
 * Servlet implementation class JasonServlet
 */
@WebServlet("/json/*")
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson gson = new Gson();
	private BoardInfoService boardInfoService = new  BoardInfoServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String json = "";
		String cmd = CommonView.getCmd(request);
		if("list".equals(cmd)) {
			BoardInfoVO boardInfoVO = new BoardInfoVO();
			boardInfoVO.setSearchStr(request.getParameter("searchStr"));
			boardInfoVO.setSearchType(request.getParameter("searchType"));
			json = gson.toJson( boardInfoService.boardInfoList(boardInfoVO));
		}else if ("one".equals(cmd)) {
			String biNum = request.getParameter("biNum");
			json = gson.toJson( boardInfoService.boardInfo(biNum));
		}
		System.out.println(json);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	public static void main(String[] args) throws ServletException, IOException {
		JsonServlet jasonServlet = new JsonServlet();
		jasonServlet.doGet(null, null);
	}

}
