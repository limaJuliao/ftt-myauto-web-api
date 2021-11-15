package br.com.ftt.myauto.myauto.infra.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.ftt.myauto.myauto.modelo.Abastecimento;


public class AbastecimentoDAO {
	private Connection connection;

	public AbastecimentoDAO(Connection connection) {
		this.connection = connection;
	}

	public List<Abastecimento> listar(Long veiculoId) {
		try {
			List<Abastecimento> abastecimentos = new ArrayList<Abastecimento>();
			String sql = String.format("SELECT * FROM ABASTECIMENTO WHERE VEICULOID = '%s'", veiculoId);

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.execute();

				try (ResultSet rst = pstm.getResultSet()) {
					while (rst.next()) {
						Abastecimento abastecimento = new Abastecimento(rst.getString(2), rst.getLong(3),
								rst.getDouble(4),rst.getDouble(5), rst.getDouble(6), rst.getLong(7));
						abastecimento.setId(rst.getLong(1));

						abastecimentos.add(abastecimento);
					}
				}
			}
			return abastecimentos;

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void salvar(Abastecimento abastecimento) {
		try {
			String sql = "INSERT INTO ABASTECIMENTO (DATA, ODOMETRO, PRECOLITRO, VOLUME, PRECOTOTAL, VEICULOID)"
					+ " VALUES (?, ?, ?, ?, ?, ?)";

			try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				
				pstm.setString(1, abastecimento.getData());
				pstm.setLong(2, abastecimento.getOdometro());
				pstm.setDouble(3, abastecimento.getPrecoLitro());
				pstm.setDouble(4, abastecimento.getVolume());
				pstm.setDouble(5, abastecimento.getPrecoTotal());
				pstm.setLong(6, abastecimento.getVeiculoId());

				pstm.execute();

				try (ResultSet rst = pstm.getGeneratedKeys()) {
					while (rst.next()) {
						abastecimento.setId(rst.getLong(1));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
