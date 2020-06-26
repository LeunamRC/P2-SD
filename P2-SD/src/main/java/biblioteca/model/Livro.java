package biblioteca.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document

public class Livro implements Serializable {

    @Id
    private int id;
    private String nome;
    private int ano_pub;
    private String edicao;
    private String editora;
    private String autor;
    private int n_pag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public int getAno_pub() {
        return ano_pub;
    }

    public void setAno_pub(int ano_pub) {
        this.ano_pub = ano_pub;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getN_pag() {
        return n_pag;
    }

    public void setN_pag(int n_pag) {
        this.n_pag = n_pag;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}

