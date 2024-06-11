package com.sunbeam.beans;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class LoginBean {
	private String email;
	private String passwd;
	private User user;
	
	
	public LoginBean() {

	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPasswd() {
		return passwd;
	}


	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	
	public void authenticate() {
		try(UserDao userDao = new UserDaoImpl()) {
			User u = userDao.findByEmail(email);
			if(u != null && u.getPassword().equals(passwd))
				this.user = u;
			else
				this.user = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
