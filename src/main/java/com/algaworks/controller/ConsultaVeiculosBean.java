package com.algaworks.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.modelo.Veiculo;
import com.algaworks.repository.Veiculos;

@Named
@ViewScoped
public class ConsultaVeiculosBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Veiculo> listaVeiculos;
	
	@Inject
	private Veiculos veiculos;
	
	public void prepararVeiculos() {
		this.listaVeiculos = this.veiculos.todos();
	}

	public List<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}

}
