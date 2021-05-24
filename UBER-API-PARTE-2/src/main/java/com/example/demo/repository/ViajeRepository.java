package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Viaje;

public interface ViajeRepository extends CrudRepository<Viaje, Long> {

	static List<Viaje>findByIdCliente(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	static List<Viaje> findByIdPiloto(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}