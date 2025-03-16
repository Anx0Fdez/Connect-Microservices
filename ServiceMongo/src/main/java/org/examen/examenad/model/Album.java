package org.examen.examenad.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "albums")
public class Album {

    @Id
    private String id;

    @JsonProperty("grupo_id")
    private String grupo_id;

    @JsonProperty("titulo")
    private String titulo;

    @JsonProperty("data_lanzamento")
    private LocalDate data_lanzamento;

    @JsonProperty("puntuacion")
    private float puntuacion;

    public Album(String id, String grupo_id, String titulo, LocalDate data_lanzamento, float puntuacion) {
        this.id = id;
        this.grupo_id = grupo_id;
        this.titulo = titulo;
        this.data_lanzamento = data_lanzamento;
        this.puntuacion = puntuacion;
    }

    public Album(String grupo_id, String titulo, LocalDate data_lanzamento, float puntuacion) {
        this.grupo_id = grupo_id;
        this.titulo = titulo;
        this.data_lanzamento = data_lanzamento;
        this.puntuacion = puntuacion;
    }

    public Album() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGrupo_id() {
        return grupo_id;
    }

    public void setGrupo_id(String grupo_id) {
        this.grupo_id = grupo_id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getData_lanzamento() {
        return data_lanzamento;
    }

    public void setData_lanzamento(LocalDate data_lanzamento) {
        this.data_lanzamento = data_lanzamento;
    }

    public float getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(float puntuacion) {
        this.puntuacion = puntuacion;
    }
}
