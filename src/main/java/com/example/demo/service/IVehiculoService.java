package com.example.demo.service;

import java.util.List;

import com.example.demo.service.to.VehiculoTO;

public interface IVehiculoService {

	public List<VehiculoTO> consultarTodosTO();

	public VehiculoTO consultarPorPlaca(String placa);

}
