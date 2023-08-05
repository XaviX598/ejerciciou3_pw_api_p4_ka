package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IVehiculoRepository;
import com.example.demo.repository.modelo.Vehiculo;
import com.example.demo.service.to.VehiculoTO;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

	@Autowired
	private IVehiculoRepository iVehiculoRepository;

	@Override
	public List<VehiculoTO> consultarTodosTO() {
		// TODO Auto-generated method stub
		List<Vehiculo> lista = this.iVehiculoRepository.consultarTodos();

		List<VehiculoTO> listaTO = lista.stream().map(vehiculo -> this.convertir(vehiculo))
				.collect(Collectors.toList());
		return listaTO;

	}

	@Override
	public VehiculoTO consultarPorPlaca(String placa) {
		// TODO Auto-generated method stub
		Vehiculo v = this.iVehiculoRepository.consultarPorPlaca(placa);
		return this.convertir(v);
	}

	private VehiculoTO convertir(Vehiculo v) {
		VehiculoTO vehi = new VehiculoTO();
		vehi.setColor(v.getColor());
		vehi.setId(v.getId());
		vehi.setMarca(v.getMarca());
		vehi.setModelo(v.getModelo());
		vehi.setPlaca(v.getPlaca());
		return vehi;
	}

}
