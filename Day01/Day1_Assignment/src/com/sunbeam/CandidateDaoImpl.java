package com.sunbeam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdk.internal.org.jline.reader.Candidate;

public class CandidateDaoImpl implements AutoCloseable {
	private Connection connection;
	
	public CandidateDaoImpl() throws SQLException {
		connection = Dbutil.getConnection();
	}
	
	@Override
	public void close() throws Exception {
		if(connection != null) {
			connection.close();
		}
		
	}
	
	
	public List<Candidate> findAll() throws SQLException {
		String sql = "SELECT * FROM candidates";
		List<Candidate> candidateList = new ArrayList<>();
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Candidate candidate = new Candidate();
				candidate.setId(rs.getInt("id"));
				candidate.setName(rs.getString("name"));
				candidate.setParty(rs.getString("party"));
				candidate.setVotes(rs.getInt("votes"));
				candidateList.add(candidate);
	
			}
		}
		return candidateList;
	}
	
	public List<Candidate> findParty() throws SQLException {
		String sql = "SELECT * FROM candidates WHERE party = ?";
		List<Candidate> candidateList = new ArrayList<>();
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, party);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Candidate candidate = new Candidate();
				candidate.setId(rs.getInt("id"));
				candidate.setName(rs.getString("name"));
				candidate.setParty(rs.getString("party"));
				candidate.setVotes(rs.getInt("votes"));
				candidateList.add(candidate);
	
			}
		}
		return candidateList;
	}
	
	
	public List<Candidate> findAllOrderByVotesDesc() throws SQLException {
		String sql = "SELECT * FROM candidates ORDER BY votes DESC";
		List<Candidate> candidateList = new ArrayList<>();
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Candidate candidate = new Candidate();
				candidate.setId(rs.getInt("id"));
				candidate.setName(rs.getString("name"));
				candidate.setParty(rs.getString("party"));
				candidate.setVotes(rs.getInt("votes"));
				candidateList.add(candidate);
	
			}
		}
		return candidateList;
	}
	
	public int save(Candidate candidate) throws SQLException {
		String sql = "INSERT INTO candidates(name, party, votes) VALUES(?, ?, ?)";
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			stmt.setString(1, candidate.getName());
			stmt.setString(2, candidate.getParty());
			stmt.setInt(3, candidate.getVotes());
			return stmt.executeUpdate();
	
			}
		}
	
	
	public int deleteById(int id) throws SQLException {
		String sql = "INSERT INTO candidates(name, party, votes) VALUES(?, ?, ?)";
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			stmt.setString(1, candidate.getName());
			stmt.setString(2, candidate.getParty());
			stmt.setInt(3, candidate.getVotes());
			return stmt.executeUpdate();
	
			}
		}
	
	
	}
	
	

}
