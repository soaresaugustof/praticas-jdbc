package br.com.testes.jdbc.modelo;

public class Produto {

    public Produto(String nome, String descricao) {
	this.nome = nome;
	this.descricao = descricao;
    }

    private Integer id;
    private String nome;
    private String descricao;

    public String getNome() {
	return nome;
    }

    public String getDescricao() {
	return descricao;
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    @Override
    public String toString() {
	return String.format("O produto criado foi: %d, %s, %s", this.id, this.nome, this.descricao);
    }
}
