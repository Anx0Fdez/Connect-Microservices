package org.examen.examenad.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "grupos")
public class Grupo {

    @Id
    private String id;

    @JsonProperty("nome")
    private String nome;


    @JsonProperty("xenero")
    private String xenero;

    @JsonProperty("dataFormacion")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataFormacion;

    public Grupo(String id, String nome, String xenero, LocalDate dataFormacion) {
        this.id = id;
        this.nome = nome;
        this.xenero = xenero;
        this.dataFormacion = dataFormacion;
    }

    public Grupo(String nome, String xenero, LocalDate dataFormacion) {
        this.nome = nome;
        this.xenero = xenero;
        this.dataFormacion = dataFormacion;
    }

    public Grupo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getXenero() {
        return xenero;
    }

    public void setXenero(String xenero) {
        this.xenero = xenero;
    }

    public LocalDate getDataFormacion() {
        return dataFormacion;
    }

    public void setDataFormacion(LocalDate dataFormacion) {
        this.dataFormacion = dataFormacion;
    }
}