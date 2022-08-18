package br.com.testes.jdbc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private Integer id;
    private String nome;
    private List<Produto> listaProdutos = new ArrayList<Produto>();

    public Categoria(Integer id, String nome) {
	this.id = id;
	this.nome = nome;
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public void adicionar(Produto produto) {
	listaProdutos.add(produto);
    }

    public List<Produto> getListaProdutos() {
	return listaProdutos;
    }

}
