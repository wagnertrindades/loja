package br.com.alura.loja.tests;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.ProductDao;
import br.com.alura.loja.model.Category;
import br.com.alura.loja.model.Product;
import br.com.alura.loja.util.JPAUtil;

public class CreateProduct {
	public static void main(String[] args) {
		Product smartphone = new Product(
				"IPhone 26",
				"Apple smartphone with virtual reality",
				new BigDecimal("700"),
				Category.SMARTPHONES
		);
		
		EntityManager em = JPAUtil.getEntityManager();
		ProductDao productDao = new ProductDao(em);
		
		em.getTransaction().begin();
		productDao.create(smartphone);
		em.getTransaction().commit();
		em.close();
	}
}
