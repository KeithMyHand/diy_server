package com.keith.diy;

import java.io.*;
import java.sql.*;
import java.util.*;

public class DBServer {

	public static void deleteAllUsers()
	{
		try {
			Connection conn = GetConnection();
	        Statement stmt = conn.createStatement();
            String sql = "delete from users";
            stmt.executeUpdate(sql);
        	CloseResource(conn, stmt);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	public static void insertUser(User user)
	{
		try {
			Connection conn = GetConnection();
	        Statement stmt = conn.createStatement();
            String sql = "insert into users set name = '" + user.getName() + "', password = '" + user.getPassword() + "'";
            stmt.executeUpdate(sql);
        	CloseResource(conn, stmt);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	public static ArrayList<User> getAllUsers()
	{
        ArrayList<User> users = new ArrayList<User>();
		try {
			Connection conn = GetConnection();
	        Statement stmt = conn.createStatement();
            String sql = "select * from users";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs != null)
        	{
		        while(rs.next()){
					users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3)));
				}
        	}
        	CloseResource(conn, stmt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
	}

	public static ClientUser getClientUser(String name)
	{
		ClientUser user = new ClientUser();
		try {
			Connection conn = GetConnection();
	        Statement stmt = conn.createStatement();
            String sql = "select * from users where name = '" + name + "'";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs != null)
        	{
		        if(rs.next()){
		        	user.setName(rs.getString(2));
				}
        	}
        	CloseResource(conn, stmt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
	}

	public static ArrayList<Article> getUserArticles(String name)
	{
		ArrayList<Article> articles = new ArrayList<Article>();
		try {
			Connection conn = GetConnection();
	        Statement stmt = conn.createStatement();
            String sql = "select * from articles where user_id = (select id from users where name = '" + name + "')";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs != null)
        	{
		        while(rs.next()){
					articles.add(new Article(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getString(5)));
				}
        	}
        	CloseResource(conn, stmt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return articles;
	}

	public static boolean isUserExist(User user)
	{
		boolean isUserExist = false;
		try {
			Connection conn = GetConnection();
	        Statement stmt = conn.createStatement();
            String sql = "select * from users where name='" + user.getName() + "'and password='" + user.getPassword() + "'";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs != null)
        	{
		        if(rs.next()){
					isUserExist = true;
				}
        	}
        	CloseResource(conn, stmt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isUserExist;
	}

	private static Connection GetConnection()
	{
		Connection conn = null;
		String url = "jdbc:mysql://127.0.0.1:3306/diy?user=root&password=my@2014zhuce";
		try {
			Class.forName("com.mysql.jdbc.Driver");
        	conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	return conn;
        }
	}

	private static void CloseResource(Connection conn, Statement stmt)
	{
		try {
	    	if(stmt != null)
	        	stmt.close();
	    	if(conn != null)
	        	conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}