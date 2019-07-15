package org.pusillusgrex.pusilluxgrexapp.models;

public enum Tag {
    AULAS("Aulas"),
    ESPIRITUALIDADE("Espiritualidade e Formação"),
    EVENTOS("Eventos"),
    FOTOS("Fotos"),
    IBP("IBP pelo Mundo"),
    LITURGIA("Liturgia"),
    PUSILLUS("Pusillus"),
    SERMOES("Sermões"),
    DESCONHECIDO("");

    private final String categoria;

    private Tag(String categoria){
        this.categoria = categoria;
    }

    @Override
    public String toString(){
        return this.categoria;
    }
}
