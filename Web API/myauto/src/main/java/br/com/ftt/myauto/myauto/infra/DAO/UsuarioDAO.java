package br.com.ftt.myauto.myauto.infra.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.ftt.myauto.myauto.modelo.Usuario;


public class UsuarioDAO {
	private Connection connection;

	public UsuarioDAO(Connection connection) {
		this.connection = connection;
	}
	
	public Usuario obterUsuarioPorEmail(String email) {
		try {
			Usuario usuario = new Usuario();
			String sql = String.format("select * from usuario where email = '%s'", email);

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.execute();

				try (ResultSet rst = pstm.getResultSet()) {
					while (rst.next()) {
						usuario = new Usuario(rst.getString(2), rst.getString(3), rst.getString(4));
						usuario.setId(rst.getLong(1));
					}
				}
			}
			return usuario;

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public List<Usuario> listar() {
		try {
			List<Usuario> usuarios = new ArrayList<Usuario>();
			String sql = "select * from usuario";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.execute();

				try (ResultSet rst = pstm.getResultSet()) {
					while (rst.next()) {
						Usuario usuario = new Usuario(rst.getString(2), rst.getString(3), rst.getString(4));
						usuario.setId(rst.getLong(1));

						usuarios.add(usuario);
					}
				}
			}
			return usuarios;

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void salvar(Usuario usuario) {
		try {
			String sql = "INSERT INTO USUARIO (NOME, EMAIL, SENHA) VALUES (?, ?, ?)";

			try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				pstm.setString(1, usuario.getNome());
				pstm.setString(2, usuario.getEmail());
				pstm.setString(3, usuario.getSenha());

				pstm.execute();

				try (ResultSet rst = pstm.getGeneratedKeys()) {
					while (rst.next()) {
						usuario.setId(rst.getLong(1));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
