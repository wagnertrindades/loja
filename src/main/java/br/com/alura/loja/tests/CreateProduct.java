package br.com.alura.loja.tests;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.ProductDao;
import br.com.alura.loja.model.Product;
import br.com.alura.loja.util.JPAUtil;

public class CreateProduct {
	public static void main(String[] args) {
		Product smartphone = new Product();
		smartphone.setName("IPhone 26");
		smartphone.setDescription("Apple smartphone with virtual reality");
		smartphone.setPrice(new BigDecimal("700"));
		
		EntityManager em = JPAUtil.getEntityManager();
		ProductDao productDao = new ProductDao(em);
		
		em.getTransaction().begin();
		productDao.create(smartphone);
		em.getTransaction().commit();
		em.close();
	}
}
