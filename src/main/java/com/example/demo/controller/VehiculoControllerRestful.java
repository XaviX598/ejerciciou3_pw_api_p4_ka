package com.example.demo.controller;

import java.util.List;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IVehiculoService;
import com.example.demo.service.to.VehiculoTO;

@RestController
@RequestMapping("/vehiculos")
@CrossOrigin
public class VehiculoControllerRestful {

	@Autowired
	private IVehiculoService iVehiculoService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<VehiculoTO>> consultarTodos() {
		List<VehiculoTO> lista = this.iVehiculoService.consultarTodosTO();
		for (VehiculoTO v : lista) {
			// primero construkmos el link de cada objeto estudianteTO
			Link myLink = linkTo(
					methodOn(VehiculoControllerRestful.class).consultarPorPlaca(v.getPlaca()))
					.withSelfRel();
			v.add(myLink);
		}
		return new ResponseEntity<>(lista, null, 200);

	}

	@GetMapping(path = "/{placa}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VehiculoTO> consultarPorPlaca(@PathVariable String placa) {
		return new ResponseEntity<>(this.iVehiculoService.consultarPorPlaca(placa), null, 200);
	}

}
