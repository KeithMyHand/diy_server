package com.keith.diy;

import javax.servlet.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import com.alibaba.fastjson.*;

public class UserService implements Servlet{

	public void init(ServletConfig parm1) throws ServletException {

	}

	public ServletConfig getServletConfig() {
		return null;
	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		String tag = (String)request.getParameter("tag");
		switch(tag) {
			case "REGISTER":
				userRegister(request, response);
				break;
			case "LOGIN":
				userLogin(request, response);
				break;
			case "PRE_LOGIN":
				preLogin(request, response);
				break;
			case "SHOW_ALL_USERS":
				showAllUsers(request, response);
				break;
			case "GET_USER_INFO":
				getUserInfo(request, response);
				break;
			case "GET_USER_ARTICLES":
				getUserArticles(request, response);
				break;
		}
	}

	public String getServletInfo() {
		return "";
	}

	public void destroy() {

	}

	private void userRegister(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
		String name = (String)request.getParameter("name");
		String password = (String)request.getParameter("password");
		User user = new User(name, password);
		if(DBServer.isUserExist(user)) {
			printWriter.print("HAS_USER");
		}
		else {
			DBServer.insertUser(new User(name, password));
	        ClientUser clientUser = DBServer.getClientUser(name);
			String jsonString = JSON.toJSONString(clientUser);
			printWriter.print(jsonString);
		}
	}

	private void userLogin(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
		String name = (String)request.getParameter("name");
		String password = (String)request.getParameter("password");
		User user = new User(name, password);
		if(DBServer.isUserExist(user)) {
	        ClientUser clentUser = DBServer.getClientUser(name);
			String jsonString = JSON.toJSONString(clentUser);
			printWriter.print(jsonString);
		}
		else {
			printWriter.print("NO_USER");
		}
	}

	private void preLogin(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
		String name = (String)request.getParameter("name");
		String password = (String)request.getParameter("password");
		User user = new User(name, password);
		if(DBServer.isUserExist(user)) {
	        ClientUser clentUser = DBServer.getClientUser(name);
			String jsonString = JSON.toJSONString(clentUser);
			printWriter.print(jsonString);
		}
		else {
			printWriter.print("NO_USER");
		}
	}

	private void showAllUsers(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
        ArrayList<User> users = DBServer.getAllUsers();
        Iterator iterator = users.iterator();
        List<User> list = new ArrayList<User>();
        while(iterator.hasNext()){
        	list.add((User)iterator.next());
		}
		String jsonString = JSON.toJSONString(list);
		printWriter.print(jsonString);
	}
	
	private void getUserInfo(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
		String name = (String)request.getParameter("name");
        ClientUser user = DBServer.getClientUser(name);
		String jsonString = JSON.toJSONString(user);
		printWriter.print(jsonString);
	}
	
	private void getUserArticles(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
		String name = (String)request.getParameter("name");
        ArrayList<Article> list = DBServer.getUserArticles(name);
		String jsonString = JSON.toJSONString(list);
		printWriter.print(jsonString);
	}
}