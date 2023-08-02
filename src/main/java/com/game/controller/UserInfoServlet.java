package com.game.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.game.common.CommonView;
import com.game.service.UserInfoService;
import com.game.service.impl.UserInfoSeviceImpl;

@WebServlet("/user-info/*")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final UserInfoService USER_INFO_SERVICE = new UserInfoSeviceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String cmd = CommonView.getCmd(request);
		System.out.println(cmd);
		if ("login".equals(cmd)) {

		}else if ("logout".equals(cmd)) {
			HttpSession session = request.getSession();
			session.invalidate();
		}else if ("insert".equals(cmd)) {
			
		}
		CommonView.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		String cmd = CommonView.getCmd(request);
		if ("login".equals(cmd)) {
			request.setAttribute("msg", "bad Login");
			request.setAttribute("url", "/user-info/login");
			String uiId = request.getParameter("uiId");
			String uiPwd = request.getParameter("uiPwd");
			System.out.println(uiId + uiPwd);
			System.out.println(USER_INFO_SERVICE.login(uiId));
			if (USER_INFO_SERVICE.login(uiId) != null) {
				String dbUiPwd = USER_INFO_SERVICE.login(uiId).get("uiPwd");
				System.out.println(dbUiPwd);
				if (uiPwd.equals(dbUiPwd)) {
					request.setAttribute("msg", "nice Login");
					request.setAttribute("url", "/");
					session.setAttribute("userInfo", USER_INFO_SERVICE.login(uiId));
				}
			}
		}else if ("insert".equals(cmd)) {
			Map<String, String> userInfoMap = new HashMap();
			userInfoMap.put("uiId", request.getParameter("uiId"));
			userInfoMap.put("uiPwd", request.getParameter("uiPwd"));
			userInfoMap.put("uiName", request.getParameter("uiName"));
			userInfoMap.put("uiDesc", request.getParameter("uiDesc"));
			userInfoMap.put("uiBirth", request.getParameter("uiBirth"));
			request.setAttribute("msg", "Bad Insert");
			request.setAttribute("url", "/");
			if (USER_INFO_SERVICE.insertUserInfo(userInfoMap) == 1) {
				request.setAttribute("msg", "nice Insert");
				request.setAttribute("url", "/");
			}
		}
		CommonView.forwardMessage(request, response);
	}

}
