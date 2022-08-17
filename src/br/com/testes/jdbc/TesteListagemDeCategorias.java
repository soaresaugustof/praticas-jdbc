package br.com.testes.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.testes.jdbc.dao.CategoriaDAO;
import br.com.testes.jdbc.modelo.Categoria;

public class TesteListagemDeCategorias {
    public static void main(String[] args) throws SQLException {

	try (Connection connection = new ConnectionFactory().recuperarConexao()) {

	    CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
	    List<Categoria> listaCategorias = categoriaDAO.listar();
	    listaCategorias.stream().forEach(lc -> System.out.println(lc.getNome()));
	}

    }
}
