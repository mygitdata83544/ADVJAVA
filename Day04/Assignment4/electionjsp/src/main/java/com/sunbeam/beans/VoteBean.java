package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;

public class VoteBean {
	private int candid;
	private int userid;
	
	
	public VoteBean() {
	
	}


	public int getCandid() {
		return candid;
	}


	public void setCandid(int candid) {
		this.candid = candid;
	}


	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	
	public void vote() {
		try (CandidateDao candDao = new CandidateDaoImpl()) {
			candDao.incrementVote(candid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try (UserDao userDao = new UserDaoImpl()) {
			userDao.updateStatus(userid, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
