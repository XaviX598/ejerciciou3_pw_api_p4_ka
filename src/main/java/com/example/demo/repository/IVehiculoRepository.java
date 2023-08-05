package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Vehiculo;

public interface IVehiculoRepository {
	
	public List<Vehiculo> consultarTodos();

	public Vehiculo consultarPorPlaca(String placa);

}
