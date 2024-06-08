package com.sunbeam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements AutoCloseable {
	private Connection connection;
	
	public UserDaoImpl() throws SQLException {
		connection = Dbutil.getConnection();
	}
	
	@Override
	public void close() throws Exception {
		if(connection != null) {
			connection.close();
		}
		
	}
	
	
	public User findByEmail(String email) throws SQLException {
		String sql = "SELECT * FROM user WHERE email = ?";
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setVoted(rs.getBoolean("voted"));
				return user;
			}
		}
		return null;
	}
	
	public User findById(int id) throws SQLException {
		String sql = "SELECT * FROM user WHERE id = ?";
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setVoted(rs.getBoolean("voted"));
				return user;
			}
		}
		return null;
	}
	
	public int save(User user) throws SQLException {
		String sql = "INSERT INTO user(email, password, voted) VALUES(?, ?, ?)";
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, user.getEmail());
			stmt.setString(2,user.getPassword());
			stmt.setBoolean(3, user.isVoted());
			return stmt.executeUpdate();
		}
	}
	
	public int updateStatus(int userId, boolean voted) throws SQLException {
		String sql = "UPDATE user SET voted = ? WHERE id = ?";
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setBoolean(1, voted);
			stmt.setInt(2, userId);
			return stmt.executeUpdate();
		}
	}
	
	public int updatePassword(int userId, String newPassword) throws SQLException {
		String sql = "UPDATE user SET password = ? WHERE id = ?";
		try(PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, newPassword);
			stmt.setInt(2, userId);
			return stmt.executeUpdate();
		}
	}
	
	public int deleteById(int id) throws SQLException {
		String sql = "DELETE FROM user WHERE id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);
			return stmt.executeUpdate();
		}
	}
	
	public int update(User user) throws SQLException {
		String sql = "UPDATE user SET email = ?, password = ?, voted = ? WHERE id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getPassword);
			stmt.setBoolean(3, user.isVoted());
			stmt.setInt(4, user.getId());
			return stmt.executeUpdate();
		}
	}

}
