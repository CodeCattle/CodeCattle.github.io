package com.weipan.framework.attr.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;

import com.weipan.commons.exception.ServiceException;
import com.weipan.framework.attr.service.AttrService;
import com.weipan.framework.attr.service.AttrServiceImpl;
import com.weipan.framework.buy.service.Buyservice;
import com.weipan.framework.buy.service.BuyserviceImpl;
import com.weipan.framework.buy.vo.BuyType;
import com.weipan.framework.dir.service.DirService;
import com.weipan.framework.dir.service.DirServiceImpl;
import com.weipan.framework.userInfo.vo.UserInfo;
import com.weipan.framework.userType.service.TypeService;
import com.weipan.framework.userType.service.TypeServiceImpl;


@WebServlet("/sys/attr/show")
public class AttrShowServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		UserInfo userinfo=(UserInfo) session.getAttribute("session_user");
		String dir_id=request.getParameter("dir_id");
		System.out.println(dir_id);
		AttrService attrService=new AttrServiceImpl();
			
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.write(JSONObject.toJSONString(attrService.list(Integer.parseInt(dir_id),String.valueOf(userinfo.getUser_id()))));
		out.close();
	}
}
