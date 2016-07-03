package com.keith.diy;

import javax.servlet.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class SystemService implements Servlet{

	public void init(ServletConfig parm1) throws ServletException {

	}

	public ServletConfig getServletConfig() {
		return null;
	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		String tag = (String)request.getParameter("tag");
		switch(tag) {
			case "DELETE_ALL_USERS":
				deleteAllUsers(request, response);
				break;
		}
	}

	public String getServletInfo() {
		return "";
	}

	public void destroy() {

	}

	private void deleteAllUsers(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		DBServer.deleteAllUsers();
		PrintWriter printWriter = response.getWriter();
		printWriter.print("all users are deleted success!!");
	}
}