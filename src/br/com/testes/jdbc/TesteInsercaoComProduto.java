package br.com.testes.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.testes.jdbc.dao.ProdutoDAO;
import br.com.testes.jdbc.modelo.Produto;

public class TesteInsercaoComProduto {

    public static void main(String[] args) throws SQLException {

	Produto produto = new Produto("CÔMODA", "CÔMODA VERTICAL");

	try (Connection connection = new ConnectionFactory().recuperarConexao()) {
	    ProdutoDAO produtoDAO = new ProdutoDAO(connection);
	    produtoDAO.salvar(produto);
	    // produtoDAO.listar();
	}
	System.out.println(produto);
    }

}
