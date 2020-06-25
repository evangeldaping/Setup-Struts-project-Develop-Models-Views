package com.portal.action;

import java.util.Map;
import java.sql.*;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
 
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String passwd;
	private Map<String, Object> sessionMap;
	public static final String SUCCESS = "success";
	public static final String ERROR = "error";
	public static final String INPUT = "input";
	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}
	public void setSessionMap(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String execute() throws Exception {
		String host = "jdbc:mysql://localhost:3306/";
		String dbName = "communityportal";
		String dbusername = "root";
		String pass = "";
		String url = host + dbName + "?user=" + dbusername + "&password=" + pass;
		String loggedUserName = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url);
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("select uname, pass from members");
			int flag = 0;
			while (rs.next()) {
				if ((username.equals(rs.getString(1)) || username == rs.getString(1))
						&& ((passwd.equals(rs.getString(2)) || passwd == rs.getString(2)))) {
					flag = 1;
					return SUCCESS;
				}
			}
			if (flag == 0) {
				addActionError("No such User!!");
				return ERROR;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return ERROR;
	}
	public void validate() {
		if("".equals(username) || "".equals(passwd)) {
			addActionError("Missing username or password!!");
		}
	}
    
	
}