package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Piloto;

public interface PilotoRepository extends CrudRepository<Piloto, Long>  {

}
