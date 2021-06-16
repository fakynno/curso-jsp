package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.BeanCursoJsp;
import connection.SingleConnection;

public class DaoUsuario {

	private Connection connection;

	public DaoUsuario() {
		connection = SingleConnection.getConnection();
	}

	public void salvar(BeanCursoJsp usuario) {

		try {

			String sql = "insert into usuario(login, senha) values (?, ?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getSenha());
			stmt.execute();
			connection.commit();
			System.out.println("Usuario " + usuario.getLogin() + " salvo com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

	}

	public List<BeanCursoJsp> listarUsuarios() throws Exception {

		List<BeanCursoJsp> lista = new ArrayList<BeanCursoJsp>();

		String sql = "select * from usuario";

		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet resultSet = stmt.executeQuery();

		while (resultSet.next()) {

			BeanCursoJsp cursoJsp = new BeanCursoJsp();
			cursoJsp.setId(resultSet.getLong("id"));
			cursoJsp.setLogin(resultSet.getString("login"));
			cursoJsp.setSenha(resultSet.getString("senha"));

			lista.add(cursoJsp);
		}

		return lista;

	}

	public void delete(String login) {

		try {
			String usuarioExcluido = login;
			String sql = "delete from usuario where login = '" + login + "'";

			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.execute();
			connection.commit();
			System.out.println("Usuário " + usuarioExcluido + " excluído com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	public BeanCursoJsp consultar(String login) throws Exception {

		String sql = "select * from usuario where login = '" + login + "'";

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet set = statement.executeQuery();
		if (set.next()) {

			BeanCursoJsp cursoJsp = new BeanCursoJsp();
			cursoJsp.setId(set.getLong("id"));
			cursoJsp.setLogin(set.getString("login"));
			cursoJsp.setSenha(set.getString("senha"));

			return cursoJsp;
		}

		return null;
	}

	public void atualizar(BeanCursoJsp cursoJsp) {
		try {

			String usuario = cursoJsp.getLogin();
			
			String sql = "update usuario set login = ?, senha = ? where id = " + cursoJsp.getId();
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, cursoJsp.getLogin());
			statement.setString(2, cursoJsp.getSenha());
			statement.executeUpdate();
			connection.commit();
			System.out.println("Usuário " + usuario + " atualizado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

	}

}
