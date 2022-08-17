package br.com.testes.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteInsercaoComParametros {
    public static void main(String[] args) throws SQLException {
	ConnectionFactory factory = new ConnectionFactory();
	try (Connection con = factory.recuperarConexao()) {
	    con.setAutoCommit(false);

	    try (PreparedStatement stm = con.prepareStatement("insert into produto (nome, descricao) values (?, ?)",
		    Statement.RETURN_GENERATED_KEYS)) {
		adicionarVariavel("SmartTV", "50 polegadas", stm);
		adicionarVariavel("Celular", "Celular Samsung", stm);

		con.commit();
	    } catch (Exception e) {
		e.printStackTrace();
		System.out.println("Rollback executado");
		con.rollback();
	    }
	}
    }

    private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
	stm.setString(1, nome);
	stm.setString(2, descricao);

	if (nome.equalsIgnoreCase("Celular")) {
	    throw new RuntimeException("Não foi possível adicionar o produto.");
	}

	stm.execute();

	try (ResultSet rst = stm.getGeneratedKeys()) {
	    while (rst.next()) {
		Integer id = rst.getInt(1);
		System.out.println("Produto de id " + id + " criado");
	    }
	}
    }

}
