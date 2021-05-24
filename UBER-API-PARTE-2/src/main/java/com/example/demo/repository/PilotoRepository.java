package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Piloto;
import com.example.demo.entities.Viaje;

public interface PilotoRepository extends CrudRepository<Piloto, Long>  {

	static List<Viaje>findByIdPiloto(Long id) {
		// TODO Auto-generated method stub
		return null;
}
}
