package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class FindCandidateBean {
	private int id;
	private Candidate candidate;
	
	
	public FindCandidateBean() {
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Candidate getCandidate() {
		return candidate;
	}


	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	
	public void fetchCandidate() {
		try(CandidateDao candDao = new CandidateDaoImpl()) {
			candidate = candDao.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	

}
