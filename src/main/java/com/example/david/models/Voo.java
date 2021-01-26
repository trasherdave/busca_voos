/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.david.models;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author David
 */
@Entity
public class Voo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Cidade origem;

    @ManyToOne
    private Cidade destino;

    @ManyToOne
    private Aviao aviao;

    @ManyToOne
    private Piloto piloto;

    @ManyToOne
    private Companhia companhia;

    private LocalDate datapartida;
    private LocalDate datachegada;
    private int numerovoo;
    private Double preco;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Cidade getOrigem() {
        return origem;
    }

    public void setOrigem(Cidade origem) {
        this.origem = origem;
    }

    public Cidade getDestino() {
        return destino;
    }

    public void setDestino(Cidade destino) {
        this.destino = destino;
    }

    public Aviao getAviao() {
        return aviao;
    }

    public void setAviao(Aviao aviao) {
        this.aviao = aviao;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public Companhia getCompanhia() {
        return companhia;
    }

    public void setCompanhia(Companhia companhia) {
        this.companhia = companhia;
    }

    public LocalDate getDatapartida() {
        return datapartida;
    }

    public void setDatapartida(LocalDate datapartida) {
        this.datapartida = datapartida;
    }

    public LocalDate getDatachegada() {
        return datachegada;
    }

    public void setDatachegada(LocalDate datachegada) {
        this.datachegada = datachegada;
    }

    public int getNumerovoo() {
        return numerovoo;
    }

    public void setNumerovoo(int numerovoo) {
        this.numerovoo = numerovoo;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

}
