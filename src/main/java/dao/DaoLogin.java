package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.SingleConnection;

public class DaoLogin {

	private Connection connection;

	public DaoLogin() {
		connection = SingleConnection.getConnection();
	}
	
	public boolean validarLogin(String login, String senha) throws Exception {
		
		String sql = "select * from usuario"
				+ " where login = '" + login + "' and senha = '" + senha + "'";
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet resultSet = stmt.executeQuery();
		
		if(resultSet.next()) {
			return true; // possui usuario
		}
		return false; // nao encontrou usuario
	}
	
	
}
