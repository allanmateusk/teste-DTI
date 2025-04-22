package com.example.teste_dti.models;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Estudante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ElementCollection
    @CollectionTable(name = "notas", joinColumns = @JoinColumn(name = "estudante_id"))
    @Column(name = "nota")
    private List<Double> notas = new ArrayList<>();

    private Double frequencia;

    public Estudante() { }

    public Estudante(String nome, List<Double> notas, Double frequencia) {
        this.nome = nome;
        this.notas = notas;
        this.frequencia = frequencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Double> getNotas() {
        return notas;
    }

    public void setNotas(List<Double> notas) {
        this.notas = notas;
    }

    public Double getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(Double frequencia) {
        this.frequencia = frequencia;
    }

    public double getMedia() {
        return notas.stream()
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .orElse(0.0);
    }
}