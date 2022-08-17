package br.com.testes.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.testes.jdbc.modelo.Produto;

public class TesteInsercaoComProduto {

    public static void main(String[] args) throws SQLException {

	Produto produto = new Produto("CÔMODA", "CÔMODA VERTICAL");

	try (Connection connection = new ConnectionFactory().recuperarConexao()) {

	    String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?, ?)";

	    try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
		pstm.setString(1, produto.getNome());
		pstm.setString(2, produto.getDescricao());

		pstm.execute();

		try (ResultSet rst = pstm.getGeneratedKeys()) {
		    while (rst.next()) {
			produto.setId(rst.getInt(1));
		    }
		}
	    }
	}
	System.out.println(produto);
    }

}
