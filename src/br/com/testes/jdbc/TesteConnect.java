package br.com.testes.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConnect {

    public static void main(String[] args) throws SQLException {
	ConnectionFactory conexao = new ConnectionFactory();
	Connection con = conexao.recuperarConexao();
	System.out.println("fechando exec");
	con.close();
    }

}
