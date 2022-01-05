package br.com.alura.loja.tests;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoryDao;
import br.com.alura.loja.dao.ProductDao;
import br.com.alura.loja.model.Category;
import br.com.alura.loja.model.Product;
import br.com.alura.loja.util.JPAUtil;

public class CreateProduct {
	public static void main(String[] args) {
		Category smartphones = new Category("SMARTPHONES");		
		Product smartphone = new Product(
				"IPhone 26",
				"Apple smartphone with virtual reality",
				new BigDecimal("700"),
				smartphones
		);
		
		EntityManager em = JPAUtil.getEntityManager();
		CategoryDao categoryDao = new CategoryDao(em);
		ProductDao productDao = new ProductDao(em);
		
		em.getTransaction().begin();
		
		categoryDao.create(smartphones);
		productDao.create(smartphone);
		
		em.getTransaction().commit();
		em.close();
	}
}
