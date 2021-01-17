/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.david.controller;

import com.example.david.models.Voo;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.david.repository.VooRepository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author David
 */
@RestController
@Transactional
@RequestMapping(value = "/api")
public class VooResource {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    VooRepository vooRepository;

    //listar reserva do voo
    @GetMapping("/voo")
    public List<Voo> listVoo() {
        return vooRepository.findAll();
    }

    //cadastrar reserva do voo
    @PostMapping("/voo")
    public Voo cadastrarVoo(@RequestBody Voo voo) {

        return vooRepository.save(voo);

    }

    //alterar reserva do voo
    @PutMapping("/voo")
    public Voo atualizarVoo(@RequestBody Voo voo) {
        return vooRepository.save(voo);

    }

    //excluir reserva do voo
    @DeleteMapping("/voo/{id}")
    public void deletarVoo(@PathVariable("id") long id) {
        vooRepository.deleteById(id);

    }

    //consultar voos por origem e destino
    @GetMapping("/origem/{origem_id}/{destino_id}")
    public List<Voo> listVooOrigem(@PathVariable("origem_id") long origem, @PathVariable("destino_id") long destino) {
        Query query = em.createQuery("from Voo v where v.origem.id = ?1 AND v.destino.id=?2");
        query.setParameter(1, origem);
        query.setParameter(2, destino);
        return query.getResultList();
    }

    //consultar voos por origem, destino e data de partida
    @GetMapping("/data/{origem_id}/{destino_id}/{data_partida}")
    public List<Voo> listVooData(@PathVariable("origem_id") long origem, @PathVariable("destino_id") long destino, @PathVariable("data_partida") String date) {
        LocalDate data = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
        Query query = em.createQuery("from Voo v where v.origem.id = ?1 AND v.destino.id=?2 AND v.data_partida = ?3");
        query.setParameter(1, origem);
        query.setParameter(2, destino);
        query.setParameter(3, data);
        return query.getResultList();
    }

    //consultar voos por origem, destino, data de partida e faixa de preço
    @GetMapping("/valor/{origem_id}/{destino_id}/{data_partida}/{preco}")
    public List<Voo> listVooDestino(@PathVariable("origem_id") long origem, @PathVariable("destino_id") long destino, @PathVariable("data_partida") String dataString, @PathVariable("preco") Double preco) {
        LocalDate data = LocalDate.parse(dataString, DateTimeFormatter.ISO_DATE);
        Query query = em.createQuery("from Voo v where v.origem.id = ?1 AND v.destino.id=?2 AND v.data_partida = ?3 AND v.preco = ?4");
        query.setParameter(1, origem);
        query.setParameter(2, destino);
        query.setParameter(3, data);
        query.setParameter(4, preco);
        return query.getResultList();
    }

}
