/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.david.repository;

import com.example.david.models.Voo;
import java.time.LocalDate;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author David
 */
public interface VooRepository extends JpaRepository<Voo, Long> {

    @Query("from Voo v where v.origem.id = ?1 AND v.destino.id=?2")
    public List<Voo> listVooOrigem(long origem, long destino);

    @Query("from Voo v where v.origem.id = ?1 AND v.destino.id=?2 AND v.datapartida = ?3")
    public List<Voo> listVooData(long origem, long destino, LocalDate date);

    @Query("from Voo v where v.origem.id = ?1 AND v.destino.id=?2 AND v.datapartida = ?3 AND v.preco = ?4")
    public List<Voo> listVooPreco(long origem, long destino, LocalDate date, Double preco);

}
