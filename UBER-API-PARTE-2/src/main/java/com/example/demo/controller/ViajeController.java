package com.example.demo.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Viaje;
import com.example.demo.repository.ViajeRepository;


@RestController
@RequestMapping(value="viajes")
public class ViajeController {
	
	@Autowired
	ViajeRepository repository;
	
	//GET Viaje
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public Collection<Viaje> getListaViajes(){
		Iterable<Viaje> listaViajes = repository.findAll();
		
		return (Collection<Viaje>) listaViajes;
		}
	
	//Viaje 
	@GetMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Viaje getViaje(@PathVariable(name = "id") Long id) {
		Optional<Viaje> Viaje = repository.findById(id);
		Viaje result = null;
		if(Viaje.isPresent()) {
			result = Viaje.get();
			}
			return result;	
		}
	
	//POST Viaje
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Viaje createViaje(@RequestBody Viaje viaje ) {
		Viaje nuevoViaje = repository.save(viaje);
		return nuevoViaje;
	}
	
	//PUT Viaje
	@PutMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public Viaje updateCliente(@PathVariable(name = "id") Long id, 
			@RequestBody Viaje viaje) {
			Optional<Viaje> oViaje = repository.findById(id);
			if(oViaje.isPresent()) {
				Viaje actual = oViaje.get(); 
				actual.setId(id);
				actual.setOrigen(viaje.getOrigen());
				actual.setDestino(viaje.getDestino());
				actual.setEstado(viaje.getEstado());
				actual.setMonto(viaje.getMonto());
				Viaje updatedViaje = repository.save(actual);
				return updatedViaje;
			}
			return null;
		}
}
