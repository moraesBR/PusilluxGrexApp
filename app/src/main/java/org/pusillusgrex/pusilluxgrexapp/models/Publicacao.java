package org.pusillusgrex.pusilluxgrexapp.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Publicacao {
    private String titulo;
    private LocalDate data;
    private ArrayList<Tag> categorias;
    private String urlMidia;
    private String urlImagem;
    private String descricao;
    private String texto;

    public Publicacao(String titulo,
                      LocalDate data,
                      ArrayList<Tag> categorias,
                      String urlMidia,
                      String urlImagem,
                      String descricao,
                      String texto) {
        this.titulo = titulo;
        this.data = data;
        this.categorias = categorias;
        this.urlMidia = urlMidia;
        this.urlImagem = urlImagem;
        this.descricao = descricao;
        this.texto = texto;
    }

    public Publicacao() {
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDate getData() {
        return data;
    }

    public ArrayList<Tag> getCategorias() {
        return categorias;
    }

    public String getUrlMidia() {
        return urlMidia;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getTexto() {
        return texto;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setCategorias(ArrayList<Tag> categorias) {
        this.categorias = categorias;
    }

    public void setUrlMidia(String urlMidia) {
        this.urlMidia = urlMidia;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "\nTítulo: "+titulo +
               "\nPublicado em: "+data.format(DateTimeFormatter.ofPattern("YYYY/MM/dd")).toString() +
               "\nDescrição: "+descricao +
               "\nCategorias: "+categorias.toString();
    }
}
