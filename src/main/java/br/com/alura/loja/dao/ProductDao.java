package br.com.alura.loja.dao;

import javax.persistence.EntityManager;

import br.com.alura.loja.model.Product;

public class ProductDao {
	
	private EntityManager em;
	
	public ProductDao(EntityManager em) {
		this.em = em;
	}
	
	public void create(Product product) {
		this.em.persist(product);
	}
}
