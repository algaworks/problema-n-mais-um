package com.algaworks.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.algaworks.modelo.Veiculo;

public class Veiculos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	public List<Veiculo> todos() {
		//return this.manager.createQuery("from Veiculo v join fetch v.proprietario", Veiculo.class).getResultList();
		
		CriteriaBuilder builder = this.manager.getCriteriaBuilder();
		CriteriaQuery<Veiculo> criteriaQuery = builder.createQuery(Veiculo.class);
		
		Root<Veiculo> veiculo = criteriaQuery.from(Veiculo.class);
		veiculo.fetch("proprietario");
		criteriaQuery.select(veiculo);
		
		TypedQuery<Veiculo> query = this.manager.createQuery(criteriaQuery);
		return query.getResultList();
	}
	
}
