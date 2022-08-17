package br.com.testes.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TesteSelect {
    public static void main(String[] args) throws SQLException {
	ConnectionFactory conexao = new ConnectionFactory();
	Connection con = conexao.recuperarConexao();

	PreparedStatement stm = con.prepareStatement("select id, nome, descricao from produto");
	stm.execute();

	ResultSet rst = stm.getResultSet();
	while (rst.next()) {
	    Integer id = rst.getInt("id");
	    System.out.println(id);
	    String nome = rst.getString("nome");
	    System.out.println(nome);
	    String descricao = rst.getString("descricao");
	    System.out.println(descricao);
	}
	rst.close();
    }

}
