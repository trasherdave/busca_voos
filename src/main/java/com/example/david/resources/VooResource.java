package com.example.david.resources;

import com.example.david.models.Voo;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.david.repository.VooRepository;

/**
 *
 * @author David
 */
@RestController
@Transactional
@RequestMapping(value = "/voo")
public class VooResource {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    VooRepository repository;

    //listar reserva do voo
    @GetMapping("/listar")
    public List<Voo> listar() {
        return repository.findAll();
    }

    //cadastrar reserva do voo
    @PostMapping("/cadastrar")
    public Voo cadastrar(@RequestBody Voo voo) {

        return repository.save(voo);

    }

    //alterar reserva do voo
    @PutMapping("/atualizar")
    public Voo atualizar(@RequestBody Voo voo) {
        return repository.save(voo);

    }

    //excluir reserva do voo
    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable("id") long id) {
        repository.deleteById(id);

    }

    @GetMapping("/origem/{origem}/{destino}")
    public List<Voo> listarOrigem(@PathVariable("origem") long origem, @PathVariable("destino") long destino) {
        return repository.listVooOrigem(origem, destino);
    }

    @GetMapping("/data/{origem}/{destino}/{datapartida}")
    public List<Voo> listarData(@PathVariable("origem") long origem, @PathVariable("destino") long destino, @PathVariable("datapartida") String date) {
        LocalDate data = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
        return repository.listVooData(origem, destino, data);
    }

    @GetMapping("/valor/{origem}/{destino}/{datapartida}/{preco}")
    public List<Voo> listarPreco(@PathVariable("origem") long origem, @PathVariable("destino") long destino, @PathVariable("datapartida") String date, @PathVariable("preco") Double preco) {
        LocalDate data = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
        return repository.listVooPreco(origem, destino, data, preco);
    }

}
