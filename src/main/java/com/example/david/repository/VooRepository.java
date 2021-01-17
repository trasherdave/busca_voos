/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.david.repository;

import com.example.david.models.Voo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author David
 */
public interface VooRepository extends JpaRepository<Voo, Long> {
    Voo findById(long id);
}
