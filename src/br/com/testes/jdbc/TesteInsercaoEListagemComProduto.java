package br.com.testes.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.testes.jdbc.dao.ProdutoDAO;
import br.com.testes.jdbc.modelo.Produto;

public class TesteInsercaoEListagemComProduto {

    public static void main(String[] args) throws SQLException {

	Produto produto = new Produto("MOUSE", "MOUSE SEM FIO");

	try (Connection connection = new ConnectionFactory().recuperarConexao()) {
	    ProdutoDAO produtoDAO = new ProdutoDAO(connection);
	    produtoDAO.salvar(produto);
	    List<Produto> listaProdutos = produtoDAO.listar();
	    listaProdutos.stream().forEach(lp -> System.out.println(lp));
	}
    }

}
