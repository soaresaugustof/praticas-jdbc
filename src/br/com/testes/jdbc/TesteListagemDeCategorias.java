package br.com.testes.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.testes.jdbc.dao.CategoriaDAO;
import br.com.testes.jdbc.dao.ProdutoDAO;
import br.com.testes.jdbc.modelo.Categoria;
import br.com.testes.jdbc.modelo.Produto;

public class TesteListagemDeCategorias {
    public static void main(String[] args) throws SQLException {

	try (Connection connection = new ConnectionFactory().recuperarConexao()) {

	    CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
	    List<Categoria> listaCategorias = categoriaDAO.listar();
	    listaCategorias.stream().forEach(lc -> {
		System.out.println(lc.getNome());
		try {
		    for (Produto produto : new ProdutoDAO(connection).buscar(lc)) {
			System.out.println(lc.getNome() + " - " + produto.getNome());
		    }
		} catch (SQLException e) {
		    e.printStackTrace();
		}
	    });
	}

    }
}
